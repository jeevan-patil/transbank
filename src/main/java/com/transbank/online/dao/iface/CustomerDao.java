package com.transbank.online.dao.iface;

import com.transbank.online.bean.Customer;

public interface CustomerDao {
    public Customer getCustomerById(String id) throws Exception;
}
