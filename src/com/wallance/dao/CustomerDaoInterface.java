package com.wallance.dao;

import com.wallance.domain.Customer;
import com.wallance.domain.PageBean;

/**
 * Created by Wallance on 2017/7/8.
 * 定义Dao层方法
 */
public interface CustomerDaoInterface {
    PageBean findAll(int pc, int pr);
    void add(Customer cum);
    Customer find(String id);
    void delete(String id);
    PageBean<Customer> query(Customer customer, int pc, int pr);
    void edit(Customer cum);
}
