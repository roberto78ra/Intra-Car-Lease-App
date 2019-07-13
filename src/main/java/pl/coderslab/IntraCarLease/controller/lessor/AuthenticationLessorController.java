package pl.coderslab.IntraCarLease.controller.lessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.IntraCarLease.AuthenticationService;
import pl.coderslab.IntraCarLease.model.Lessor;
import pl.coderslab.IntraCarLease.repository.LessorRepository;
import pl.coderslab.IntraCarLease.viewModes.ViewModeFltMgr;
import pl.coderslab.IntraCarLease.model.Employee;
import pl.coderslab.IntraCarLease.viewModes.ViewModeLessor;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/register/lessor")
public class AuthenticationLessorController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private LessorRepository lessorRepository;

    @ModelAttribute
    public void headerMessage(Model model){
        model.addAttribute("headermessage", "Welcome to Intra Car Lease");
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("lessor", new Lessor());
        return "register/lessor/add";
    }

    @PostMapping("/add")
    public String registerSuccess
            (@Valid @ModelAttribute("lessor") Lessor lessor, BindingResult result) {
        if(result.hasErrors()) {
            return "register/lessor/add";
        }
        lessorRepository.save(lessor);
        return "register/lessor/welcome";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("lessor", new ViewModeLessor());
        return "register/lessor/login";
    }

    @PostMapping("/login")
    public String loginSuccess
            (@Valid @ModelAttribute ("lessor") ViewModeLessor viewModeLessor, BindingResult result, HttpSession httpSession ) {
            if(result.hasErrors()) {
                return "register/lessor/login";
            }
            if (authenticationService.givenLessorNameExistInDatabase(viewModeLessor.getFullName())) {
                Lessor loggedLessor = authenticationService.authenticateLessor(viewModeLessor.getNip());
                if(loggedLessor != null) {
                    httpSession.setAttribute("loggedLessor", loggedLessor);
                    return "redirect:/lessor/dashboard"; // redirect to controller with this page
                } else {
                    return "register/lessor/login";
                }
            } else {
                return "register/lessor/login";
            }
        }
    }

