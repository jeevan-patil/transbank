package com.transbank.online.dao.iface;

import java.util.List;

import com.transbank.online.bean.Customer;

public interface CustomerDao {
    public List<Customer> getCustomerById(String id) throws Exception;
}
