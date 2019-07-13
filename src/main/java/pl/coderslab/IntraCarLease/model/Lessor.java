package pl.coderslab.IntraCarLease.model;

import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name =  "CarLessor")
public class Lessor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String fullName;
    @NIP
    private String nip;
    @REGON
    private String regon;
    @NotEmpty
    private String address;

    @OneToMany(mappedBy = "lessor", cascade = CascadeType.REMOVE)
    private List<Car> cars;

    @ManyToOne
    private Employee employee;

    public Lessor() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
