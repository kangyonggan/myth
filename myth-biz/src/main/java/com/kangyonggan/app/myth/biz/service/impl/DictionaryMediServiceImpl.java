package com.kangyonggan.app.myth.biz.service.impl;

import com.kangyonggan.app.myth.biz.service.DictionaryMediService;
import com.kangyonggan.app.myth.mapper.DictionaryMediMapper;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.model.vo.DictionaryMedi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Service
public class DictionaryMediServiceImpl extends BaseService<DictionaryMedi> implements DictionaryMediService {

    @Autowired
    private DictionaryMediMapper dictionaryMediMapper;

    @Override
    @LogTime
    public void saveDictionaryMedis(Long sourceId, String type, List<String> codes) {
        dictionaryMediMapper.insertDictionaryMedis(sourceId, type, codes);
    }

    @Override
    @LogTime
    public void deleteDictionaryMedis(Long sourceId, String type) {
        DictionaryMedi dictionaryMedi = new DictionaryMedi();
        dictionaryMedi.setSourceId(sourceId);
        dictionaryMedi.setType(type);

        super.delete(dictionaryMedi);
    }

    @Override
    @LogTime
    public List<DictionaryMedi> findDictionaryMedisBySourceIdAndType(Long sourceId, String type) {
        DictionaryMedi dictionaryMedi = new DictionaryMedi();
        dictionaryMedi.setType(type);
        dictionaryMedi.setSourceId(sourceId);

        return super.select(dictionaryMedi);
    }
}
