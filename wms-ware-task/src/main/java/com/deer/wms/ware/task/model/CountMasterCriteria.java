package com.deer.wms.ware.task.model;
import com.deer.wms.project.seed.core.service.QueryCriteria;


/**
* Created by guo on 2018/08/20.
*/
public class CountMasterCriteria extends QueryCriteria {
    private Integer countId;
    private String keyWords;
    private String workStartTime;
    private String workEndTime;
    private Integer countType;
    private Integer itemMasterId;
    private String wareCode;
    private String wareName;
    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    public Integer getCountType() {
        return countType;
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    @Override
    public Integer getItemMasterId() {
        return itemMasterId;
    }

    @Override
    public void setItemMasterId(Integer itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    @Override
    public String getWareCode() {
        return wareCode;
    }

    @Override
    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }
}
