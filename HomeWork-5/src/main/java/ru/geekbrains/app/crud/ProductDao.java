package ru.geekbrains.app.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.app.PrepareDataApp;

public class ProductDao {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            init();
            createProduct("Клубника", 599.9f);
            createProduct("Арбуз", 89.9f);
            deleteProduct(5L);
            updateProductPrice(4L, 229.9f);
            readAndPrintProduct(4L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutDown();
        }
    }

    public static void createProduct(String title, float cost) {
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = new Product(6L, title, cost);
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public static void readAndPrintProduct(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void deleteProduct(long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static void updateProductPrice(long id, float price) {
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println("before" + product);
            product.setPrice(price);
            System.out.println("in memory" + product);
            session.getTransaction().commit();
            System.out.println();
        }
    }

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    private static void shutDown() {
        factory.close();
    }
}
