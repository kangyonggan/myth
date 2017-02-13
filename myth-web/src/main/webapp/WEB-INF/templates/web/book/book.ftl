<@override name="main">
<div id="book-info">
    <div class="bread">
        <@apps>
            <a href="#book">${appName}</a> &gt; <a href="#book/category/${book.categoryCode}">${book.categoryName}</a>
            &gt; ${book.name}最新章节列表
        </@apps>
    </div>
    <div class="info">
        <div class="l">
            <img alt="${book.name}" src="${book.picture}" width="120" height="150"
                 onerror="this.src='${ctx}/static/app/images/nocover.jpg'">
        </div>
        <div class="r">
            <h1>${book.name}</h1>
            <p>作&nbsp;&nbsp;&nbsp;&nbsp;者：${book.author}</p>
            <p>状&nbsp;&nbsp;&nbsp;&nbsp;态：<#if book.isFinished==1>已完结<#else>连载中</#if></p>
            <p>最后更新：${book.updatedTime?datetime}</p>
            <p>最新章节：
                <#if book.isLocked==1>
                    <a href="javascript:" class="red">正在拉取</a>
                <#elseif book.newChapterUrl==''>
                    <a href="${ctx}/engine/chapter?bookUrl=${book.url}" target="_blank">点此拉取</a>
                <#else>
                    <a href="#book/${book.url}/chapter/${book.newChapterUrl}"
                       target="_blank">${book.newChapterTitle}</a>
                </#if>
            </p>
            <div class="intro">
                <p>${book.introduction}</p>
            </div>
        </div>
    </div>
</div>

<div class="space-6"></div>

<ul id="book-chapters">
    <#if chapters?? && chapters?size gt 0>
        <#list chapters as chapter>
            <li><a href="#book/${book.url}/chapter/${chapter.url}">${chapter.title}</a></li>
        </#list>
        <li><a href="${ctx}/engine/chapter?bookUrl=${book.url}" target="_blank">手动更新</a></li>
    <#else>
        <div class="empty-chapter">
            暂无章节
            <small>
                <a href="${ctx}/engine/chapter?bookUrl=${book.url}" target="_blank">更新</a>
            </small>
        </div>
    </#if>
</ul>
</@override>

<@override name="script">
<script>
    document.title = "${book.name}";
</script>
</@override>

<@extends name="layout.ftl"/>
