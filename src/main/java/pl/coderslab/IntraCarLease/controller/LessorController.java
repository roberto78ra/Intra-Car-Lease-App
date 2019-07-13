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
import java.util.List;

@Controller
@RequestMapping("/lessor")
public class LessorController {

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "lessor/dashboard";
    }

    @RequestMapping("/allCars")
    public String dashboard(Model model,  HttpSession session) {
        model.addAttribute("allCars", carRepository.findAllByLessor((Lessor) session.getAttribute("loggedLessor")));
        return "lessor/allCars"; //view
    }

    @RequestMapping("/removeCar/{id}")
    public String removeCar(@PathVariable long id) {
        carRepository.deleteById(id);
        return "redirect:/lessor/allCars";
    }

    @GetMapping("editCar/{id}")
    public String editCar(@PathVariable long id, Model model) {
        model.addAttribute("car", carRepository.findById(id));
        return "lessor/editCar";
    }

    @PostMapping("/editCar/{id}")
    public String editCarPOST(@ModelAttribute @Valid Car car, BindingResult result){
        if (result.hasErrors()){
            return "lessor/editCar";
        }
        carRepository.save(car);
        return "redirect:/lessor/dashboard";
    }

    @GetMapping("/addCar")
    public String add(Model model) {
        model.addAttribute("car", new Car());
        return "lessor/addCar";
    }

    @PostMapping("/addCar")
    public String add
            (@Valid @ModelAttribute("car") Car car, BindingResult result, HttpSession session) {
        if(result.hasErrors()) {
            return "lessor/addCar";
        }
        car.setLessor((Lessor) session.getAttribute("loggedLessor"));
        carRepository.save(car);
        return "lessor/dashboard";
    }
}



