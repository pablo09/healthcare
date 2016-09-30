<!-- THIS FILE SHOULD NOT BE MODIFIED !!!-->
<!-- This project uses spring-message-to-js-maven-plugin which takes spring message file(/resources/messages/messages.properties)
and creates exact same messages to use for frontend purposes.
Message code is prepented by the phrace 'msg.' f.e. instead of cart.buy it is msg.cart.buy -->
<#import "/spring.ftl" as spring />

<#macro messages>
<script>
    var msg = {};
    msg.cart = {};

msg.account = {};

msg.cart.add = {};

msg.account.login = {};
msg.name = "<@spring.message 'name'/>";
msg.account.sign = "<@spring.message 'account.sign'/>";
msg.category = "<@spring.message 'category'/>";
msg.cart.add.success = "<@spring.message 'cart.add.success'/>";
msg.quantity = "<@spring.message 'quantity'/>";
msg.availability = "<@spring.message 'availability'/>";
msg.buy = "<@spring.message 'buy'/>";
msg.price = "<@spring.message 'price'/>";
msg.account.remember = "<@spring.message 'account.remember'/>";
msg.cart.add.error = "<@spring.message 'cart.add.error'/>";
msg.account.password = "<@spring.message 'account.password'/>";
msg.account.email = "<@spring.message 'account.email'/>";
msg.description = "<@spring.message 'description'/>";
msg.totalPrice = "<@spring.message 'totalPrice'/>";
msg.account.login.error = "<@spring.message 'account.login.error'/>";
msg.account.label = "<@spring.message 'account.label'/>";

</script>
</#macro>