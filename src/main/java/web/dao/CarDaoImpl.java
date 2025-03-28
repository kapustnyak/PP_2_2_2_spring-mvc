package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars;

    public CarDaoImpl() {
        this.cars = Arrays.asList(
                new Car("Chevrolet", "Camaro", 111),
                new Car("Ford", "Mustang", 222),
                new Car("Cadillac", "Escalade", 666),
                new Car("Audi", "TT", 999),
                new Car("Lada", "Priora", 911)

        );
    }

    @Override
    public List<Car> count(Integer count) {
        if (count == null || count >= cars.size()) {
            return cars;
        }
        return cars.stream().limit(count).toList();
    }
}
