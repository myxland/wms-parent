package com.deer.wms.detect.service.impl;

import com.deer.wms.detect.dao.MtAloneAccessoryMapper;
import com.deer.wms.detect.dao.MtAloneObjAccessoryMapper;
import com.deer.wms.detect.dao.SampleClothMapper;
import com.deer.wms.detect.model.*;
import com.deer.wms.detect.service.SampleClothService;

import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.project.seed.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guotuanting on 2019/04/12.
 */
@Service
@Transactional
public class SampleClothServiceImpl extends AbstractService<SampleCloth, Integer> implements SampleClothService {

    @Autowired
    private SampleClothMapper mtAloneSampleClothMapper;

    @Override
    public List<SampleCloth> findList(SampleClothParams  params) {
        return mtAloneSampleClothMapper.findList(params);
    }


	@Override
	public List<SampleClothVo> findAccessoryList(SampleClothParams params) {
		return mtAloneSampleClothMapper.findAccessoryList(params); 
	}


	@Override
	public SampleClothVo findDetailById(Integer id) {
		return mtAloneSampleClothMapper.findDetailById(id);
	}

	@Override
	public void deleteClothAndAccessoryById(Integer id) {
		mtAloneSampleClothMapper.deleteClothAndAccessoryById(id);
	}

}
