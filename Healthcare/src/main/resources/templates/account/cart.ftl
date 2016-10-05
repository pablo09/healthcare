<#import "../common/templatePage.ftl" as template>
<#import "/spring.ftl" as spring />

<@template.page>
<div class="panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-md-8">
                <table class="table table-bordered">
                    <tr>
                        <th><@spring.message 'name'/></th>
                        <th><@spring.message 'quantity'/></th>
                        <th><@spring.message 'price'/></th>
                        <th><@spring.message 'totalPrice'/></th>
                    </tr>
                    <#list totalOrder.orders as item>
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.quantity}</td>
                            <td>${item.price.denomination} ${item.price.currency}</td>
                            <td>${item.totalPrice.denomination} ${item.totalPrice.currency}</td>
                        </tr>
                    <#else>
                        <tr>
                            <td colspan="4">No items</td>
                        </tr>
                    </#list>
                    <#if totalOrder.orders?has_content>
                        <tr>
                            <td colspan="2"><b><@spring.message 'table.sum'/></b></td>
                            <td colspan="2"><b>${totalOrder.ordersTotalPrice.denomination} ${totalOrder.ordersTotalPrice.currencyCode}</b></td>
                        </tr>
                    </#if>
                </table>
                <form action="/cart/finalize" method="POST">
                    <button type="submit" class="pagelinkBySellDate">SUBMIT</button>
                </form>
            </div>

        </div>
    </div>

</div>
</@template.page>