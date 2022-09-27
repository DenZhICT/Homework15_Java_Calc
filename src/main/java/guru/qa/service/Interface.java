package guru.qa.service;

import guru.qa.entity.CarEntity;
import guru.qa.entity.TrackEntity;

public interface Interface {

    CarEntity chooseCar();

    TrackEntity chooseTrack();

    void showResult(CarEntity car, TrackEntity track);
}
