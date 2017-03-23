package com.minisheep.dao;

import com.minisheep.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by minisheep on 17/3/23.
 */
public class JdbcCustomerDao implements CustomerDAO {
    private JdbcCustomerDao(){

    }

    private static final JdbcCustomerDao instance = new JdbcCustomerDao();

    public static JdbcCustomerDao getInstance(){
        return instance;
    }

    public void insert(Customer customer) {

        //使用Hibernate的Api来完成将Customer信息保存到mysql数据库中
        Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();  //相当于得到一个connection

        //开启事务
        session.beginTransaction();

        //操作
        session.save(customer);

        //事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public Customer findByCustomerId(int custId) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        //开启事务
        session.beginTransaction();

        //根据具体业务编写代码
        Customer c = session.load(Customer.class,custId);

        System.out.println(c.getName());

        //事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return c;
    }
}
