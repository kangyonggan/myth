(function (factory) {
    if (typeof define === "function" && define.amd) {
        define(["", "jquery-validator"], factory);
    } else {
        factory(jQuery);
    }
}(function ($) {
    /*
     * Translated default messages for the jQuery validation plugin.
     * Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
     */
    $.extend($.validator.messages, {
        required: "这是必填字段",
        remote: "已被占用",
        email: "请输入有效的电子邮件地址",
        url: "请输入有效的网址",
        date: "请输入有效的日期",
        dateISO: "请输入有效的日期 (YYYY-MM-DD)",
        number: "请输入有效的数字",
        digits: "只能输入数字",
        creditcard: "请输入有效的信用卡号码",
        equalTo: "两次输入不一致",
        extension: "请输入有效的后缀",
        maxlength: $.validator.format("最多可以输入 {0} 个字符"),
        minlength: $.validator.format("最少要输入 {0} 个字符"),
        rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
        range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
        max: $.validator.format("请输入不大于 {0} 的数值"),
        min: $.validator.format("请输入不小于 {0} 的数值")
    });
}));

//下面是自定义校验
$.extend($.validator.addMethod("isUsername", function (value) {
    var str = /^[a-z][0-9a-z]{4,19}$/;
    return str.test(value);
}, "请输入5至20位以字母开头的小写字母和数字的组合"));

$.extend($.validator.addMethod("isPassword", function (value) {
    var str = /[a-zA-Z0-9]{6,20}$/;
    return str.test(value);
}, "请输入6至20位字母和数字的组合"));

$.extend($.validator.addMethod("isCaptcha", function (value) {
    var str = /^[0-9]{4}$/;
    return str.test(value);
}, "请输入4位数字的验证码"));

$.extend($.validator.addMethod("isFullname", function (value) {
    var str = /^[\u4E00-\u9FA5]{2,4}$/;
    return str.test(value);
}, "请输入2至4个汉字"));

$.extend($.validator.addMethod("isIdCard", function (value) {
    var str = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    return str.test(value);
}, "请输入正确的18位身份证号码"));

$.extend($.validator.addMethod("isRoleCode", function (value) {
    var str = /^ROLE[A-Z_]{0,28}$/;
    return str.test(value);
}, "以ROLE开头,纯大写,可带下划线,不超过32位"));

$.extend($.validator.addMethod("isName", function (value) {
    var str = /^[\u4E00-\u9FA5]{2,12}$/;
    return str.test(value);
}, "请输入2至12个汉字"));

$.extend($.validator.addMethod("isMenuCode", function (value) {
    var str = /^[A-Z_]{1,32}$/;
    return str.test(value);
}, "纯大写,可带下划线,不超过32位"));

$.extend($.validator.addMethod("isMenuUrl", function (value) {
    var str = /^[a-z\/]{1,32}$/;
    return str.test(value);
}, "纯小写,可带斜杠,不超过32位"));

$.extend($.validator.addMethod("isMobile", function(value, element) {
    var length = value.length;
    var mobile = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
}, "请正确填写您的手机号码"));
