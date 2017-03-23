package com.minisheep.dao;

import com.minisheep.model.Customer;

/**
 * Created by minisheep on 17/3/23.
 */
public interface CustomerDAO {
    public void insert(Customer customer);  //插入
    public Customer findByCustomerId(int custId); //Select语句
}
