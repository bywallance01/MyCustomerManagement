package com.wallance.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.wallance.domain.Customer;
import com.wallance.domain.PageBean;
import com.wallance.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by Wallance on 2017/7/5.
 */
public class CustomerServlet extends BaseServlet {
    private CustomerService customerService = new CustomerService();



    /**
     * 分页查询
     * @param request
     * @param response
     * @return
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response){
        int pc = getPc(request);  //获取页码
        int pr = 10;  //设置每页显示十行

        PageBean<Customer> pb = customerService.findAll(pc, pr);  //获取分页对象
        pb.setUrl(getUrl(request));  //设置url

        request.setAttribute("pb", pb);

        return "f:/list.jsp";
    }


    /**
     * 添加客户
     * @param request
     * @param response
     * @return
     */
    public String add(HttpServletRequest request, HttpServletResponse response){
        Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);  //获取并封装客户对象
        customer.setId(CommonUtils.uuid());
        //System.out.println(customer.getName());
        customerService.add(customer);

        request.setAttribute("msg", "客户添加成功！");
        return "/msg.jsp";
    }


    /**
     * 根据客户id删除客户
     * @param request
     * @param response
     * @return
     */
    public String delete(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        customerService.delete(id);

        request.setAttribute("msg", "客户删除成功！");

        return "/msg.jsp";
    }


    /**
     * 查询客户信息
     * @param request
     * @param response
     * @return
     */
    public String query(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        PageBean<Customer> pb = new PageBean<>();
        int pc = getPc(request);
        int pr = 10;

        Customer cum = CommonUtils.toBean(request.getParameterMap(), Customer.class);   //获取客户信息
        cum = encoding(cum);  //重新编码

        pb = customerService.query(cum, pc, pr);
        pb.setUrl(getUrl(request));
        System.out.println(getUrl(request));
        request.setAttribute("pb", pb);

        return "/list.jsp";
    }


    /**
     * 根据id查询获取客户信息
     * @param request
     * @param response
     * @return
     */
    public String preEdit(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Customer cum = customerService.find(id);

        request.setAttribute("customer", cum);
        return "/edit.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response){
        Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);

        customerService.edit(customer);

        request.setAttribute("msg", "用户编辑成功！");
        return "/msg.jsp";
    }


    /**
     * 获取当前页对应的url
     * @param request
     * @return
     */
    private String getUrl(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();


        if(queryString.contains("&pc=")){
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0,index);
        }
        return contextPath+servletPath+"?"+queryString;
    }


    /**
     * 获取当前页码
     * @param request
     * @return
     */
    private int getPc(HttpServletRequest request){
        String pcStr = request.getParameter("pc");

        if(pcStr == null || pcStr.trim().isEmpty()){
            return 1;
        }

        return Integer.parseInt(pcStr);
    }


    /**
     * 对中文进行编码
     * @param customer
     * @return
     * @throws UnsupportedEncodingException
     */
    private Customer encoding(Customer customer) throws UnsupportedEncodingException {
        String name = customer.getName();
        String gender = customer.getGender();
        String phone = customer.getPhone();
        String email = customer.getEmail();

        if(name != null && !name.trim().isEmpty()){  //name非空
            name = new String(name.getBytes("ISO-8859-1"),"utf-8");
            customer.setName(name);
        }

        if(gender != null && !gender.trim().isEmpty()){
            gender = new String(gender.getBytes("ISO-8859-1"),"utf-8");
            customer.setGender(gender);
        }

        if(email != null && !email.trim().isEmpty()){
            email = new String(email.getBytes("ISO-8859-1"),"utf-8");
            customer.setEmail(email);
        }

        if(phone != null && !phone.trim().isEmpty()){
            phone = new String(phone.getBytes("ISO-8859-1"),"utf-8");
            customer.setPhone(phone);
        }

        return customer;
    }

}
