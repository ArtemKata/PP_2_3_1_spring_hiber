package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars;
        if (count == null || count <= 0) {
            cars = carService.getAllCars(); // Если count не указан или недопустим, получить все машины
        } else {
            cars = carService.getCarsByCount(count); // В противном случае получить запрошенное количество машин
        }
        model.addAttribute("cars", cars);
        return "car";
    }
}
