package com.minisheep.model;

/**
 * Created by minisheep on 17/3/23.
 */
public class Customer {
    int custId;
    String name;
    int age;
    String password;


    public Customer(int custId, String name, int age, String password) {
        this.custId = custId;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
