package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.model.vo.DictionaryMedi;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
public interface DictionaryMediService {

    /**
     * 保存字典中间数据
     *
     * @param sourceId
     * @param type
     * @param codes
     */
    void saveDictionaryMedis(Long sourceId, String type, List<String> codes);

    /**
     * 删除字典中间数据
     *
     * @param sourceId
     * @param type
     */
    void deleteDictionaryMedis(Long sourceId, String type);

    /**
     * 查找字典中间数据
     *
     * @param sourceId
     * @param type
     * @return
     */
    List<DictionaryMedi> findDictionaryMedisBySourceIdAndType(Long sourceId, String type);
}
