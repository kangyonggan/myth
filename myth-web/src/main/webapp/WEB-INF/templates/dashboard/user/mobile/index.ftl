<#assign ctx="${(rca.contextPath)!''}">

<div class="space-10"></div>

<#if user.mobile != ''>
<div class="alert alert-block alert-success">

    <i class="ace-icon fa fa-check green"></i>

    您已绑定了手机${user.mobile} [您的手机号可以直接用于登录、找回密码等]

    <a href="#user/mobile/edit" class="pull-right">设置</a>
</div>
<#else>
<div class="alert alert-block alert-danger">

    <i class="ace-icon fa fa-remove red"></i>

    您暂未绑定手机 [绑定后的手机号可以直接用于登录、找回密码等]

    <a href="#user/mobile/edit" class="pull-right">设置</a>
</div>
</#if>

<script src="${ctx}/static/app/js/dashboard/user/mobile/index.js"></script>
