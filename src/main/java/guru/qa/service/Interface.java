package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;

public abstract class Interface {

    public abstract Car chooseCar();

    public abstract Track chooseTrack();

    public abstract void showResult(Car car, Track track);
}
