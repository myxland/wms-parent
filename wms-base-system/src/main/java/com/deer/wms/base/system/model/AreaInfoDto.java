package com.deer.wms.base.system.model;

/**
 * Created by Administrator on 2018/6/20.
 */
public class AreaInfoDto extends AreaInfo {

    private String wareName;
    private  String   companyName;
    private Integer companyId;

    public String getWareName() {
        return wareName;
    }


    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
