package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarDao carDao;

    public List<Car> getAllCars() {
        return carDao.getCars();
    }

    public List<Car> getCarsByCount(int count) {
        if (count >= 5) {
            return carDao.getCars();
        } else {
            return carDao.getCars().subList(0, count);
        }
    }
}
