package com.deer.wms.bill.manage.web;

import com.deer.wms.bill.manage.constant.BillManageConstant;
import com.deer.wms.bill.manage.constant.BillManagePublicMethod;
import com.deer.wms.bill.manage.model.*;
import com.deer.wms.bill.manage.service.*;
import com.deer.wms.project.seed.annotation.OperateLog;
import com.deer.wms.project.seed.constant.SystemManageConstant;
import com.deer.wms.project.seed.core.result.CommonCode;
import com.deer.wms.project.seed.core.result.Result;
import com.deer.wms.project.seed.core.result.ResultGenerator;
import com.deer.wms.intercept.annotation.User;
import com.deer.wms.intercept.common.data.CurrentUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

/**
* Created by gtt on 2019/07/18.
*/
@Api(description = "入库单接口")
@RestController
@RequestMapping("/mt/alone/inbound/orders")
public class MtAloneInboundOrderController {

    @Autowired
    private MtAloneInboundOrderService mtAloneInboundOrderService;
    @Autowired
    private MtAloneAuditRelatMbService mtAloneAuditRelatMbService;
    @Autowired
    private MtAloneAuditRelatService mtAloneAuditRelatService;
    @Autowired
    private MtAloneAuditTaskMbService mtAloneAuditTaskMbService;
    @Autowired
    private MtAloneAuditTaskService mtAloneAuditTaskService;
    @Autowired
    private MtAloneProductService mtAloneProductService;
    @Autowired
    private MtAloneBarcodeService mtAloneBarcodeService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "添加入库单", type = "增加")
    @ApiOperation(value = "添加入库单", notes = "添加入库单")
    @PostMapping("/add")
    public Result add(@RequestBody MtAloneInBoundOrderProVO mtAloneInBoundOrderProVO, @ApiIgnore @User CurrentUser currentUser) {
        if(currentUser==null){
            return ResultGenerator.genFailResult( CommonCode.SERVICE_ERROR,"未登录错误",null );
        }
        //---------------------生成审核业务模板实例-----------------------------
        MtAloneAuditTaskMb mtAloneAuditTaskMb=mtAloneAuditTaskMbService.findById(BillManageConstant.INBOUND_TASK_MB_ID);
        MtAloneAuditTask mtAloneAuditTask=new MtAloneAuditTask();
        mtAloneAuditTask.setAuditTaskMbId(BillManageConstant.INBOUND_TASK_MB_ID);
        mtAloneAuditTask.setAuditTaskName(mtAloneAuditTaskMb.getAuditTaskName());
        mtAloneAuditTask.setCompanyId(currentUser.getCompanyId());
        mtAloneAuditTask.setCreateTime(new Date());
        mtAloneAuditTask.setIsTaskCompleted(0);
        mtAloneAuditTaskService.save(mtAloneAuditTask);
        //-------------------生成审核业务节点模板实例----------------------------
        MtAloneAuditRelatMbParams params=new MtAloneAuditRelatMbParams();
        params.setCompanyId(currentUser.getCompanyId());
        params.setAuditTaskMBId(BillManageConstant.INBOUND_TASK_MB_ID);
        List<MtAloneAuditRelatMb> relatListMb=mtAloneAuditRelatMbService.findList(params);
        List<MtAloneAuditRelat> relatList=new ArrayList<MtAloneAuditRelat>();

        Integer maxId=mtAloneAuditRelatService.findMaxId();
        for(int i=0;i<relatListMb.size();i++){
            maxId=maxId+1;
            MtAloneAuditRelat relat=new MtAloneAuditRelat();
            BeanUtils.copyProperties(relatListMb.get(i), relat);
            if(i==0&&relatListMb.size()>1){
                relat.setPrevNodeId(0);
                relat.setNextNodeId(maxId+1);
            }
            else if(i==relatListMb.size()-1&&relatListMb.size()>1){
                relat.setPrevNodeId(maxId-1);
                relat.setNextNodeId(0);
            }
            else if(relatListMb.size()==1){
                relat.setPrevNodeId(0);
                relat.setNextNodeId(0);
            }else{
                relat.setPrevNodeId(maxId-1);
                relat.setNextNodeId(maxId+1);
            }
            relat.setAuditTaskId(mtAloneAuditTask.getId());
            relat.setId(maxId);
            relat.setNodeOrder(i+1);
            relatList.add(relat);
        }
        mtAloneAuditRelatService.save(relatList);

        //-------------------生成入库单,保存相应产品------------------------------
        MtAloneInboundOrder mtAloneInboundOrder=new MtAloneInboundOrder();
        String inBoundOrderCode=BillManagePublicMethod.creatInBoundOrderCode();
        BeanUtils.copyProperties(mtAloneInBoundOrderProVO, mtAloneInboundOrder);
        mtAloneInboundOrder.setCreateTime(new Date());
        mtAloneInboundOrder.setCompanyId(currentUser.getCompanyId());
        mtAloneInboundOrder.setAuditTaskId(mtAloneAuditTask.getId());
        mtAloneInboundOrder.setInboundOrderCode(inBoundOrderCode);
        mtAloneInboundOrder.setRevieweState(3);
        mtAloneInboundOrder.setStatus(0);
        mtAloneInboundOrder.setOperatorId(currentUser.getUserId());
        mtAloneInboundOrderService.save(mtAloneInboundOrder);

        String maxBarcode = mtAloneBarcodeService.getMaxBarcode();
        List<MtAloneBarcode> barCodeList=new ArrayList<MtAloneBarcode>();
        List<MtAloneProduct> proList=new ArrayList<MtAloneProduct>();
        for(int i=0;i<mtAloneInBoundOrderProVO.getProList().size();i++){
            mtAloneInBoundOrderProVO.getProList().get(i).setInboundOrderCode(inBoundOrderCode);
            String productBarcode = BillManagePublicMethod.creatBarCode(maxBarcode);
            mtAloneInBoundOrderProVO.getProList().get(i).setProductBarCode(productBarcode);
            mtAloneInBoundOrderProVO.getProList().get(i).setState("normal");
            mtAloneInBoundOrderProVO.getProList().get(i).setCompanyId(currentUser.getCompanyId());
            MtAloneProduct product=new MtAloneProduct();
            BeanUtils.copyProperties(mtAloneInBoundOrderProVO.getProList().get(i), product);
            product.setCreateTime(new Date());
            product.setModifyTime(new Date());
            product.setGreffierName(currentUser.getUserName());
            proList.add(product);
            maxBarcode=productBarcode;
            MtAloneBarcode mtAloneBarcode = new MtAloneBarcode();
            mtAloneBarcode.setBarcode(maxBarcode);
            barCodeList.add(mtAloneBarcode);
        }
        mtAloneBarcodeService.save(barCodeList);
        mtAloneProductService.save(proList);

        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "删除入库单", type = "删除")
    @ApiOperation(value = "删除入库单", notes = "删除入库单")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        mtAloneInboundOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "修改入库单", type = "更新")
    @ApiOperation(value = "修改入库单", notes = "修改入库单")
    @PostMapping("/update")
    public Result update(@RequestBody MtAloneInBoundOrderProVO mtAloneInBoundOrderProVO, @ApiIgnore @User CurrentUser currentUser) {
        mtAloneInBoundOrderProVO.setUpdateTime(new Date());
        mtAloneInboundOrderService.update(mtAloneInBoundOrderProVO);

        String maxBarcode = mtAloneBarcodeService.getMaxBarcode();
        List<MtAloneProductVO> productVOList = mtAloneInBoundOrderProVO.getProList();
        String inboundOrder = mtAloneInBoundOrderProVO.getInboundOrderCode();
        for(MtAloneProductVO productVO : productVOList){

            if(!"".equals(productVO.getId()) && productVO.getId()!=null && !"".equals(productVO.getProductName())){
               mtAloneProductService.update(productVO);
               continue;
            }
            productVO.setInboundOrderCode(inboundOrder);
            String productBarcode = BillManagePublicMethod.creatBarCode(maxBarcode);
            productVO.setProductBarCode(productBarcode);
            productVO.setState("normal");
            productVO.setCompanyId(currentUser.getCompanyId());
            productVO.setCreateTime(new Date());
            productVO.setModifyTime(new Date());
            productVO.setGreffierName(currentUser.getUserName());
            MtAloneProduct product=new MtAloneProduct();
            BeanUtils.copyProperties(productVO, product);
            maxBarcode = productBarcode;
            MtAloneBarcode mtAloneBarcode = new MtAloneBarcode();
            mtAloneBarcode.setBarcode(maxBarcode);
            mtAloneBarcodeService.save(mtAloneBarcode);
            mtAloneProductService.save(product);
        }
        return ResultGenerator.genSuccessResult();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据ID获取入库单", type = "获取")
    @ApiOperation(value = "根据ID获取入库单", notes = "根据ID获取入库单")
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id) {
        MtAloneInboundOrder mtAloneInboundOrder = mtAloneInboundOrderService.findById(id);
        return ResultGenerator.genSuccessResult(mtAloneInboundOrder);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据auditTaskId获取入库单", type = "获取")
    @ApiOperation(value = "根据auditTaskId获取入库单", notes = "根据auditTaskId获取入库单")
    @GetMapping("/detail/auditTaskId")
    public Result detailByAuditTaskId(MtAloneInboundOrderParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (loginVerify(params, currentUser)) return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
        MtAloneInBoundOrderProVO mtAloneInboundOrder = mtAloneInboundOrderService.findOrderByAuditTaskId(params);
        return ResultGenerator.genSuccessResult(mtAloneInboundOrder);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据auditTaskId获取入库单和打卷明细", type = "查询")
    @ApiOperation(value = "根据auditTaskId获取入库单和打卷明细", notes = "根据auditTaskId获取入库单")
    @GetMapping("/detail/proDet/auditTaskId")
    public Result detailProDetByAuditTaskId(MtAloneInboundOrderParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (loginVerify(params, currentUser)) return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);
        MtAloneInboundOrderProDetVO mtAloneInboundOrder = mtAloneInboundOrderService.findOrderProDetByAuditTaskId(params);
        return ResultGenerator.genSuccessResult(mtAloneInboundOrder);
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "入库单及相应产品列表", type = "获取")
    @ApiOperation(value = "入库单及相应产品列表", notes = "入库单及相应产品列表")
    @GetMapping("/inOrderProlist")
    public Result inOrderProlist(MtAloneInboundOrderParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (loginVerify(params, currentUser)) return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneInBoundOrderProVO> list = mtAloneInboundOrderService.findOrderProList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "入库单及相应产品明细列表", type = "获取")
    @ApiOperation(value = "入库单及相应产品明细列表", notes = "入库单及相应产品明细列表")
    @GetMapping("/inOrderProDetlist")
    public Result inOrderProDetlist(MtAloneInboundOrderParams params, @ApiIgnore @User CurrentUser currentUser) {
        if (loginVerify(params, currentUser)) return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);

        PageHelper.startPage(params.getPageNum(), params.getPageSize());
        List<MtAloneInboundOrderProDetVO> list = mtAloneInboundOrderService.findOrderProDetList(params);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "access-token", value = "token", paramType = "header", dataType = "String", required = true) })
    @OperateLog(description = "根据入库单code获取入库单及产品", type = "获取")
    @ApiOperation(value = "根据入库单code获取入库单及产品", notes = "根据入库单code获取入库单及产品")
    @GetMapping("/prolistByOrderCode")
    public Result prolistByOrderCode(MtAloneInboundOrderParams params, @ApiIgnore @User CurrentUser currentUser) {

        if (loginVerify(params, currentUser)) return ResultGenerator.genFailResult(CommonCode.NO_LOGIN);

        MtAloneInBoundOrderProVO list = mtAloneInboundOrderService.findProListByOrderCode(params);
        return ResultGenerator.genSuccessResult(list);
    }

    private boolean loginVerify(MtAloneInboundOrderParams params, @User @ApiIgnore CurrentUser currentUser) {

        if(currentUser==null){
            return true;
        }
        if (currentUser.getCompanyType() != SystemManageConstant.COMPANY_TYPE_MT){
            params.setCompanyId(currentUser.getCompanyId());
        }else{
            params.setCompanyId(null);
        }
        return false;
    }

}
