package com.deer.wms.base.system.model;

import com.deer.wms.project.seed.core.service.QueryParams;

import java.util.List;

public class ClientManageParams extends QueryParams {
	
	private Integer clientId;

	private List<String> headersName;

	public List<String> getHeadersName() {
		return headersName;
	}

	public void setHeadersName(List<String> headersName) {
		this.headersName = headersName;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

}
