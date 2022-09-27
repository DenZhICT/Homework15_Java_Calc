package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;

public class GuiInterface implements Interface {
    private final CarStore carStore;
    private final TrackStore trackStore;

    public GuiInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    @Override
    public CarEntity chooseCar() {
        String desiredCar = JOptionPane.showInputDialog("Car:");
        return carStore.lookup(desiredCar);
    }

    @Override
    public TrackEntity chooseTrack() {
        String desiredTrack = JOptionPane.showInputDialog("Track:");
        return trackStore.lookup(desiredTrack);
    }

    @Override
    public void showResult(CarEntity car, TrackEntity track) {
        Car mainQuestion = new Car(car, track);
        if (mainQuestion.isPitStopNeeded()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop needed in " + mainQuestion.getMaxLapsForTrack(),
                    "Результат:",
                    1
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop not needed ",
                    "Результат:",
                    1
            );
        }
    }
}
