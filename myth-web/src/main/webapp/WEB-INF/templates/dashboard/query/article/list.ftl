<#assign ctx="${(rca.contextPath)!''}">
<#assign tag = RequestParameters.tag!'' />
<#assign title = RequestParameters.title!'' />
<#assign username = RequestParameters.username!'' />

<div class="space-10"></div>

<form class="form-inline" method="get">
    <div class="form-group">
        <select class="form-control" name="tag">
            <option value="">--全部标签--</option>
            <#list tags as t>
                <option value="${t.code}" <#if tag==t.code>selected</#if>>${t.value}</option>
            </#list>
        </select>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="username" value="${username}" placeholder="用户名"
               autocomplete="off"/>
    </div>
    <div class="form-group">
        <input type="text" class="form-control" name="title" value="${title}" placeholder="标题"
               autocomplete="off"/>
    </div>

    <button class="btn btn-sm btn-inverse" data-toggle="search-submit">
        搜索
        <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
    </button>
</form>

<div class="space-10"></div>

<table id="article-table" class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>标签</th>
        <th>逻辑删除</th>
        <th>发布人</th>
        <th>发布时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <#if page.list?size gt 0>
        <#list page.list as article>
            <#include "table-tr.ftl"/>
        </#list>
    <#else>
    <tr>
        <td colspan="20">
            <div class="empty">暂无查询记录</div>
        </td>
    </tr>
    </#if>
    </tbody>
</table>
<@c.pagination url="#query/article" param="tag=${tag}&title=${title}&username=${username}"/>

<script src="${ctx}/static/app/js/dashboard/query/article/list.js"></script>
