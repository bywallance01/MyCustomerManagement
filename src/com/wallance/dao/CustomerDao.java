package com.wallance.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.wallance.domain.Customer;
import com.wallance.domain.PageBean;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wallance on 2017/7/5.
 */
public class CustomerDao implements CustomerDaoInterface{
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 分页查询
     * @param pc  当前页码
     * @param pr  每页记录数
     * @return  返回值是PageBean对象
     */
    public PageBean findAll(int pc, int pr) {
        PageBean pageBean = new PageBean<Customer>();

        pageBean.setPc(pc);  //设置当前页码
        pageBean.setPr(pr); //设置每页记录数

        String sql = "SELECT count(*) FROM t_customer";
        Number number = 0;
        try {
            number = (Number) qr.query(sql, new ScalarHandler<>());


            int num = number.intValue();
            pageBean.setTr(num);  //设置总记录数

            sql = "SELECT * FROM t_customer order by name limit ?, ?";
            Object[] params = {(pc - 1) * pr, pr};
            List<Customer> beanList = qr.query(sql, new BeanListHandler<>(Customer.class), params);

            pageBean.setBeanList(beanList);
            return pageBean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 添加客户信息
     * @param cum
     */
    public void add(Customer cum){
        try{
            String sql = "INSERT INTO t_customer VALUES(?,?,?,?,?,?)";
            Object[] params = {cum.getId(), cum.getName(), cum.getGender(),
                                  cum.getPhone(), cum.getEmail(), cum.getDescription()};
            qr.update(sql, params);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 根据ID查询客户
     * @param id
     * @return
     */
    public Customer find(String id){
        try{
            String sql = "SELECT * FROM t_customer WHERE id = ?";
            Object[] params = {id};
            return qr.query(sql, new BeanHandler<Customer>(Customer.class), params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 根据id删除客户
     * @param id
     */
    public void delete(String id){
        try{
            String sql = "DELETE FROM t_customer WHERE id = ?";
            Object[] params = {id};
            qr.update(sql, params);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询客户信息
     * @param customer  客户信息
     * @param pc  当前页码
     * @param pr  每页记录数
     * @return
     */
    public PageBean<Customer> query(Customer customer, int pc, int pr){
        try{
            PageBean<Customer> pb = new PageBean<>();
            pb.setPc(pc);
            pb.setPr(pr);

            StringBuilder cntSql = new StringBuilder("SELECT COUNT(*) FROM t_customer ");
            StringBuilder whereSql = new StringBuilder(" WHERE 1=1 ");
            List<Object> list = new ArrayList<Object>();

            String name = customer.getName().trim();
            if(name != null && !name.isEmpty()){
                whereSql.append("and name like ?");
                list.add("%"+name+"%");
            }

            String gender = customer.getGender().trim();
            if(gender != null && !gender.isEmpty()){
                whereSql.append(" and gender=?");
                list.add(gender);
            }

            String phone = customer.getPhone().trim();
            if(phone != null && !phone.isEmpty()){
                whereSql.append(" and phone like ?");
                list.add("%"+phone+"%");
            }

            String email = customer.getEmail().trim();
            if(email != null && !email.isEmpty()){
                whereSql.append(" and email like ?");
                list.add("%"+email+"%");
            }

            //获取符合条件的总记录数
            Number number = (Number)qr.query(cntSql.append(whereSql).toString(), new ScalarHandler<>(), list.toArray());
            int tr = number.intValue();
            pb.setTr(tr);

            StringBuilder sql = new StringBuilder("SELECT * FROM t_customer ");
            StringBuilder limitSql = new StringBuilder(" limit ?, ?");

            list.add((pc-1)*pr);
            list.add(pr);

            List<Customer> benaList = qr.query(sql.append(whereSql).append(limitSql).toString(),
                    new BeanListHandler<>(Customer.class), list.toArray());
            pb.setBeanList(benaList);


            return pb;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 编辑客户信息
     * @param cum
     */
    public void edit(Customer cum){
        try{
            String sql = "UPDATE t_customer SET name=?,gender=?,phone=?,email=?,description=? WHERE id=?";
            Object[] params = {cum.getName(), cum.getGender(), cum.getPhone(), cum.getEmail(), cum.getDescription(), cum.getId()};

            qr.update(sql, params);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }



}



