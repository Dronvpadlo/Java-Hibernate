package HW1;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "owner")
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CarWithOwner> cars = new ArrayList<>();

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "drive_license_id", referencedColumnName = "id")
    private DriveLicense driveLicense;

    public Owner(String name, List<CarWithOwner> cars, DriveLicense driveLicense) {
        this.name = name;
        this.cars = cars;
        this.driveLicense = driveLicense;
        driveLicense.setOwner(this);

    }
    public Owner(String name, DriveLicense driveLicense) {
        this.name = name;
        this.driveLicense = driveLicense;
        driveLicense.setOwner(this);
    }
}
