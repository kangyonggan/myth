<#assign ctx="${(rca.contextPath)!''}">
<#assign mobile = RequestParameters.mobile!'' />

<div class="space-10"></div>

<form class="form-inline" method="get">
    <div class="form-group">
        <input type="text" class="form-control" name="mobile" value="${mobile}" placeholder="手机号码"
               autocomplete="off"/>
    </div>

    <button class="btn btn-sm btn-inverse" data-toggle="search-submit">
        搜索
        <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
    </button>
</form>

<div class="space-10"></div>

<table id="sms-table" class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <th>ID</th>
        <th>手机号码</th>
        <th>验证码</th>
        <th>短信代码</th>
        <th>发送时间</th>
        <th>失效时间</th>
        <th>响应结果</th>
        <th width="40%">服务端数据</th>
    </tr>
    </thead>
    <tbody>
    <#if page.list?size gt 0>
        <#list page.list as sms>
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
<@c.pagination url="#query/sms" param="mobile=${mobile}"/>

<script src="${ctx}/static/app/js/dashboard/query/sms/list.js"></script>
