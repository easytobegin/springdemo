package com.minisheep.controller;

import com.minisheep.dao.JdbcCustomerDao;
import com.minisheep.model.Customer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * Created by minisheep on 17/3/22.
 */
public class HelloWorldController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.收集参数、验证参数
        //2.绑定参数到命令对象
        //3.将命令对象传入业务对象进行业务处理
        //4.选择下一个页面

        Customer customer = new Customer(1,"陈扬",22,"220015");
        Customer customer1 = new Customer(2,"海峰",22,"haifeng");
        Customer customer2 = new Customer(3,"小灿",22,"xiaocan");

        JdbcCustomerDao.getInstance().insert(customer);
        JdbcCustomerDao.getInstance().insert(customer1);
        JdbcCustomerDao.getInstance().insert(customer2);

        Customer customer3 = JdbcCustomerDao.getInstance().findByCustomerId(3);

        ModelAndView mv = new ModelAndView();
        //添加模型数据,可以是任意的POJO对象
        mv.addObject("message","姓名:" + customer3.getName() + ",年龄:" + customer3.getAge());  //模型数据
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("hello");   //视图数据
        return mv;
    }
}
