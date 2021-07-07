package ru.geekbrains.homework6;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.homework6.model.Costumer;
import ru.geekbrains.homework6.model.Product;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Costumer costumer = session.get(Costumer.class, 1L);
            System.out.println(costumer);
            for (Product p: costumer.getProducts()) {
                System.out.println(p.getTitle());
            }
            session.getTransaction().commit();

            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            for (Costumer c: product.getCostumers()) {
                System.out.println(c.getName());
            }
            session.getTransaction().commit();



        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
