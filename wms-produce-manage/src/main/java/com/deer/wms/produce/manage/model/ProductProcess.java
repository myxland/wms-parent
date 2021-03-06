package com.deer.wms.produce.manage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "product_process")
public class ProductProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 操作员id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 版本号 默认为 1.1
     */
    private String version;

    /**
     * 状态		0使用，1禁用
     */
    private Integer status;

    /**
     * 销售单号
     */
    @Column(name = "sales_number")
    private String salesNumber;

    /**
     * 加工单号
     */
    @Column(name = "work_order_code")
    private String workOrderCode;

    /**
     * 工单名称
     */
    @Column(name = "work_order_name")
    private String workOrderName;

    /**
     * 单据编号
     */
    @Column(name = "delivery_code")
    private String deliveryCode;

    /**
     * 计划完成时间
     */
    @Column(name = "plan_finish_time")
    private Date planFinishTime;

    /**
     * 计划开始时间
     */
    @Column(name = "plan_begin_time")
    private Date planBeginTime;

    /**
     * 实际完成时间
     */
    @Column(name = "actual_finish_time")
    private Date actualFinishTime;

    /**
     * 实际开始时间
     */
    @Column(name = "actual_begin_time")
    private Date actualBeginTime;

    /**
     * 客户id，关联客户表
     */
    @Column(name = "client_id")
    private Integer clientId;

    /**
     * 客户名称，如果是自己生产，客户为自营
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * 合同编码
     */
    @Column(name = "contract_code")
    private String contractCode;

    /**
     * 合同名称，合同可以作为附件添加到附件列表中
     */
    @Column(name = "contract_name")
    private String contractName;

    /**
     * 产品编码
     */
    @Column(name = "product_process_code")
    private String productProcessCode;

    /**
     * 产品别名
     */
    @Column(name = "product_process_name")
    private String productProcessName;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     */
    @Column(name = "product_bom_id")
    private Integer productBomId;

    /**
     * 加工规格型号
     */
    private String specification;

    /**
     * 加工价格，加工所需要的总费用
     */
    @Column(name = "process_price")
    private Float processPrice;

    /**
     * 原先长度，单位米
     */
    private Float len;

    /**
     * 加工后长度，单位米
     */
    @Column(name = "delivery_len")
    private Float deliveryLen;

    /**
     * 现有检测长度
     */
    @Column(name = "detection_len")
    private Float detectionLen;

    /**
     * 批次号，可以作为扫描生成编码
     */
    @Column(name = "batch_code")
    private String batchCode;

    /**
     * 批次单据号，用户手动填写
     */
    @Column(name = "batch_order_code")
    private String batchOrderCode;

    /**
     * 缩率%，现有检测长度/原先长度
     */
    private String shrinkage;

    /**
     * 总匹数
     */
    @Column(name = "pi_num")
    private Integer piNum;

    /**
     * 加工描述内容
     */
    @Column(name = "process_content")
    private String processContent;

    /**
     * 跟单员id，关联表员工表：user_info
     */
    @Column(name = "merchandiser_id")
    private Integer merchandiserId;

    /**
     * 跟单员名称，关联表员工表：user_info
     */
    @Column(name = "merchandiser_name")
    private String merchandiserName;

    /**
     * 备注
     */
    private String memo;

    /**
     * 审核状态		0等待审核，1审核通过，2审核失败
     */
    @Column(name = "review_status")
    private Integer reviewStatus;

    /**
     * 审核时间
     */
    @Column(name = "review_time")
    private Date reviewTime;

    /**
     * 审核人id，关联表：user_info
     */
    @Column(name = "reviewer_id")
    private Integer reviewerId;

    /**
     * 附件code，关联附件表：mt_alone_accessory
     */
    @Column(name = "product_annex_code")
    private String productAnnexCode;

    @Column(name = "company_id")
    private Integer companyId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取操作员id
     *
     * @return operator_id - 操作员id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员id
     *
     * @param operatorId 操作员id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取版本号 默认为 1.1
     *
     * @return version - 版本号 默认为 1.1
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号 默认为 1.1
     *
     * @param version 版本号 默认为 1.1
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取状态		0使用，1禁用
     *
     * @return status - 状态		0使用，1禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态		0使用，1禁用
     *
     * @param status 状态		0使用，1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取销售单号
     *
     * @return sales_number - 销售单号
     */
    public String getSalesNumber() {
        return salesNumber;
    }

    /**
     * 设置销售单号
     *
     * @param salesNumber 销售单号
     */
    public void setSalesNumber(String salesNumber) {
        this.salesNumber = salesNumber;
    }

    /**
     * 获取工单号
     *
     * @return work_order_code - 工单号
     */
    public String getWorkOrderCode() {
        return workOrderCode;
    }

    /**
     * 设置工单号
     *
     * @param workOrderCode 工单号
     */
    public void setWorkOrderCode(String workOrderCode) {
        this.workOrderCode = workOrderCode;
    }

    /**
     * 获取工单名称
     *
     * @return work_order_name - 工单名称
     */
    public String getWorkOrderName() {
        return workOrderName;
    }

    /**
     * 设置工单名称
     *
     * @param workOrderName 工单名称
     */
    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    /**
     * 获取单据编号
     *
     * @return delivery_code - 单据编号
     */
    public String getDeliveryCode() {
        return deliveryCode;
    }

    /**
     * 设置单据编号
     *
     * @param deliveryCode 单据编号
     */
    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    /**
     * 获取计划完成时间
     *
     * @return plan_finish_time - 计划完成时间
     */
    public Date getPlanFinishTime() {
        return planFinishTime;
    }

    /**
     * 设置计划完成时间
     *
     * @param planFinishTime 计划完成时间
     */
    public void setPlanFinishTime(Date planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    /**
     * 获取计划开始时间
     *
     * @return plan_begin_time - 计划开始时间
     */
    public Date getPlanBeginTime() {
        return planBeginTime;
    }

    /**
     * 设置计划开始时间
     *
     * @param planBeginTime 计划开始时间
     */
    public void setPlanBeginTime(Date planBeginTime) {
        this.planBeginTime = planBeginTime;
    }

    /**
     * 获取实际完成时间
     *
     * @return actual_finish_time - 实际完成时间
     */
    public Date getActualFinishTime() {
        return actualFinishTime;
    }

    /**
     * 设置实际完成时间
     *
     * @param actualFinishTime 实际完成时间
     */
    public void setActualFinishTime(Date actualFinishTime) {
        this.actualFinishTime = actualFinishTime;
    }

    /**
     * 获取实际开始时间
     *
     * @return actual_begin_time - 实际开始时间
     */
    public Date getActualBeginTime() {
        return actualBeginTime;
    }

    /**
     * 设置实际开始时间
     *
     * @param actualBeginTime 实际开始时间
     */
    public void setActualBeginTime(Date actualBeginTime) {
        this.actualBeginTime = actualBeginTime;
    }

    /**
     * 获取客户id，关联客户表
     *
     * @return client_id - 客户id，关联客户表
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * 设置客户id，关联客户表
     *
     * @param clientId 客户id，关联客户表
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取客户名称，如果是自己生产，客户为自营
     *
     * @return client_name - 客户名称，如果是自己生产，客户为自营
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置客户名称，如果是自己生产，客户为自营
     *
     * @param clientName 客户名称，如果是自己生产，客户为自营
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取合同编码
     *
     * @return contract_code - 合同编码
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 设置合同编码
     *
     * @param contractCode 合同编码
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * 获取合同名称，合同可以作为附件添加到附件列表中
     *
     * @return contract_name - 合同名称，合同可以作为附件添加到附件列表中
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * 设置合同名称，合同可以作为附件添加到附件列表中
     *
     * @param contractName 合同名称，合同可以作为附件添加到附件列表中
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * 获取产品加工编码
     *
     * @return product_process_code - 产品加工编码
     */
    public String getProductProcessCode() {
        return productProcessCode;
    }

    /**
     * 设置产品加工编码
     *
     * @param productProcessCode 产品加工编码
     */
    public void setProductProcessCode(String productProcessCode) {
        this.productProcessCode = productProcessCode;
    }

    /**
     * 获取产品加工名称
     *
     * @return product_process_name - 产品加工名称
     */
    public String getProductProcessName() {
        return productProcessName;
    }

    /**
     * 设置产品加工名称
     *
     * @param productProcessName 产品加工名称
     */
    public void setProductProcessName(String productProcessName) {
        this.productProcessName = productProcessName;
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     *
     * @return product_bom_id - 选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     */
    public Integer getProductBomId() {
        return productBomId;
    }

    /**
     * 设置选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     *
     * @param productBomId 选出产品bom表直接关联id，关联表：mt_alone_product_process_bom
     */
    public void setProductBomId(Integer productBomId) {
        this.productBomId = productBomId;
    }

    /**
     * 获取加工规格型号
     *
     * @return specification - 加工规格型号
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置加工规格型号
     *
     * @param specification 加工规格型号
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 获取加工价格，加工所需要的总费用
     *
     * @return process_price - 加工价格，加工所需要的总费用
     */
    public Float getProcessPrice() {
        return processPrice;
    }

    /**
     * 设置加工价格，加工所需要的总费用
     *
     * @param processPrice 加工价格，加工所需要的总费用
     */
    public void setProcessPrice(Float processPrice) {
        this.processPrice = processPrice;
    }

    /**
     * 获取原先长度，单位米
     *
     * @return len - 原先长度，单位米
     */
    public Float getLen() {
        return len;
    }

    /**
     * 设置原先长度，单位米
     *
     * @param len 原先长度，单位米
     */
    public void setLen(Float len) {
        this.len = len;
    }

    /**
     * 获取加工后长度，单位米
     *
     * @return delivery_len - 加工后长度，单位米
     */
    public Float getDeliveryLen() {
        return deliveryLen;
    }

    /**
     * 设置加工后长度，单位米
     *
     * @param deliveryLen 加工后长度，单位米
     */
    public void setDeliveryLen(Float deliveryLen) {
        this.deliveryLen = deliveryLen;
    }

    /**
     * 获取现有检测长度
     *
     * @return detection_len - 现有检测长度
     */
    public Float getDetectionLen() {
        return detectionLen;
    }

    /**
     * 设置现有检测长度
     *
     * @param detectionLen 现有检测长度
     */
    public void setDetectionLen(Float detectionLen) {
        this.detectionLen = detectionLen;
    }

    /**
     * 获取批次号，可以作为扫描生成编码
     *
     * @return batch_code - 批次号，可以作为扫描生成编码
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * 设置批次号，可以作为扫描生成编码
     *
     * @param batchCode 批次号，可以作为扫描生成编码
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    /**
     * 获取批次单据号
     *
     * @return batch_order_code - 批次单据号
     */
    public String getBatchOrderCode() {
        return batchOrderCode;
    }

    /**
     * 设置批次单据号
     *
     * @param batchOrderCode 批次单据号
     */
    public void setBatchOrderCode(String batchOrderCode) {
        this.batchOrderCode = batchOrderCode;
    }

    /**
     * 获取缩率%，现有检测长度/原先长度
     *
     * @return shrinkage - 缩率%，现有检测长度/原先长度
     */
    public String getShrinkage() {
        return shrinkage;
    }

    /**
     * 设置缩率%，现有检测长度/原先长度
     *
     * @param shrinkage 缩率%，现有检测长度/原先长度
     */
    public void setShrinkage(String shrinkage) {
        this.shrinkage = shrinkage;
    }

    /**
     * 获取总匹数
     *
     * @return pi_num - 总匹数
     */
    public Integer getPiNum() {
        return piNum;
    }

    /**
     * 设置总匹数
     *
     * @param piNum 总匹数
     */
    public void setPiNum(Integer piNum) {
        this.piNum = piNum;
    }

    /**
     * 获取加工描述内容
     *
     * @return process_content - 加工描述内容
     */
    public String getProcessContent() {
        return processContent;
    }

    /**
     * 设置加工描述内容
     *
     * @param processContent 加工描述内容
     */
    public void setProcessContent(String processContent) {
        this.processContent = processContent;
    }

    /**
     * 获取跟单员id，关联表员工表：user_info
     *
     * @return merchandiser_id - 跟单员id，关联表员工表：user_info
     */
    public Integer getMerchandiserId() {
        return merchandiserId;
    }

    /**
     * 设置跟单员id，关联表员工表：user_info
     *
     * @param merchandiserId 跟单员id，关联表员工表：user_info
     */
    public void setMerchandiserId(Integer merchandiserId) {
        this.merchandiserId = merchandiserId;
    }

    /**
     * 获取跟单员名称，关联表员工表：user_info
     *
     * @return merchandiser_name - 跟单员名称
     */
    public String getMerchandiserName() {
        return merchandiserName;
    }

    /**
     * 设置跟单员名称，关联表员工表：user_info
     *
     * @param merchandiserName 跟单员名称
     */
    public void setMerchandiserName(String merchandiserName) {
        this.merchandiserName = merchandiserName;
    }

    /**
     * 获取备注
     *
     * @return memo - 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置备注
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取审核状态		0等待审核，1审核通过，2审核失败
     *
     * @return review_status - 审核状态		0等待审核，1审核通过，2审核失败
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 设置审核状态		0等待审核，1审核通过，2审核失败
     *
     * @param reviewStatus 审核状态		0等待审核，1审核通过，2审核失败
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    /**
     * 获取审核时间
     *
     * @return review_time - 审核时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 设置审核时间
     *
     * @param reviewTime 审核时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * 获取审核人id，关联表：user_info
     *
     * @return reviewer_id - 审核人id，关联表：user_info
     */
    public Integer getReviewerId() {
        return reviewerId;
    }

    /**
     * 设置审核人id，关联表：user_info
     *
     * @param reviewerId 审核人id，关联表：user_info
     */
    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 获取附件code，关联附件表：mt_alone_accessory
     *
     * @return product_annex_code - 附件code，关联附件表：mt_alone_accessory
     */
    public String getProductAnnexCode() {
        return productAnnexCode;
    }

    /**
     * 设置附件code，关联附件表：mt_alone_accessory
     *
     * @param productAnnexCode 附件code，关联附件表：mt_alone_accessory
     */
    public void setProductAnnexCode(String productAnnexCode) {
        this.productAnnexCode = productAnnexCode;
    }

    /**
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}