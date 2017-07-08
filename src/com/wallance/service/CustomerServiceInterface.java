package com.wallance.service;

import com.wallance.domain.Customer;
import com.wallance.domain.PageBean;

/**
 * Created by Wallance on 2017/7/8.
 * 定义Service层的方法
 */
public interface CustomerServiceInterface {
    PageBean findAll(int pc, int pr);
    void add(Customer cum);
    Customer find(String id);
    void delete(String id);
    void edit(Customer cum);
    PageBean<Customer> query(Customer cum, int pc, int pr);
}
