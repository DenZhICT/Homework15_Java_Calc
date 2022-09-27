package guru.qa.domain;

import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;

public class Car {
    private CarEntity carEntity;
    private TrackEntity trackEntity;
    private int maxLapsForTrack;

    public Car(CarEntity carEntity, TrackEntity trackEntity) {
        this.carEntity = carEntity;
        this.trackEntity = trackEntity;
    }

    public boolean isPitStopNeeded() {
        setMaxLapsForTrack();
        return maxLapsForTrack < trackEntity.getLaps();
    }

    public int getMaxLapsForTrack() {
        return this.maxLapsForTrack;
    }

    private void setMaxLapsForTrack() {
        int lapDistance = trackEntity.getLapDistance();
        double fuelEconomy = carEntity.getFuelEconomy();
        int fuelCapacity = carEntity.getFuelCapacity();
        double maxDistanceForCar = fuelCapacity * 100 / fuelEconomy;
        this.maxLapsForTrack = (int) ((maxDistanceForCar * 1000) / lapDistance);
    }
}
