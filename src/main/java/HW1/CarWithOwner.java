package HW1;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CarWithOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private double power;
    private double price;
    private int year;

    public CarWithOwner(String model, CarType carType, double power, double price, int year) {
        this.model = model;
        this.carType = carType;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
