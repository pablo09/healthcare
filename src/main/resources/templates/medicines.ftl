<#import "common/templatePage.ftl" as template>

<@template.page>
    <div class="album text-muted">
        <div class="container">

            <div class="row">
                <#list medicines.content as medicine>
                    <div class="card">
                        <img alt="100%x280" style="height: 280px; width: 100%; display: block;" src="${medicine.imgLocation}" data-holder-rendered="true">
                        <p class="card-text">${medicine.description}</p>
                    </div>
                </#list>
            </div>

        </div>
    </div>
</@template.page>
