package guru.qa;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;
import guru.qa.service.CuiInterface;
import guru.qa.service.GuiInterface;
import guru.qa.service.GuiWithList;
import guru.qa.service.Interface;

import javax.swing.*;

public class Application {

    private Interface userInterface;

    public Application() {
        String[] choices = {"GUI", "CUI", "Choice-List"};
        String desiredInterface = (String) JOptionPane.showInputDialog(null,
                "Choose Interface",
                "Choice",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]);
        switch (desiredInterface) {
            case "GUI":
                this.userInterface = new GuiInterface(
                        new CarStore(),
                        new TrackStore());
                break;
            case "CUI":
                this.userInterface = new CuiInterface(
                        new CarStore(),
                        new TrackStore());
                break;
            case "Choice-List":
                userInterface = new GuiWithList(
                        new CarStore(),
                        new TrackStore());
                break;
        }
    }

    void run() {
        Car car = userInterface.chooseCar();
        Track track = userInterface.chooseTrack();
        userInterface.showResult(car, track);
    }
}
