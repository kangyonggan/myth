package com.kangyonggan.app.myth.biz.service.impl;

import com.kangyonggan.app.myth.biz.service.AttachmentService;
import com.kangyonggan.app.myth.mapper.AttachmentMapper;
import com.kangyonggan.app.myth.model.annotation.CacheDelete;
import com.kangyonggan.app.myth.model.annotation.CacheDeleteAll;
import com.kangyonggan.app.myth.model.annotation.CacheGetOrSave;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.vo.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/1/21
 */
@Service
public class AttachmentServiceImpl extends BaseService<Attachment> implements AttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    @LogTime
    @CacheDeleteAll("attachment:source:{0}")
    public void saveAttachments(Long sourceId, List<Attachment> attachments) {
        attachmentMapper.insertAttachments(sourceId, attachments);
    }

    @Override
    @LogTime
    @CacheGetOrSave("attachment:source:{0}:type:{1}")
    public List<Attachment> findAttachmentsBySourceIdAndType(Long sourceId, String type) {
        Attachment attachment = new Attachment();
        attachment.setSourceId(sourceId);
        attachment.setType(type);
        attachment.setIsDeleted(AppConstants.IS_DELETED_NO);

        return super.select(attachment);
    }

    @Override
    @LogTime
    @CacheDelete("attachment:source:{1}:type:{2}")
    public void deleteAttachment(Long id, Long sourceId, String type) {
        Attachment attachment = new Attachment();
        attachment.setIsDeleted(AppConstants.IS_DELETED_YES);

        Example example = new Example(Attachment.class);
        example.createCriteria().andEqualTo("id", id).andEqualTo("sourceId", sourceId).andEqualTo("type", type);

        attachmentMapper.updateByExampleSelective(attachment, example);
    }
}
