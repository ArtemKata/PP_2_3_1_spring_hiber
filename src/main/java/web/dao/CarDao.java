package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("Ford", "Mustang", 2019));
        cars.add(new Car("Honda", "Civic", 2021));
        cars.add(new Car("Chevrolet", "Cruze", 2018));
        cars.add(new Car("Volkswagen", "Passat", 2022));
    }

    public List<Car> getCars() {
        return cars;
    }
    public List<Car> countCar(int count) {
        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
