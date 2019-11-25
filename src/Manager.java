import Entities.Car;
import Frames.Enums.InfoComponents;
import Frames.Enums.OperatorComponents;
import Frames.FrameManager;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Manager extends Thread{
    private static volatile Manager instance;
    
    private FrameManager frameManager;
    private Car car;

    private Manager() {
        this.frameManager = new FrameManager();
        this.car = new Car();
        try {
            setActions();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        run();
    }

    public static Manager getInstance() {
        Manager localInstance = instance;
        if (localInstance == null) {
            synchronized (Manager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Manager();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void run() {
        JTextArea speed = (JTextArea) frameManager.getInfoComponents().get(InfoComponents.SPEED.toString());
        JTextArea distance = (JTextArea) frameManager.getInfoComponents().get(InfoComponents.DISTANCE.toString());
        JTextArea amoutnOfFuel = (JTextArea) frameManager.getInfoComponents().get(InfoComponents.AMOUNT_OF_FUEL.toString());
        while (!car.isParked()) {
            speed.setText(String.format("%.2f", car.getSpeed()) + " км/ч");
            distance.setText(String.format("%.2f", car.getDistance()) + " км");
            amoutnOfFuel.setText(String.format("%.2f", car.getAmountOfFuel()) + " л");
        }
    }
    
    private void setActions() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for (OperatorComponents key :
                OperatorComponents.values()) {
            JButton button = (JButton) frameManager.getOperatorComponents().get(key.toString());
            key.getAction().setCar(this.car);
            button.addActionListener(key.getAction());
        }
    }

    public FrameManager getFrameManager() {
        return frameManager;
    }
}
