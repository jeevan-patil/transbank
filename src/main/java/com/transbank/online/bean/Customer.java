package com.transbank.online.bean;

import java.io.Serializable;

public class Customer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9186357723906698510L;

    private String custId;
    private String custName;
    private String custAddress;
    private String custTier;

    public String getCustId() {
	return custId;
    }

    public void setCustId(String custId) {
	this.custId = custId;
    }

    public String getCustName() {
	return custName;
    }

    public void setCustName(String custName) {
	this.custName = custName;
    }

    public String getCustAddress() {
	return custAddress;
    }

    public void setCustAddress(String custAddress) {
	this.custAddress = custAddress;
    }

    public String getCustTier() {
	return custTier;
    }

    public void setCustTier(String custTier) {
	this.custTier = custTier;
    }

    @Override
    public String toString() {
	return "Customer [custId=" + custId + ", custName=" + custName
		+ ", custAddress=" + custAddress + ", custTier=" + custTier
		+ "]";
    }

}
