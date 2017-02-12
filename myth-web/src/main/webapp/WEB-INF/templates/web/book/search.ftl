<@override name="main">
    <#if !page.list?? || page.list?size lte 0>
    <div class="book-empty">
        <h3 class="center">没有符合条件的书籍</h3>
    </div>
    <#else>
        <ul id="search-list">
            <#list page.list as book>
                <li>
                    <img src="${book.picture}" alt="${book.name}" width="67" height="82">
                    <div>
                        <p>
                            <a href="#book/${book.url}">${book.name}</a><em>${book.author}</em>
                        </p>
                        <p>
                        ${book.introduction}
                        </p>
                    </div>
                </li>
            </#list>
        </ul>
    </#if>
</@override>

<@override name="script">
<script>
    document.title = "${key}";
</script>
</@override>

<@extends name="layout.ftl"/>
