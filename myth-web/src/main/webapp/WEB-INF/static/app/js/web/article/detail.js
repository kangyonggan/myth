$(function () {
    if ('true' == isQuery) {
        updateState("query/article");
    } else {
        updateState("user/article");
    }

    document.title = title;

    $(".markdown-content a").prop("target", "_blank");

});