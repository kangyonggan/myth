<div class="item">
    <div class="article-title">
        <a href="#article/${article.id}">${article.title}</a>
    </div>
    <div class="article-info">
    ${article.createFullname} | <@c.relative_date datetime=article.createdTime/> | ${article.tags}
    </div>
</div>