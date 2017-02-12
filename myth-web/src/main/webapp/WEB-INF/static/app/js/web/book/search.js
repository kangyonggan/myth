$(function () {
    // 搜索
    $(document).on("click", "[data-toggle='search-submit']", function (e) {
        e.preventDefault();
        var $this = $(this);
        var $form = $this.parent("form");

        var params = '?';
        var arr = $form.serializeArray();
        for (var i = 0; i < arr.length; i++) {
            if (i != 0) {
                params += '&';
            }
            params += arr[i].name + "=";
            params += arr[i].value;
        }

        var hash = $form.attr("action");

        window.location.href = window.location.origin + window.location.pathname + hash + params;
        return false;
    });
});