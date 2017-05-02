package com.spi.membershipdetails.bean;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

 
@Component
public class UserActionHistory {
	
	private  BigDecimal historyId;	
	 
	private  String function;
	 
	private String action;
	
	private int ban;
	
	private String attributeName;
	
	private String oldValue;
	 
	private String newValue;
	
	private String modificationReason;

	private BigDecimal  statusCode;
	
	private String  lastUpdateDate;

	private String  lastUpdateBy;
	
	public UserActionHistory(BigDecimal historyId, String function, String action,
			int ban, String attributeName, String oldValue, String newValue,
			String modificationReason, BigDecimal statusCode,
			String lastUpdateDate, String lastUpdateBy) {
		super();
		this.historyId = historyId;
		this.function = function;
		this.action = action;
		this.ban = ban;
		this.attributeName = attributeName;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.modificationReason = modificationReason;
		this.statusCode = statusCode;
		this.lastUpdateDate = lastUpdateDate;
		this.lastUpdateBy = lastUpdateBy;
	}

	public BigDecimal getHistoryId() {
		return historyId;
	}

	public void setHistoryId(BigDecimal historyId) {
		this.historyId = historyId;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getModificationReason() {
		return modificationReason;
	}

	public void setModificationReason(String modificationReason) {
		this.modificationReason = modificationReason;
	}

	public BigDecimal getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(BigDecimal statusCode) {
		this.statusCode = statusCode;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public UserActionHistory() {
		// TODO Auto-generated constructor stub
	}

	@Id
	public int getBan() {
		return ban;
	}


	public void setBan(int ban) {
		this.ban = ban;
	}
	
	

}
