package com.minisheep.dao;

import com.minisheep.model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Table;

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

    public boolean isExistUserandPass(String username,String password) {
        Configuration config = new Configuration().configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        //hql语句对应的类不是数据库表名，而是实体类中的类名，要查询的就是里面的成员变量,反正就是面线对象的思想.
        String hql = "select count(*) from Customer obj where obj.name = ? and obj.password = ?";
        Query query = session.createQuery(hql).setParameter(0,username).setParameter(1,password);
        Long count = (Long) query.uniqueResult();
        return count > 0 ? true : false;
    }
}
