<#import "../common/templatePage.ftl" as template>

<@template.page>
<h1>Hello ${username}</h1>
<a href="/account/cart"> Cart</a>
<a href="/cart/history" class="pagelinkBySellDate">Order history</a>
</@template.page>