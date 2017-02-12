<#assign ctx="${(rca.contextPath)!''}">

<div class="col-xs-offset-0 col-sm-offset-1 col-md-offset-2 col-xs-12 col-sm-10 col-md-8">
    <div class="space-10"></div>
    <h1 class="center">${chapter.title}</h1>
    <div class="space-16"></div>
    <div style="font-size: 22px;">
    ${chapter.content}
    </div>
    <div class="space-14"></div>
    <div class="hr hr2 hr-double"></div>
    <div class="space-6"></div>
    <div class="center" style="font-size: 15px">
    <#if prevChapter??>
        <a class="dark pull-left" href="#book/${book.url}/chapter/${prevChapter.id}">上一章《${prevChapter.title}》</a>
    <#else>
        <div class="pull-left">没有上一章了</div>
    </#if>
        <a class="dark" href="#book/${book.url}">章节列表</a>
    <#if nextChapter??>
        <a class="dark pull-right" href="#book/${book.url}/chapter/${nextChapter.id}">下一章《${nextChapter.title}》</a>
    <#else>
        <div class="pull-right">没有下一章了</div>
    </#if>
    </div>
</div>
