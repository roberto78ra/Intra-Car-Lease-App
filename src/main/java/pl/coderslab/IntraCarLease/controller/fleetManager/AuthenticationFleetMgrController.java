package pl.coderslab.IntraCarLease.controller.fleetManager;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.IntraCarLease.repository.EmployeeRepository;
import pl.coderslab.IntraCarLease.viewModes.ViewModeFltMgr;
import pl.coderslab.IntraCarLease.AuthenticationService;
import pl.coderslab.IntraCarLease.model.Employee;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register/fltMgr")
public class AuthenticationFleetMgrController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @ModelAttribute
    public void headerMessage(Model model) {
        model.addAttribute("headermessage", "Welcome to Intra Car Lease");
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "register/fltMgr/add";
    }

    @PostMapping("/add")
    public String registerSuccess
            (@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "register/fltMgr/add";
        }
        employee.setPassword(BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
        employeeRepository.save(employee);
        return "register/fltMgr/welcome";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("fleetMgr", new ViewModeFltMgr());
        return "register/fltMgr/login";
    }

    @PostMapping("/login")
    public String loginSuccess
            (@Valid @ModelAttribute("fleetMgr") ViewModeFltMgr viewModeFltMgr, HttpSession httpSession, BindingResult result) {
        if (result.hasErrors()) {
            return "register/fltMgr/login";
        }
        if (authenticationService.givenEmailExistInDatabase(viewModeFltMgr.getEmail())) {
            Employee employee = authenticationService.authenticateEmployee(viewModeFltMgr.getEmail(), viewModeFltMgr.getPassword());
            if (employee != null) {
                httpSession.setAttribute("loggedFleetMgr", employee);
                return "redirect:/fleetMgr/dashboard";
            } else {
                return "register/fltMgr/login";
            }
        } else {
            return "register/fltMgr/login";
        }
    }
}

