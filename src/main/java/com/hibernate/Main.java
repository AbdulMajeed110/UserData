package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import com.entities.User;

public class Main {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("/com/in/hibernet.cfg.xml");
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // User user1 = new User();
        // user1.setName("Ali");
        // user1.setEmail("ali@gmil.com");
        // user1.setPassword("123");

        // User user2 = new User();
        // user2.setName("Hassan-ITO");
        // user2.setEmail("hassan@gmil.com");
        // user2.setPassword("12345");
        
        // ---------------insert-Record--------------//
        // try {
        // session.save(user2);
        // transaction.commit();
        // } catch (Exception e) {
        // transaction.rollback();
        // e.printStackTrace();
        // }

        // ---------------Select-Record--------------//

        // try {
        // User user = session.get(User.class, 3L);
        // if (user != null) {
        // System.out.println("User detail");
        // System.out.println(user.getId());
        // System.out.println(user.getName());
        // System.out.println(user.getEmail());
        // System.out.println(user.getPassword());

        // } else {
        // System.out.println("User Not Found");
        // }
        // } catch (Exception e) {
        // // TODO: handle exception
        // }

        // ----------------Update-Record---------------//
        // User user2 = session.get(User.class, 4L);
        // try {
        // if (user2 != null) {
        // user2.setName("NisarAhmed"); // Modify fields as needed
        // session.saveOrUpdate(user2);
        // transaction.commit();
        // } else {
        // System.out.println("User not found!");
        // }
        // } catch (Exception e) {
        // transaction.rollback();
        // e.printStackTrace();
        // }

        // ----------------Deleted-Record---------------//
        User user2 = session.get(User.class, 5L);
        try {
            if (user2 != null) {
                session.delete(user2);
                transaction.commit();
                System.out.println("User deleted successfully!");

            } else {
                System.out.println("User not found!");
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}