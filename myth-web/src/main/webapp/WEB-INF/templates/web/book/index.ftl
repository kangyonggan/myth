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

    <div id="book-recommend">
        <div id="book-recommend-l">
        <#if new4books?? && new4books?size gt 0>
            <#list new4books as book>
                <div class="book-item">
                    <div class="image">
                        <a href="#book/${book.url}">
                            <img src="${book.picture}" alt="${book.name}" width="120" height="150"/>
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
        <div id="book-recommend-r">
            <h2>强势推荐</h2>
            <ul>
            <#if old9books?? && old9books?size gt 0>
                <#list old9books as book>
                    <li>
                        <span class="s1">[${book.categoryName}]</span>
                        <span class="s2">
                            <a href="#book/${book.url}">${book.name}</a>
                        </span>
                        <span class="s5">${book.author}</span>
                    </li>
                </#list>
            <#else>
                敬请期待
            </#if>
            </ul>
        </div>
    </div>

    <div class="space-6"></div>

    <div class="book-category">
        <div class="content">
            <h2>玄幻小说</h2>
        <#if xuanhuan13books?? && xuanhuan13books?size gt 0>
            <div class="top">
                <div class="image">
                    <a href="#book/${xuanhuan13books[0].url}">
                        <img src="${xuanhuan13books[0].picture}" alt="${xuanhuan13books[0].name}" width="67"
                             height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="#book/${xuanhuan13books[0].url}">${xuanhuan13books[0].name}</a></dt>
                    <dd>${xuanhuan13books[0].introduction}</dd>
                </dl>
            </div>
            <ul>
                <#list xuanhuan13books as book>
                    <#if book_index gt 0>
                        <li><a href="#book/${book.url}">${book.name}</a>/${book.author}</li>
                    </#if>
                </#list>
            </ul>
        <#else>
            敬请期待
        </#if>
        </div>
        <div class="content">
            <h2>修真小说</h2>
        <#if xiuzhen13books?? && xiuzhen13books?size gt 0>
            <div class="top">
                <div class="image">
                    <a href="#book/${xiuzhen13books[0].url}">
                        <img src="${xiuzhen13books[0].picture}" alt="${xiuzhen13books[0].name}" width="67"
                             height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="#book/${xiuzhen13books[0].url}">${xiuzhen13books[0].name}</a></dt>
                    <dd>${xiuzhen13books[0].introduction}</dd>
                </dl>
            </div>
            <ul>
                <#list xiuzhen13books as book>
                    <#if book_index gt 0>
                        <li><a href="#book/${book.url}">${book.name}</a>/${book.author}</li>
                    </#if>
                </#list>
            </ul>
        <#else>
            敬请期待
        </#if>
        </div>
        <div class="content no-border">
            <h2>都市小说</h2>
        <#if dushi13books?? && dushi13books?size gt 0>
            <div class="top">
                <div class="image">
                    <a href="#book/${dushi13books[0].url}">
                        <img src="${dushi13books[0].picture}" alt="${dushi13books[0].name}" width="67"
                             height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="#book/${dushi13books[0].url}">${dushi13books[0].name}</a></dt>
                    <dd>${dushi13books[0].introduction}</dd>
                </dl>
            </div>
            <ul>
                <#list dushi13books as book>
                    <#if book_index gt 0>
                        <li><a href="#book/${book.url}">${book.name}</a>/${book.author}</li>
                    </#if>
                </#list>
            </ul>
        <#else>
            敬请期待
        </#if>
        </div>
    </div>

    <div class="space-6"></div>

    <div class="book-category">
        <div class="content">
            <h2>历史小说</h2>
        <#if lishi13books?? && lishi13books?size gt 0>
            <div class="top">
                <div class="image">
                    <a href="#book/${lishi13books[0].url}">
                        <img src="${lishi13books[0].picture}" alt="${lishi13books[0].name}" width="67"
                             height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="#book/${lishi13books[0].url}">${lishi13books[0].name}</a></dt>
                    <dd>${lishi13books[0].introduction}</dd>
                </dl>
            </div>
            <ul>
                <#list lishi13books as book>
                    <#if book_index gt 0>
                        <li><a href="#book/${book.url}">${book.name}</a>/${book.author}</li>
                    </#if>
                </#list>
            </ul>
        <#else>
            敬请期待
        </#if>
        </div>
        <div class="content">
            <h2>网游小说</h2>
        <#if wangyou13books?? && wangyou13books?size gt 0>
            <div class="top">
                <div class="image">
                    <a href="#book/${wangyou13books[0].url}">
                        <img src="${wangyou13books[0].picture}" alt="${wangyou13books[0].name}" width="67"
                             height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="#book/${wangyou13books[0].url}">${wangyou13books[0].name}</a></dt>
                    <dd>${wangyou13books[0].introduction}</dd>
                </dl>
            </div>
            <ul>
                <#list wangyou13books as book>
                    <#if book_index gt 0>
                        <li><a href="#book/${book.url}">${book.name}</a>/${book.author}</li>
                    </#if>
                </#list>
            </ul>
        <#else>
            敬请期待
        </#if>
        </div>
        <div class="content no-border">
            <h2>科幻小说</h2>
        <#if kehuan13books?? && kehuan13books?size gt 0>
            <div class="top">
                <div class="image">
                    <a href="#book/${kehuan13books[0].url}">
                        <img src="${kehuan13books[0].picture}" alt="${kehuan13books[0].name}" width="67"
                             height="82"/>
                    </a>
                </div>
                <dl>
                    <dt><a href="#book/${kehuan13books[0].url}">${kehuan13books[0].name}</a></dt>
                    <dd>${kehuan13books[0].introduction}</dd>
                </dl>
            </div>
            <ul>
                <#list kehuan13books as book>
                    <#if book_index gt 0>
                        <li><a href="#book/${book.url}">${book.name}</a>/${book.author}</li>
                    </#if>
                </#list>
            </ul>
        <#else>
            敬请期待
        </#if>
        </div>
    </div>

    <div class="space-6"></div>

    <div id="book-new">
        <div class="l">
            <h2>最近更新小说列表</h2>
            <ul>
            <#if active30books?? && active30books?size gt 0>
                <#list active30books as book>
                    <li>
                        <span class="s1">[${book.name}]</span>
                        <span class="s2">
                                <a href="#book/${book.url}" target="_blank">${book.name}</a>
                            </span>
                        <span class="s3">
                                <a href="#book/${book.url}/chapter/${book.newChapterUrl}"
                                   target="_blank">${book.newChapterTitle}</a>
                            </span>
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
            <h2>最新入库小说</h2>
            <ul>

            <#if new30books?? && new30books?size gt 0>
                <#list new30books as book>
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

<script>
    document.title = "小说"
</script>