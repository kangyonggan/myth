<@override name="main">
    <#if !category??>
    <div class="book-empty">
        <h3 class="center">书架没有任务书籍</h3>
    </div>
    <#else>
    <div id="book-hot">
        <#if new6books?? && new6books?size gt 0>
            <#list new6books as book>
                <div class="book-item">
                    <div class="image">
                        <a href="#book/${book.url}">
                            <img src="${book.picture}" alt="${book.name}" width="120"
                                 height="150"/>
                        </a>
                    </div>
                    <dl>
                        <dt>
                            <span>${book.author}</span>
                            <a href="#book/${book.url}">${book.name}</a>
                        </dt>
                        <dd>${book.introduction}</dd>
                    </dl>
                </div>
            </#list>
        <#else>
            敬请期待
        </#if>
    </div>

    <div class="space-6"></div>

    <div id="book-new">
        <div class="l">
            <h2>好看的${category.value}最近更新列表</h2>
            <ul>
                <#if active30books?? && active30books?size gt 0>
                    <#list active30books as book>
                        <li>
                            <span class="s1">[${book.name}]</span>
                            <span class="s2">
                                <a href="#book/${book.url}" target="_blank">${book.name}</a>
                            </span>
                            <#if book.newChapterUrl==''>
                                <span class="s3">
                                <a href="${ctx}/engine/chapter?bookUrl=${book.url}"
                                   target="_blank">点此拉取</a>
                            </span>
                            <#elseif book.isLocked==1>
                                <span class="s3">
                                正在拉取...
                            </span>
                            <#else>
                                <span class="s3">
                                <a href="#book/${book.url}/chapter/${book.newChapterUrl}"
                                   target="_blank">${book.newChapterTitle}</a>
                            </span>
                            </#if>
                            <span class="s4">${book.author}</span>
                            <span class="s5">${book.updatedTime?string('MM-dd')}</span>
                        </li>
                    </#list>
                <#else>
                    敬请期待
                </#if>
            </ul>
        </div>
        <div class="r">
            <h2>好看的${category.value}</h2>
            <ul>

                <#if old30books?? && old30books?size gt 0>
                    <#list old30books as book>
                        <li>
                            <span class="s1">[${book.categoryName}]</span>
                            <span class="s2">
                            <a href="#book/${book.url}">${book.name}</a>
                        </span>
                            <span class="s5">${book.updatedTime?string('MM-dd')}</span></li>
                    </#list>
                <#else>
                    敬请期待
                </#if>
            </ul>
        </div>
    </div>
    </#if>
</@override>

<@override name="script">
<script>
        <#if category??>
        document.title = "${category.value}";
        <#else>
        document.title = "临时书架";
        </#if>
</script>
</@override>

<@extends name="layout.ftl"/>
