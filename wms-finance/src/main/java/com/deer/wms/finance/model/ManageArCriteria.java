package com.deer.wms.finance.model;

import com.deer.wms.project.seed.core.service.QueryCriteria;

/**
* Created by  on 2018/07/04.
*/
public class ManageArCriteria extends QueryCriteria {
    private String keyWords;
    private Integer companyId;
    private String fTypeCode ;
    private String flowCode;

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getfTypeCode() {
        return fTypeCode;
    }

    public void setfTypeCode(String fTypeCode) {
        this.fTypeCode = fTypeCode;
    }


}
