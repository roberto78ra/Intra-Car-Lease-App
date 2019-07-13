package pl.coderslab.IntraCarLease.viewModes;

import org.hibernate.validator.constraints.pl.NIP;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ViewModeLessor {

    @NotBlank
    private String fullName;

    @NIP
    private String nip;

    private String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}