package com.deer.wms.detect.dao;

import java.util.List;

import com.deer.wms.detect.model.MtAloneFabricGroup;
import org.apache.ibatis.annotations.Param;

import com.deer.wms.bill.manage.model.MtAloneProductDet;
import com.deer.wms.detect.model.MtAloneFabricDefect;
import com.deer.wms.detect.model.MtAloneFabricDefectCriteria;
import com.deer.wms.project.seed.core.mapper.Mapper;

public interface MtAloneFabricDefectMapper extends Mapper<MtAloneFabricDefect> {
	
	List<MtAloneFabricDefect> findDefectByName(MtAloneFabricDefectCriteria criteria);

	List<MtAloneFabricDefect> findList(MtAloneFabricDefectCriteria criteria);

	List<MtAloneFabricDefect> findListByTypeId(MtAloneFabricDefectCriteria criteria);

	MtAloneProductDet findProductDetByBarCode(@Param("productDetBarCode")String productDetBarCode);

    List<MtAloneFabricGroup> groupList(MtAloneFabricDefectCriteria criteria);
}