package pl.coderslab.IntraCarLease.viewModes;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ViewModeCarUser {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String companyId;

    private String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
