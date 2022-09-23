package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GuiWithList extends Interface{
    private JFrame f;
    private final CarStore carStore;
    private final TrackStore trackStore;

    public GuiWithList(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }
    @Override
    public Car chooseCar() {
        f = new JFrame("Choose car");
        String[] cars = {"Cars: ","Ferrari","Mercedes"};
        JComboBox comboBox = new JComboBox(cars);
        comboBox.setBounds(40,90,85,20);
        f.add(comboBox);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        while (comboBox.getSelectedIndex()==0){
        } // Это ужасная реализация, но я сломал себе голову, как можно сделать по-другому
        f.dispose();
        return carStore.lookup((String)comboBox.getSelectedItem());
    }

    @Override
    public Track chooseTrack() {
        f = new JFrame("Choose track");
        String[] cars = {"Track: ","Spa","Nurburgring"};
        JComboBox comboBox = new JComboBox(cars);
        comboBox.setBounds(40,90,85,20);
        f.add(comboBox);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        while (comboBox.getSelectedIndex()==0){
        } // Это ужасная реализация, но я сломал себе голову, как можно сделать по-другому
        f.dispose();
        return trackStore.lookup((String)comboBox.getSelectedItem());
    }

    @Override
    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Pit-stop needed in " + car.maxLapsForTrack(),
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
