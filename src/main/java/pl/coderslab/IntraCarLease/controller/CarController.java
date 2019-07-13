package pl.coderslab.IntraCarLease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.IntraCarLease.model.Car;
import pl.coderslab.IntraCarLease.model.Lessor;
import pl.coderslab.IntraCarLease.repository.CarRepository;
import pl.coderslab.IntraCarLease.repository.LessorRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LessorRepository lessorRepository;

    @ModelAttribute("allLessors")
    public List<Lessor> viewAllUsersList() {
        return lessorRepository.findAll();
    }

//    @ModelAttribute("allCarByLessor")
//    public List<Car> viewAllCarByLessor() {
//        return carRepository.findAll();
//        // jak  znalesc wszystkie auta pod lessor Id?
//
//    }

    @GetMapping("add")
    public String addCar(Model model) {
        model.addAttribute("car", new Car());
        return "car/add";
    }
    @PostMapping("/add")
    public String saveCarToDb(@ModelAttribute @Valid Car car, BindingResult result) {
        if (result.hasErrors()) {
            return "car/add";
        }
        carRepository.save(car);
        return "home/index";
    }
}
