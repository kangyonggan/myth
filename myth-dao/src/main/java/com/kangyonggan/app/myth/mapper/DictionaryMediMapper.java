package com.kangyonggan.app.myth.mapper;

import com.kangyonggan.app.myth.model.vo.DictionaryMedi;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryMediMapper extends MyMapper<DictionaryMedi> {

    /**
     * 保存字典中间数据
     *
     * @param sourceId
     * @param type
     * @param codes
     */
    void insertDictionaryMedis(@Param("sourceId") Long sourceId, @Param("type") String type, @Param("codes") List<String> codes);
}