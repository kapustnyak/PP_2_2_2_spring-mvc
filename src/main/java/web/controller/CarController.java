package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.List;


@Controller
@RequestMapping(value = "/cars")
public class CarController {
    private final CarServiceImpl carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping
    public String cars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        if (count == null) model.addAttribute("cars", carService.count(null));
        else {
            model.addAttribute("cars", carService.count(count));
        }
        return "cars";
    }
}
