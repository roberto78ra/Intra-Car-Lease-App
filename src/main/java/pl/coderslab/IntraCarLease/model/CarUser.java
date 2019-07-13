package pl.coderslab.IntraCarLease.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "car_user")
public class CarUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String companyId;

    private boolean fuelCard;

    @OneToOne (mappedBy = "carUser", cascade = CascadeType.REMOVE)
    private LeaseHistory leaseHistory;

    public CarUser() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public boolean isFuelCard() {
        return fuelCard;
    }

    public void setFuelCard(boolean fuelCard) {
        this.fuelCard = fuelCard;
    }

    public LeaseHistory getLeaseHistory() {
        return leaseHistory;
    }

    public void setLeaseHistory(LeaseHistory leaseHistory) {
        this.leaseHistory = leaseHistory;
    }
}
