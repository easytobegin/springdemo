package com.minisheep.controller;

import com.minisheep.dao.JdbcCustomerDao;
import com.minisheep.model.Customer;
import com.minisheep.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by minisheep on 17/3/23.
 */
public class VerifyController extends AbstractController{
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //String dbName = JdbcCustomerDao.getInstance().findByCustomerId(3).getName();
        //String dbPassword = JdbcCustomerDao.getInstance().findByCustomerId(3).getPassword();

        ModelAndView mv = null;

        if(username == null){  //跳转回登录界面
            mv = new ModelAndView(new RedirectView("/login")); //重定向
            mv.setViewName("login");
            return mv;
        }

        boolean flag = JdbcCustomerDao.getInstance().isExistUserandPass(username,password);
        //System.out.println("username:" + username + " " + "password:" + password);

        //System.out.println("dbusername:" + dbName + " " + "dbpassword:" + dbPassword);

        //登录成功
        if(flag){
            mv = new ModelAndView(new RedirectView("/success")); //数据
            //mv.setViewName("success");  //View
          //System.out.println("验证成功！");
        }else{ //失败
            mv = new ModelAndView(new RedirectView("/login"));
            mv.setViewName("login");
        }

        return mv;
    }
}
