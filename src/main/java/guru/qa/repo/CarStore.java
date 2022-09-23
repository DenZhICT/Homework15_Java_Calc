package guru.qa.repo;

import guru.qa.domain.Car;
import guru.qa.domain.Ferrari;
import guru.qa.domain.Mercedes;

import java.util.HashMap;
import java.util.Map;

public class CarStore {

    private Map<String, Car> store = Map.of(
        "Ferrari", new Ferrari(),
        "Mercedes", new Mercedes()
    );

    public Car lookup(String carName) {
        for (String key : store.keySet()) {
            if (key.equalsIgnoreCase(carName)) {
                return store.get(key);
            }
        }
        throw new IllegalArgumentException("Car not found for given name: " + carName);
    }
}
