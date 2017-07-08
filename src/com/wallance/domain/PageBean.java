package com.wallance.domain;

import java.util.List;

/**
 * Created by Wallance on 2017/7/6.
 */
public class PageBean<Object>{
    private int pc;  //当前页码
    private int tr;  //总记录数
    private int pr; //每页记录数
    private List<Object> beanList; //存储对象
    private String url;  //网址


    public int getTp(){  //获取总页数
        int tp = tr%pr == 0? (tr/pr):(tr/pr+1);
        return tp;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }

    public List<Object> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Object> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
