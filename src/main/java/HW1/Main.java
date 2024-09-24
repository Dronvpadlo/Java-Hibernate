package HW1;

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

        session.save(new Word("Real Madrid"));
        session.save(new Word("Barcelona"));
        session.save(new Word("Villarreal"));
        session.save(new Word("Real Betis"));
        session.save(new Word("Valencia"));
        session.save(new Word("Granada"));
        session.save(new Word("Osasuna"));
        session.save(new Word("Selta Vigo"));


        session.save(new Car("Mazda", CarType.SPORT_CAR, 250, 3700, 2016));
        session.save(new Car("Dodge", CarType.OFFROAD, 320, 8000, 2011));
        session.save(new Car("Toyota", CarType.SEDAN, 220, 3800, 2009));
        session.save(new Car("Honda", CarType.SPORT_CAR, 260, 4700, 2017));
        session.save(new Car("Acura", CarType.SEDAN, 180, 2700, 2017));
        session.save(new Car("Volkswagen", CarType.UNIVERSAL, 150, 2400, 2004));
        session.save(new Car("Opel", CarType.SEDAN, 180, 2800, 2007));
        session.save(new Car("BMW", CarType.OFFROAD, 380, 9400, 2017));

        System.out.println("_________Task1___________");
        List<Word> words = session.createNativeQuery("select * from Word", Word.class).list();
        for (Word word : words) {

            System.out.println(word);
        }
        System.out.println("_________Task2___________");
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