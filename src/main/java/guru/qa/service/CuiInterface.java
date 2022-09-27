package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import java.util.Scanner;

public class CuiInterface implements Interface {
    private final CarStore carStore;
    private final TrackStore trackStore;
    private final Scanner sc = new Scanner(System.in);

    public CuiInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    @Override
    public CarEntity chooseCar() {
        System.out.print("Car: ");
        String desiredCar = sc.nextLine();
        return carStore.lookup(desiredCar);
    }

    @Override
    public TrackEntity chooseTrack() {
        System.out.print("Track: ");
        String desiredTrack = sc.nextLine();
        return trackStore.lookup(desiredTrack);
    }

    @Override
    public void showResult(CarEntity car, TrackEntity track) {
        Car mainQuestion = new Car(car, track);
        if (mainQuestion.isPitStopNeeded()) {
            System.out.println("Результат:\nPit-stop needed in " + mainQuestion.getMaxLapsForTrack());
        } else {
            System.out.println("Результат:\nPit-stop not needed");
        }
    }
}
