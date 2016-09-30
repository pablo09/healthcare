<!-- THIS FILE SHOULD NOT BE MODIFIED !!!-->
<!-- This project uses spring-message-to-js-maven-plugin which takes spring message file(/resources/messages/messages.properties)
and creates exact same messages to use for frontend purposes.
Message code is prepented by the phrace 'msg.' f.e. instead of cart.buy it is msg.cart.buy -->
<#import "/spring.ftl" as spring />

<#macro messages>
<script>
    var msg = {};
    MESSAGE_TEMPLATE
</script>
</#macro>
