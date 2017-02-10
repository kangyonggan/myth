$(function () {
    var $form = $('#reset-form');
    var $btn = $("#submit");
    var $send = $("#send");

    $form.validate({
        rules: {
            mobile: {
                required: true,
                isMobile: true
            },
            captcha: {
                required: true,
                isCaptcha: true
            },
            token: {
                required: true
            }
        },
        submitHandler: function () {
            $btn.button('loading');
            $form.ajaxSubmit({
                dataType: 'json',
                success: function (response) {
                    if (response.errCode == "success") {
                        window.location.href = ctx + response.errMsg;
                    } else {
                        Message.error(response.errMsg);
                        $btn.button('reset');
                    }
                },
                error: function () {
                    Message.error("服务器内部错误，请稍后再试。");
                    $btn.button('reset');
                }
            });
            return false;
        },
        errorPlacement: function (error, element) {
            error.appendTo(element.parent());
        },
        errorElement: "div",
        errorClass: "error"
    });

    $send.click(function () {
        var mobile = $("#mobile").val();
        var captcha = $("#captcha").val();

        $send.attr("disabled", true);
        $.get(ctx + "/send?mobile=" + mobile + "&captcha=" + captcha, function (data) {
            data = eval('(' + data + ')');

            if (data.errCode != 'success') {
                Message.error(data.errMsg);
                $send.removeAttr("disabled");
            } else {
                Message.success("发送成功！");

                $("#code").val(data.code);

                var time = 120;
                var t = setInterval(function () {
                    time--;
                    $send.html("<i class='ace-icon fa fa-mobile bigger-130'></i>" + time + "秒");
                    if (time == 0) {
                        $send.html("<i class='ace-icon fa fa-mobile bigger-130'></i>重新获取");
                        $send.removeAttr("disabled");
                        clearInterval(t);
                    }
                }, 1000);
            }
        });

        return false;
    });

    $btn.click(function () {
        $form.submit();
        return false;
    });
});

