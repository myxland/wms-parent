package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

/**
* Created by guotuanting on 2019/10/12.
*/
public class MtDictParams extends QueryParams {

    private String dictCodes;

    private Integer dictStatus;

    public Integer getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(Integer dictStatus) {
        this.dictStatus = dictStatus;
    }

    public String getDictCodes() {
        return dictCodes;
    }

    public void setDictCodes(String dictCodes) {
        this.dictCodes = dictCodes;
    }
}
