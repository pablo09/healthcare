<#import "common/templatePage.ftl" as template>
<#import "common/pagination.ftl" as p>
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
            <@p.pagination first=medicines.first last=medicines.last current=medicines.number total=medicines.totalPages url='medicine'/>
        </div>
    </div>
</@template.page>
