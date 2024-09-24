package HW1and2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "drive_license")
public class DriveLicense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String series;
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public DriveLicense(String series) {
        this.series = series;
    }

    public DriveLicense(String series, Owner owner) {
        this.series = series;
        this.owner = owner;
    }
}
