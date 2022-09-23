package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;
import guru.qa.service.CuiInterface;
import guru.qa.service.GuiInterface;
import guru.qa.service.GuiWithList;
import guru.qa.service.Interface;

import java.util.Scanner;

public class Application {

    private final Interface userInterface;

    public Application() {
        System.out.println("Write number of Interface:\n1. GUI\n2. CUI\n3. Choice-List");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        switch (k) {
            case 1:
                this.userInterface = new GuiInterface(
                        new CarStore(),
                        new TrackStore());
                break;
            case 2:
                this.userInterface = new CuiInterface(
                        new CarStore(),
                        new TrackStore());
                break;
            case 3:
                userInterface = new GuiWithList(
                        new CarStore(),
                        new TrackStore());
                break;
            default:
                throw new IllegalArgumentException("There is no such interface!");
        }
    }

    void run() {
        Car car = userInterface.chooseCar();
        Track track = userInterface.chooseTrack();
        userInterface.showResult(car, track);
    }
}
