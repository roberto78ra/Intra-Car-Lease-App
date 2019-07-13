package pl.coderslab.IntraCarLease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.IntraCarLease.model.Car;
import pl.coderslab.IntraCarLease.model.Lessor;
import pl.coderslab.IntraCarLease.repository.CarRepository;
import pl.coderslab.IntraCarLease.repository.LessorRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/fleetMgr")
public class FleetMgrController {

    @Autowired
    LessorRepository lessorRepository;

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "fleetMgr/dashboard";
    }

    @RequestMapping("/allLessors")
    public String dashboard(Model model) {
        model.addAttribute("allLessors", lessorRepository.findAll());
        return "fleetMgr/allLessors"; //view
    }

    @GetMapping("/assignCarToUser")
    public String assignCar(Model model) {
        model.addAttribute("car", new Car());
        return "fleetMgr/assignCar";
    }

    @PostMapping("/assignCarToUser")
    public String assignCarPost
            (@Valid @ModelAttribute("car") Car car, BindingResult result, HttpSession session) {
        if(result.hasErrors()) {
            return "fleetMgr/assignCarToUser";
        }
        car.setLessor((Lessor) session.getAttribute("loggedLessor"));
        carRepository.save(car);
        return "lessor/dashboard";
    }
}



