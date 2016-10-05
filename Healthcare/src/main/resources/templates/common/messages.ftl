<!-- THIS FILE SHOULD NOT BE MODIFIED !!!-->
<!-- This project uses spring-message-to-js-maven-plugin which takes spring message file(/resources/messages/messages.properties)
and creates exact same messages to use for frontend purposes.
Message code is prepented by the phrace 'msg.' f.e. instead of cart.buy it is msg.cart.buy -->
<#import "/spring.ftl" as spring />

<#macro messages>
<script>
    var msg = {};
    msg.cart = {};

msg.table = {};

msg.account = {};

msg.cart.add = {};

msg.account.login = {};
msg.account.password = "<@spring.message 'account.password'/>";
msg.account.sign = "<@spring.message 'account.sign'/>";
msg.cart.add.error = "<@spring.message 'cart.add.error'/>";
msg.invoice = "<@spring.message 'invoice'/>";
msg.totalPrice = "<@spring.message 'totalPrice'/>";
msg.state = "<@spring.message 'state'/>";
msg.quantity = "<@spring.message 'quantity'/>";
msg.buy = "<@spring.message 'buy'/>";
msg.cart.add.success = "<@spring.message 'cart.add.success'/>";
msg.availability = "<@spring.message 'availability'/>";
msg.account.remember = "<@spring.message 'account.remember'/>";
msg.account.login.error = "<@spring.message 'account.login.error'/>";
msg.account.label = "<@spring.message 'account.label'/>";
msg.category = "<@spring.message 'category'/>";
msg.price = "<@spring.message 'price'/>";
msg.description = "<@spring.message 'description'/>";
msg.table.sum = "<@spring.message 'table.sum'/>";
msg.sellDate = "<@spring.message 'sellDate'/>";
msg.account.email = "<@spring.message 'account.email'/>";
msg.name = "<@spring.message 'name'/>";

</script>
</#macro>