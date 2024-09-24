package HW1and2;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private double power;
    private double price;
    private int year;

    public Car(){

    }

    public Car(String model, CarType carType, double power, double price, int year) {
        this.model = model;
        this.carType = carType;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
