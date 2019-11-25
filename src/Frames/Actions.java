package Frames;

import Entities.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;


public class Actions {
    public static abstract class BaseAction extends AbstractAction {
        protected Car car;

        public void setCar(Car car) {
            this.car = car;
        }

        public Car getCar() {
            return this.car;
        }
    }

    public static class StartAction extends BaseAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!car.isAlive()) {
                car.start();
                JButton button = (JButton) e.getSource();
                button.setText("End!");
            } else {
                car.setParked(true);
                JButton button = (JButton) e.getSource();
                button.getTopLevelAncestor().dispatchEvent(new WindowEvent((Window) button.getTopLevelAncestor(),
                        WindowEvent.WINDOW_CLOSING));
            }
        }
    }

    public static class CruiseAction extends BaseAction {

        @Override
        public void actionPerformed(ActionEvent e) {
//            if (!car.isCruise() || !car.isBrake()) {
//                car.setCruise(true);
//                car.setBrake(false);
//            }
            if (!car.isCruise()) {
                car.setCruise(true);
                car.setBrake(false);
            }
        }

    }

    public static class BrakeAction extends BaseAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!car.isBrake()) {
                car.setCruise(false);
                car.setBrake(true);
            }
        }

    }

    public static class GasAction extends BaseAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (car.isCruise() || car.isBrake()) {
                car.setBrake(false);
                car.setCruise(false);
            }
        }
    }
}
