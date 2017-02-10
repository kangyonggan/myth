<#assign ctx="${(rca.contextPath)!''}">

<@override name="content">
<div class="position-relative">
    <div id="forgot-box" class="forgot-box widget-box fa-border">
        <div class="widget-body">
            <div class="widget-main clearfix">
                <h4 class="header lighter bigger skin-color">
                    <i class="ace-icon fa fa-key skin-color"></i>
                    找回密码
                </h4>

                <div class="space-14"></div>

                <form id="reset-form" method="post" action="${ctx}/reset/mobile">
                    <input type="hidden" name="code" id="code" value=""/>

                    <div class="form-group clearfix">
                        <label class="col-xs-12 control-label no-padding-right">
                            手机<span class="red">*</span>
                            <span class="pull-right">
                                切换到
                                <a href="#reset/email">邮箱</a>
                            </span>
                        </label>
                        <div class="col-xs-12">
                            <span class="block input-icon input-icon-right">
                                <input type="text" id="mobile" name="mobile" class="form-control" placeholder="请输入手机"/>
                                <i class="ace-icon fa fa-mobile"></i>
                            </span>
                        </div>
                    </div>

                    <div class="space-14"></div>

                    <div class="form-group clearfix">
                        <label class="col-xs-12 control-label no-padding-right">验证码<span class="red">*</span></label>
                        <div class="col-xs-7">
                        <span class="block input-icon input-icon-right">
                            <input value="" type="text" id="captcha" name="captcha" class="form-control"
                                   placeholder="请输入4位数字的验证码" autocomplete="off">
                            <i class="ace-icon fa fa-times-circle hide"></i>
                        </span>
                        </div>
                        <div class="col-xs-5">
                            <img id="captcha-img" onclick="this.src='${ctx}/captcha?' + Math.random();"
                                 src="${ctx}/captcha"/>
                        </div>
                    </div>

                    <div class="space-14"></div>

                    <div class="form-group clearfix">
                        <label class="col-xs-12 control-label no-padding-right">校验码<span class="red">*</span></label>

                        <div class="col-xs-12">
                            <span class="block input-icon input-icon-right">
                                <input type="text" id="token" name="token" class="col-xs-8" placeholder="请输入手机短信中的校验码"/>
                            <button type="button" class="btn btn-inverse btn-sm" id="send"><i
                                    class="ace-icon fa fa-mobile bigger-130"></i>获取校验码
                            </button>
                            </span>
                        </div>
                    </div>

                    <div class="space-14"></div>

                    <div class="col-xs-4 col-xs-offset-8">
                        <button id="submit" class="btn btn-sm width-100 btn-inverse" data-loading-text="正在提交...">提交
                        </button>
                    </div>
                </form>
            </div>

            <div class="toolbar center">
                <a href="#login" data-target="#login-box" class="back-to-login-link">
                    去登录
                    <i class="ace-icon fa fa-arrow-right"></i>
                </a>
            </div>
        </div>
    </div>
</div>
</@override>

<@override name="script">
<script src="${ctx}/static/app/js/web/auth/reset-mobile.js"></script>
</@override>

<@extends name="../auth-layout.ftl"/>