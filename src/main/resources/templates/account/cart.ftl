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
                    </tr>
                    <#list items as item>
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.quantity}</td>
                            <td>${item.price.denomination} ${item.price.currency}</td>
                        </tr>
                    <#else>
                        <tr>
                            <td colspan="3"></td> No items</td>
                        </tr>
                    </#list>

                </table>
            </div>

        </div>
    </div>

</div>
</@template.page>