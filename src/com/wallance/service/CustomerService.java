package com.wallance.service;

import com.wallance.dao.CustomerDao;
import com.wallance.domain.Customer;
import com.wallance.domain.PageBean;

/**
 * Created by Wallance on 2017/7/5.
 */
public class CustomerService implements CustomerServiceInterface{
    private CustomerDao customerDao = new CustomerDao();

    /**
     * 分页查询
     * @param pc---当前页码
     * @param pr---每页的记录数
     * @return
     */
    public PageBean findAll(int pc, int pr){
        return customerDao.findAll(pc,pr);
    }

    /**
     * 添加客户信息
     * @param cum
     */
    public void add(Customer cum){
        customerDao.add(cum);
    }

    /**
     * 根据id查询客户信息
     * @param id
     * @return
     */
    public Customer find(String id){
        return customerDao.find(id);
    }


    /**
     * 根据客户id山删除客户信息
     * @param id
     */
    public void delete(String id){
        customerDao.delete(id);
    }

    /**
     * 编辑客户信息
     * @param cum
     */
    public void edit(Customer cum){
        customerDao.edit(cum);
    }


    /**
     * 查询客户信息
     * @param cum
     * @param pc
     * @param pr
     * @return
     */
    public PageBean<Customer> query(Customer cum, int pc, int pr){
        return customerDao.query(cum, pc, pr);
    }
}
