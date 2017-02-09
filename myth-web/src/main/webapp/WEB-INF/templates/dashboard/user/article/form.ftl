<#assign ctx="${(rca.contextPath)!''}">

<link rel="stylesheet" href="${ctx}/static/ace/dist/css/dropzone.min.css"/>
<link rel="stylesheet" href="${ctx}/static/libs/bootstrap/css/bootstrap-markdown.min.css"/>
<link rel="stylesheet" href="${ctx}/static/ace/dist/css/select2.min.css"/>

<div class="space-10"></div>
<form id="article-form" method="post" enctype="multipart/form-data" class="form-horizontal"
      action="${ctx}/dashboard/user/article/${article.id???string('update', 'save')}">

<#if article.id??>
    <input type="hidden" name="id" value="${article.id}"/>
</#if>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">文章标题<span class="red">*</span></label>
        <div class="col-xs-12 col-sm-5">
        <@spring.formInput "article.title" 'class="form-control" placeholder="简单描述一下文章,最多64字"'/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-3 control-label no-padding-right">标签</label>
        <div class="col-xs-12 col-sm-5">
            <select multiple="" name="tags" id="tags" class="select2 width-100" data-placeholder="标签">
            <#list allTags as tag>
                <option value="${tag.code}"
                        <#if tags?? && tags?seq_contains(tag.code)>selected</#if>>${tag.value}</option>
            </#list>
            </select>
        </div>
    </div>

    <div class="form-group" id="markdown-content">
        <label class="col-xs-2 control-label pull-left">内容<span class="red">*</span></label>
        <div class="col-xs-10 col-xs-offset-1">
                <textarea required name="content" class="width-100" id="content-md" rows="13"
                          placeholder="请输入文章内容">${article.content!''}</textarea>
        </div>
    </div>

    <div class="hr hr-18 dotted"></div>

<#if article.id?? && attachments?size gt 0>
    <div class="form-group old-attachments">
        <label class="col-xs-10 col-xs-offset-1 pull-left">原附件</label>

        <div class="col-xs-10 col-xs-offset-1 old-attachments-list">
            <@apps>
                <#list attachments as attachment>
                    <#include "attachment.ftl"/>
                </#list>
            </@apps>
        </div>
    </div>
</#if>

    <div class="form-group">
        <label class="col-xs-10 col-xs-offset-1 pull-left"><#if article.id?? && attachments?size gt 0>新</#if>附件</label>

        <div class="col-xs-10 col-xs-offset-1">
            <div id="form-attachments">
                <input type="file" name="file[]"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="center">
            <button id="id-add-attachment" type="button" class="btn btn-sm btn-danger">
                <i class="ace-icon fa fa-paperclip bigger-140"></i>
                添加更多
            </button>
        </div>
    </div>

    <div class="clearfix form-actions">
        <div class="col-xs-offset-3">
            <button id="submit" class="btn btn-inverse" data-loading-text="正在提交...">
                <i class="ace-icon fa fa-check"></i>
            <@spring.message "app.button.save"/>
            </button>
        </div>
    </div>
</form>

<script type="text/javascript" src="${ctx}/static/ace/dist/js/select2.min.js"></script>
<script type="text/javascript" src="${ctx}/static/libs/bootstrap/js/marked.min.js"></script>
<script type="text/javascript" src="${ctx}/static/libs/bootstrap/js/bootstrap-markdown.min.js"></script>
<script src="${ctx}/static/app/js/dashboard/user/article/form.js"></script>
