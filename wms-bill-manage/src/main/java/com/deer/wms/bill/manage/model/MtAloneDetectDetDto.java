package com.deer.wms.bill.manage.model;

public class MtAloneDetectDetDto extends MtAloneDetectDet{
    /**
     * 明细等级/一等品/二等品/三等品/四等品/五等品
     */
	private String productLevel;

	private String detectMachineName;


	public String getProductLevel() {
		return productLevel;
	}

	public void setProductLevel(String productLevel) {
		this.productLevel = productLevel;
	}

	public String getDetectMachineName() {
		return detectMachineName;
	}

	public void setDetectMachineName(String detectMachineName) {
		this.detectMachineName = detectMachineName;
	}
}
