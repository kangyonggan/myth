<#assign ctx="${(rca.contextPath)!''}">

<tr id="article-${article.id}">
    <td>${article.id}</td>
    <td>${article.title}</td>
    <td>${article.tags}</td>
    <td><#include "delete.ftl"></td>
    <td><@c.relative_date datetime=article.createdTime/></td>
    <td>
        <div class="btn-group">
            <a class="btn btn-xs btn-inverse" href="#user/article/${article.id}">查看</a>

            <button data-toggle="dropdown" class="btn btn-xs btn-inverse dropdown-toggle">
                <span class="ace-icon fa fa-caret-down icon-only"></span>
            </button>

            <ul class="dropdown-menu dropdown-menu-right dropdown-inverse">
                <li>
                    <a href="#user/article/${article.id}/edit">编辑</a>
                </li>
                <#if article.isDeleted==1>
                    <li>
                        <a href="javascript:" data-role="article-remove" title="彻底删除文章"
                           data-url="${ctx}/dashboard/user/article/${article.id}/remove">
                            物理删除
                        </a>
                    </li>
                </#if>
            </ul>
        </div>
    </td>
</tr>