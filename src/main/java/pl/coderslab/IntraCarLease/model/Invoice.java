package pl.coderslab.IntraCarLease.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name =  "Invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String invoiceNumber;

    private BigDecimal finalAmount;

    @OneToOne //(mappedBy = "invoice", cascade = CascadeType.REMOVE)
    private LeaseHistory history;

    public Invoice () {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public LeaseHistory getHistory() {
        return history;
    }

    public void setHistory(LeaseHistory history) {
        this.history = history;
    }
}
