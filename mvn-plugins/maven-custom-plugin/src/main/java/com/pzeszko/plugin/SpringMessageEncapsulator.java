package com.pzeszko.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Pawel on 2016-09-29.
 * This custom plugin takes spring messages as an input and creates exact same messages in Javascript file so they could be also used for frontend purposes.

 */
@Mojo(name = "spring-message-encapsulator")
public class SpringMessageEncapsulator extends AbstractMojo {

    /**
     * Location of spring message file
     */
    @Parameter(property = "spring-message-encapsulator.springMessageLocation", defaultValue = "")
    private String springMessageLocation;

    /**
     * Location of message template file
     */
    @Parameter(property = "spring-message-encapsulator.jsScriptTemplateLocation", defaultValue = "")
    private String jsScriptTemplateLocation;

    /**
     * Location of destination file where messages should be put. Note that in this file should exists phrase 'MESSAGE_TEMPLATE' which after compilation
     * will be replaced by spring messages. Message codes will be prepented by 'msg.' f.e. instaed of 'cart.buy' it will be 'msg.cart.buy'
     */
    @Parameter(property = "spring-message-encapsulator.jsScriptLocation", defaultValue = "")
    private String jsScriptLocation;

    private static final String BLANK_JS_OBJ = "%s = {};\n";
    private static final String MESSAGE_TEMPLATE = "MESSAGE_TEMPLATE";
    private static final String SPRING_MESSAGE_TEMPLATE = "msg.%s = \"<@spring.message '%s'/>\";\n";

    public void execute() throws MojoExecutionException {
        Properties prop = new Properties();
        String destinationContent = null;
        FileWriter destinationWriter = null;

        try {
            destinationContent = Files.lines(Paths.get(jsScriptTemplateLocation)).collect(Collectors.joining("\n"));
            prop.load(new FileInputStream(new File(springMessageLocation)));
            destinationWriter = new FileWriter(new File(jsScriptLocation));
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder messagePart = new StringBuilder(buildMissingJsObjects(prop));

        for (String name : prop.stringPropertyNames()) {
            messagePart.append(String.format(SPRING_MESSAGE_TEMPLATE, name, name));
        }
        destinationContent = destinationContent.replace(MESSAGE_TEMPLATE, messagePart);
        try {
            destinationWriter.write(destinationContent);
            destinationWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Builds missing JS objects which may not exists due to the fact that message syntax is not JS syntax
     * @param properties Properties file
     */
    private String buildMissingJsObjects(Properties properties) {
        Set<String> propsToAdd = new TreeSet<>();
        for (String name : properties.stringPropertyNames()) {
            if (name.contains(".")) {
                String[] parts = name.split("\\.");
                for (int i = 0; i < parts.length; i++) {
                    if (!properties.stringPropertyNames().contains(buildProp(parts, i))) {
                        propsToAdd.add(String.format("msg.%s", buildProp(parts, i)));
                    }
                }
            }
        }
        List<String> sortedProps = propsToAdd.stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                       if(o1.length() > o2.length()) return 1;
                       else if(o1.length() < o2.length()) return -1;
                       else return 0;
                    }
                })
                .collect(Collectors.toList());

        return initMissingJsObjects(sortedProps);
    }

    /**
     * Creates string containing initilized json objects coressponding to properties
     * @param propsToAdd List of properties which should be initizled manually
     * @return String containing manually initilized objects
     */
    private String initMissingJsObjects(List<String> propsToAdd) {
        return propsToAdd.stream()
                .map(prop -> String.format(BLANK_JS_OBJ, prop))
                .collect(Collectors.joining("\n"));
    }

    /**
     * Builds property name
     * @param parts Array containing property names splitted by dot (.)
     * @param idx Property depth, f.e. if complete property is a.b.c for idx = 1 it will be a.b and for idx = 2 it will be a.b.c
     * @return Property name
     */
    private String buildProp(String[] parts, int idx) {
        if (parts.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
            sb.append(String.format("%s.", parts[i]));
        }

        return sb.substring(0, sb.length() - 1);
    }
}
