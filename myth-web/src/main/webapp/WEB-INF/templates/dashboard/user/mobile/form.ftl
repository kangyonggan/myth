<#assign ctx="${(rca.contextPath)!''}">

<div class="space-10"></div>
<form id="mobile-form" method="post" class="form-horizontal" action="${ctx}/dashboard/user/mobile/update">

    <input type="hidden" id="code" name="code" value=""/>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">新手机号<span class="red">*</span></label>
        <div class="col-xs-12 col-sm-5">
            <input type="text" class="form-control" id="mobile" name="mobile" placeholder="请输入11位数字的手机号码"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">验证码<span class="red">*</span></label>
        <div class="col-xs-12 col-sm-5">
            <input type="text" id="captcha" name="captcha" class="col-xs-6" placeholder="请输入4位数字的验证码"
                   autocomplete="off">
            <img onclick="this.src='${ctx}/captcha?'+Math.random();" src="${ctx}/captcha">
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">校验码<span class="red">*</span></label>
        <div class="col-xs-12 col-sm-5">
            <input type="text" id="token" name="token" class="col-xs-6" placeholder="请输入手机短信中的校验码" autocomplete="off">
            <button type="button" class="btn btn-inverse btn-sm" id="send"><i
                    class="ace-icon fa fa-mobile bigger-130"></i>获取校验码
            </button>
        </div>
    </div>

    <div class="clearfix form-actions">
        <div class="col-xs-offset-3">
            <button id="submit" class="btn btn-inverse" data-loading-text="正在提交...">
                <i class="ace-icon fa fa-check"></i>
            <@spring.message "app.button.save"/>
            </button>
        </div>
    </div>
</form>

<script src="${ctx}/static/app/js/dashboard/user/mobile/form.js"></script>
