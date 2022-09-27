package guru.qa.db;

import guru.qa.entity.CarEntity;

import java.util.List;

public interface CarRepository {
    List<CarEntity> getAll();

    CarEntity getByName(String carName);
}
