package pl.coderslab.IntraCarLease.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Pattern(regexp = "[^0-9]+")
    @Size(min=3,max=20)
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "[^0-9]+")
    @Size(min=3,max=20)
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    private boolean admin;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.MERGE)
    private List<Lessor> lessorList =  new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
