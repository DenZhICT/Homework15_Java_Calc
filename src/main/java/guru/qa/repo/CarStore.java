package guru.qa.repo;

import guru.qa.db.CarRepository;
import guru.qa.db.impl.PostgresCarRepository;
import guru.qa.entity.CarEntity;

import java.util.List;

public class CarStore {

    private CarRepository carRepository = new PostgresCarRepository();

    public CarEntity lookup(String carName) {
        CarEntity someCar = carRepository.getByName(carName.toLowerCase());
        if (someCar != null) {
            return someCar;
        } else {
            throw new IllegalArgumentException("Car not found for given name: " + carName);
        }
    }

    public String[] getCars() {
        List<CarEntity> cars = carRepository.getAll();
        String[] carsName = new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            String oneOfCars = cars.get(i).getName();
            carsName[i] = oneOfCars.substring(0, 1).toUpperCase() + oneOfCars.substring(1);
        }
        return carsName;
    }
}
