package com.wallance.domain;

/**
 * Created by Wallance on 2017/7/5.
 */
public class Customer {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String description;


//    //创建构造方法
//    public Customer(String id, String name, String gender, String phone, String email, String description) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.phone = phone;
//        this.email = email;
//        this.description = description;
//    }



    //创建get和set方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
