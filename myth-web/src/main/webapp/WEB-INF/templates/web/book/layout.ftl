<#assign ctx="${(rca.contextPath)!''}">

<link rel="stylesheet" href="${ctx}/static/app/css/book.css"/>

<div id="book-container">
    <div id="book-header">
        <div class="pull-left">
            <a href="#book" id="book-home">
                东方无神,娇子纵横!
            </a>
        </div>

        <form action="#book/search" method="get" novalidate class="pull-right">
            <input type="text" id="search-key" name="key" placeholder="输入需要搜索的小说名或作者名"/>
            <button class="btn btn-inverse btn-sm">&nbsp;&nbsp;搜&nbsp;&nbsp;&nbsp;&nbsp;索&nbsp;&nbsp;</button>
        </form>
    </div>

    <div id="book-navbar">
        <ul>
            <li><a href="#book">首页</a></li>
        <#list categories as category>
            <li><a href="#book/${category.code}">${category.value}</a></li>
        </#list>
            <li><a href="#book/temp">临时书架</a></li>
        </ul>
    </div>

    <div class="space-6"></div>

    <@block name="main"/>

    <div class="space-6"></div>

    <div id="book-friend">
        友情链接：
        <a href="${ctx}/" target="_blank">东方娇子</a>
        <a href="http://www.biquge.cn" target="_blank">笔趣阁</a>
        <a href="http://www.81zw.com" target="_blank">八一中文网</a>
        <a href="http://www.wenxuemi.com" target="_blank">文学迷</a>
        <a href="http://www.baquge.com" target="_blank">新笔趣阁</a>
        <a href="http://www.23txt.com" target="_blank">天籁小说网</a>
        <a href="http://www.xs222.com" target="_blank">顶点小说</a>
        <a href="http://www.mangg.com" target="_blank">追书网</a>
    </div>
</div>

<@block name="script"/>