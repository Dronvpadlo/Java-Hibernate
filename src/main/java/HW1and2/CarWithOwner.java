package HW1and2;

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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;


    public CarWithOwner(String model, CarType carType, double power, double price, int year, Owner owner) {
        this.model = model;
        this.carType = carType;
        this.power = power;
        this.price = price;
        this.year = year;
        this.owner = owner;
    }

    public CarWithOwner(String model, CarType carType, double power, double price, int year) {
        this.model = model;
        this.carType = carType;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
