<#import "../common/templatePage.ftl" as template>
<#import "/spring.ftl" as spring />

<@template.page>
<div class="panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-md-4">
                <table class="table table-bordered">
                    <tr>
                        <td><@spring.message 'name'/></td>
                        <td>${item.name}</td>
                    </tr>
                    <tr>
                        <td><@spring.message 'category'/></td>
                        <td>${item.category}</td>
                    </tr>
                    <tr>
                        <td><@spring.message 'price'/></td>
                        <td>${item.price.denomination} ${item.price.currency}</td>
                    </tr>
                    <tr>
                        <td><@spring.message 'description'/></td>
                        <td>${item.description}</td>
                    </tr>
                </table>
            </div>
            <div class="col-md-6">
                <img alt="100%x280" style="height: 280px; width: 100%; display: block;" src="${item.imgLocation}" data-holder-rendered="true">
            </div>
        </div>
    </div>
    <form action="/api/cart/" method="POST">
        <input type="hidden" name="medicineId" value="${item.id}"/>
        <input type="number" name="quantity" minlength="1"/>
        <button class="btn btn-primary" type="submit"><@spring.message 'buy'/></button>
    </form>
</div>
</@template.page>