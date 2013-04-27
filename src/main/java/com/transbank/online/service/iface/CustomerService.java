package com.transbank.online.service.iface;

import java.util.List;

import com.transbank.online.bean.Customer;

public interface CustomerService {
    public List<Customer> getCustomerById(String id);
}
