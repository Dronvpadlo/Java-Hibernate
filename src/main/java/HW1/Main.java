package HW1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClasses(Word.class, Car.class, Owner.class, DriveLicense.class, CarWithOwner.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory
                .openSession();

        session
                .beginTransaction();

        session.persist(new Word("Real Madrid"));
        session.persist(new Word("Barcelona"));
        session.persist(new Word("Villarreal"));
        session.persist(new Word("Real Betis"));
        session.persist(new Word("Valencia"));
        session.persist(new Word("Granada"));
        session.persist(new Word("Osasuna"));
        session.persist(new Word("Selta Vigo"));


        session.persist(new Car("Mazda", CarType.SPORT_CAR, 250, 3700, 2016));
        session.persist(new Car("Dodge", CarType.OFFROAD, 320, 8000, 2011));
        session.persist(new Car("Toyota", CarType.SEDAN, 220, 3800, 2009));
        session.persist(new Car("Honda", CarType.SPORT_CAR, 260, 4700, 2017));
        session.persist(new Car("Acura", CarType.SEDAN, 180, 2700, 2017));
        session.persist(new Car("Volkswagen", CarType.UNIVERSAL, 150, 2400, 2004));
        session.persist(new Car("Opel", CarType.SEDAN, 180, 2800, 2007));
        session.persist(new Car("BMW", CarType.OFFROAD, 380, 9400, 2017));

//____________________________________________________________________________


        List<CarWithOwner> markCars = new ArrayList<>();
        markCars.add(new CarWithOwner("BMW", CarType.OFFROAD, 380, 9400, 2017));
        markCars.add(new CarWithOwner("Mazda", CarType.SPORT_CAR, 250, 3700, 2016));

        List<CarWithOwner> elizabetCars = new ArrayList<>();
        elizabetCars.add(new CarWithOwner("Dodge", CarType.OFFROAD, 320, 8000, 2011));
        elizabetCars.add(new CarWithOwner("Toyota", CarType.SEDAN, 220, 3800, 2009));

        List<CarWithOwner> arthurCars = new ArrayList<>();
        arthurCars.add(new CarWithOwner("Acura", CarType.SEDAN, 180, 2700, 2017));

        List<CarWithOwner> liamCars = new ArrayList<>();
        liamCars.add(new CarWithOwner("Opel", CarType.SEDAN, 180, 2800, 2007));
        liamCars.add(new CarWithOwner("Honda", CarType.SPORT_CAR, 260, 4700, 2017));

        session.persist(new Owner("Mark", markCars, new DriveLicense("602880")));
        session.persist(new Owner("Elizabet", elizabetCars, new DriveLicense("327557")));
        session.persist(new Owner("Arthur", arthurCars, new DriveLicense("336475")));
        session.persist(new Owner("Liam", liamCars, new DriveLicense("667209")));




        System.out.println("_________Task1.1___________");
        List<Word> words = session.createNativeQuery("select * from Word", Word.class).list();
        for (Word word : words) {

            System.out.println(word);
        }
        System.out.println("_________Task1.2___________");
        List<Car> cars = session.createNativeQuery("select * from Car", Car.class).list();

        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println("_________Task2___________");
        List<Owner> owners = session.createNativeQuery("select * from Owner", Owner.class).list();
        owners.forEach(System.out::println);
        owners.forEach(owner -> System.out.println(owner.getDriveLicense()));



        session
                .getTransaction()
                .commit();

        session.close();

        sessionFactory
                .close();
    }
}