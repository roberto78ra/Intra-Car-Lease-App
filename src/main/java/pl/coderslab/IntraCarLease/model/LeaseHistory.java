package pl.coderslab.IntraCarLease.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "History")
public class LeaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;

    private Integer kmEnd;

    private long userId;

    @NotNull
    @ManyToOne
    private Car car;

    @OneToOne(mappedBy = "history", cascade = CascadeType.REMOVE)
    private Invoice invoice;

    @OneToOne //(mappedBy = "leaseHistory", cascade = CascadeType.REMOVE)
    private CarUser carUser;

    @OneToMany(mappedBy = "history", cascade = CascadeType.REMOVE)
    private List<Messages> messages;

    public LeaseHistory () {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getKmEnd() {
        return kmEnd;
    }

    public void setKmEnd(Integer kmEnd) {
        this.kmEnd = kmEnd;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
