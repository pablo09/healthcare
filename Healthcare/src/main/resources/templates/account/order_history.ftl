<#import "../common/templatePage.ftl" as template>
<#import "../common/pagination.ftl" as p>
<#import "/spring.ftl" as spring />

<@template.page>
<div class="panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-md-8">
                <table class="table table-bordered">
                    <tr>
                        <th><@spring.message 'state'/></th>
                        <th><@spring.message 'sellDate'/></th>
                        <th><@spring.message 'invoice'/></th>
                    </tr>
                    <#list history.content as order>
                        <tr>
                            <td>${order.state}</td>
                            <td>${order.sellDate}</td>
                            <td>Invoice link</td>
                        </tr>
                    <#else>
                        <tr>
                            <td colspan="3">No items</td>
                        </tr>
                    </#list>

                </table>

            </div>

        </div>
    </div>
    <@p.pagination data=history url='/cart/history' pagelinkclass='pagelinkBySellDate'/>

</div>
</@template.page>