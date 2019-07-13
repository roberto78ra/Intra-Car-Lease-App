package pl.coderslab.IntraCarLease.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(max = 7)
    private String carPlate;
    @NotEmpty
    private String brand;

    private String model;

    private String fuelType;

    public Car(){
    }

    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
    private List<LeaseHistory> history;

    @ManyToOne
    private Lessor lessor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public List<LeaseHistory> getHistory() {
        return history;
    }

    public void setHistory(List<LeaseHistory> history) {
        this.history = history;
    }

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }
}
