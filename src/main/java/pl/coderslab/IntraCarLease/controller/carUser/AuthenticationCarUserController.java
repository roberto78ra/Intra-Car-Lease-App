package pl.coderslab.IntraCarLease.controller.carUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.IntraCarLease.AuthenticationService;
import pl.coderslab.IntraCarLease.model.CarUser;
import pl.coderslab.IntraCarLease.repository.CarUserRepository;
import pl.coderslab.IntraCarLease.viewModes.ViewModeCarUser;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register/driver")
public class AuthenticationCarUserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CarUserRepository carUserRepository;

    @ModelAttribute
    public void headerMessage(Model model){
        model.addAttribute("headermessage", "Welcome to Intra Car Lease");
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("caruser", new CarUser());
        return "register/driver/add";
    }

    @PostMapping("/add")
    public String registerSuccess
            (@Valid @ModelAttribute("caruser") CarUser carUser, BindingResult result) {
        if(result.hasErrors()) {
            return "register/driver/add";
        }
        carUserRepository.save(carUser);
        return "register/driver/welcome";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("viewModeCarUser", new ViewModeCarUser());
        return "register/driver/login";
    }

    @PostMapping("/login")
    public String loginSuccess(@ModelAttribute ViewModeCarUser viewModeCarUser,
                                     HttpSession httpSession, BindingResult result) {
        if ("login".equals(viewModeCarUser.getAction())) {
            if (result.hasErrors()) {
                return "register/driver/login";
            }
            if (authenticationService.givenCompanyIdExistInDatabse(viewModeCarUser.getCompanyId())) {
                CarUser carUser = authenticationService.authenticateDriver(viewModeCarUser.getEmail());
                if (carUser != null) {
                    httpSession.setAttribute("loggedDriver", carUser.getId());
                    return "redirect:/";
                } else {
                    return "register/driver/login";
                }
            } else {
                return "register/driver/login";
            }
        }
        return "register/driver/login";
    }
}
