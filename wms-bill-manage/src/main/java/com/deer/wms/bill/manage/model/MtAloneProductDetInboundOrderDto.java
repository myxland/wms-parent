package com.deer.wms.bill.manage.model;

public class MtAloneProductDetInboundOrderDto extends MtAloneProductDet{

    private String productCode;//品号

    private String itemCode;//料号

    private String productName;//产品名称

    private String colorName;//产品颜色


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
