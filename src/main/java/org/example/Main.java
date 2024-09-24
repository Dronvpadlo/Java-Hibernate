package org.example;

import Classes.Car;
import Classes.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClasses(Word.class, Car.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory
                .openSession();

        session
                .beginTransaction();

        Word vpadlo = new Word("Vpadlo");
        session.save(vpadlo);


        session
                .getTransaction()
                .commit();

        session.close();

        sessionFactory
                .close();
    }
}