package Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    // type
    private double power;
    private double price;
    private int year;

    public Car(){

    }

    public Car(String model, double power, double price, int year) {
        this.model = model;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
