package com.deer.wms.bill.manage.dao;

import com.deer.wms.bill.manage.model.MtAloneInBoundOrderProVO;
import com.deer.wms.bill.manage.model.MtAloneInboundOrder;
import com.deer.wms.bill.manage.model.MtAloneInboundOrderParams;
import com.deer.wms.bill.manage.model.MtAloneInboundOrderProDetVO;
import com.deer.wms.project.seed.core.mapper.Mapper;

import java.util.List;

public interface MtAloneInboundOrderMapper extends Mapper<MtAloneInboundOrder> {
    List<MtAloneInboundOrder> findList(MtAloneInboundOrderParams params);

    List<MtAloneInBoundOrderProVO> findOrderProList(MtAloneInboundOrderParams params);

    List<MtAloneInboundOrderProDetVO> findOrderProDetList(MtAloneInboundOrderParams params);

    MtAloneInBoundOrderProVO  findOrderByAuditTaskId(MtAloneInboundOrderParams params);

    MtAloneInBoundOrderProVO findProListByOrderCode(MtAloneInboundOrderParams params);

    MtAloneInboundOrderProDetVO findOrderProDetByAuditTaskId(MtAloneInboundOrderParams params);
}