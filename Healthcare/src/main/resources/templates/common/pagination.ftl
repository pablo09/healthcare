<#macro pagination data url pagelinkclass="pagelink">
    <#if data.totalPages gt 1>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link ${pagelinkclass} ${data.first?then('disabled', '')}" href="${url}" page="${data.number}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <#list 1..data.totalPages as page>
                    <li class="page-item"><a class="page-link ${pagelinkclass} <#if page == data.number>active</#if>" page="${page}" href="${url}">${page}</a></li>
                </#list>
                <li class="page-item" style="${data.last?then('display: none', '')}">
                    <a class="page-link ${pagelinkclass}" href="${url}" aria-label="Next"  page = "${data.number + 2}">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </#if>
</#macro>
