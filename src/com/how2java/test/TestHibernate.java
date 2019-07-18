package com.how2java.test;
   
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
   
public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
   
        Session s = sf.openSession();
        s.beginTransaction();
   
        s.createQuery("from Category").list();
           
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
}