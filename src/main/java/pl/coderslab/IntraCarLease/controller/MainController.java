package pl.coderslab.IntraCarLease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.IntraCarLease.model.Lessor;
import pl.coderslab.IntraCarLease.repository.LessorRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private LessorRepository lessorRepository;

    @ModelAttribute
    public void headerMessage(Model model){
        model.addAttribute("headermessage", "Welcome to Intra Car Lease");
    }

    @ModelAttribute ("allLessors")
    public List<Lessor> getAllLessors (){
        return lessorRepository.findAll();
    }


    @GetMapping("/") // czy mozna  uzyc RequestMapping zamiast  GetMapping w tej  sytuacji ?
    public String home(@Valid Model model, HttpSession httpSession) { // Model model musi  byc tutaj? Skoro  nigdzie nie uzyty, musi byc?
        if(httpSession.getAttribute("loggedFleetMgr") != null) {
            return "home/fleetMgr/welcome"; // view "welcome"
        }
        if(httpSession.getAttribute("loggedDriver") != null) {
            return "home/driver/welcome";
        }
        if(httpSession.getAttribute("loggedLessor") != null) {
            return "home/lessor/welcome"; //
        }
        return "redirect:/home";
    }

    // if nobody is logged the main page starts from here
    @RequestMapping("/home")
    public String loginas() {
        return "authentication/home"; //view
    }

//todo
//    @GetMapping("/showCars/{id}")
//    public String showCars(Model model){//
//    model.addAttribute("cars", lessorRepository.findAllCarsByLesserId
//}


}
