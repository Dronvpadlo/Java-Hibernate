package org.example;

import Classes.Car;
import Classes.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

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

        Word sunset = new Word("Sunset");
        Word heaven = new Word("Heaven");
        Word river = new Word("River");
        Word mountain = new Word("Mountain");
        session.save(sunset);
        session.save(heaven);
        session.save(river);
        session.save(mountain);

        Car mazda = new Car("Mazda", 250, 2600, 2016);
        Car dodge = new Car("Dodge", 320, 4000, 2011);
        Car toyota = new Car("Toyota", 220, 1800, 2009);
        Car honda = new Car("Honda", 260, 2700, 2017);

        session.save(mazda);
        session.save(dodge);
        session.save(toyota);
        session.save(honda);


        List<Word> words = session.createNativeQuery("select * from Word", Word.class).list();
        for (Word word : words) {
            System.out.println(word);
        }
        List<Car> cars = session.createNativeQuery("select * from Car", Car.class).list();
        for (Car car : cars) {
            System.out.println(car);
        }



        session
                .getTransaction()
                .commit();

        session.close();

        sessionFactory
                .close();
    }
}