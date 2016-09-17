<#macro pagination first last current total url>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link pagelink ${first?then('disabled', '')}" href="${url}" page="${current}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <#list 1..total as page>
                <li class="page-item"><a class="page-link pagelink <#if page == current>active</#if>" page="${page}" href="${url}">${page}</a></li>
            </#list>
            <li class="page-item" style="${last?then('display: none', '')}">
                <a class="page-link pagelink" href="${url}" aria-label="Next"  page = "${current + 2}">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
</#macro>
