<#import "header.ftl" as h/>
<#import "footer.ftl" as f/>
<#import "sidebar.ftl" as s/>
<#import "messages.ftl" as m/>
<#macro page>
<!DOCTYPE html>

<html>
<head>
    <title></title>
    <@h.scripts/>
    <@m.messages/>
</head>
<body>
    <@h.header></@h.header>
    <div class="container-fluid" id="main">
            <@s.sidebar/>
            <div class="col-md-9 col-lg-10 main">
                <#nested>
            </div>
        </div>
    </div>
<@f.footer/>
</body>

</html>
</#macro>