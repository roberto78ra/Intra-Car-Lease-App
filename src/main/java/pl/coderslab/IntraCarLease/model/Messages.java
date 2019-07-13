package pl.coderslab.IntraCarLease.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name =  "Messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Size(max = 250)
    private String leaseFeedback;

    @ManyToOne
    private LeaseHistory history;

    public Messages () {

    }



}
