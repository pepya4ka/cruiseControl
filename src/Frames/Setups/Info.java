package Frames.Setups;
import Frames.Enums.InfoComponents;
import Frames.FrameManager;
import Frames.Setups.Base;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Info extends Base {
    private JFrame infoScreen = new JFrame() {};
    private JPanel infoPanel = new JPanel();
    private int posMul = 1;
    private FrameManager manager;

    public Info (FrameManager manager) {
        this.manager = manager;
    }

    @Override
    public Map<String, JComponent> setupFrame() {
        Map<String, JComponent> components = new HashMap<>();
        setupBase(this.posMul, this.infoScreen);
        setupPanel();
        components.put(InfoComponents.SPEED.toString(), setupSpeedComponent());
        components.put(InfoComponents.LIMIT.toString(), setupLimitComponent());
        components.put(InfoComponents.DISTANCE.toString(), setupTrafficLightComponent());
        components.put(InfoComponents.AMOUNT_OF_FUEL.toString(), amountOfFuel());

        infoScreen.setVisible(true);
        return components;
    }

    @Override
    void setupBase(int stepMul, JFrame screen) {
        super.setupBase(stepMul, screen);
        screen.setTitle("Information");
    }

    private void setupPanel() {
        infoPanel.setLayout(new GridLayout(6, 1));
        infoPanel.setName("info_panel");
        infoScreen.add(infoPanel);
    }

    private JTextArea setupSpeedComponent(){
        JLabel label = new JLabel("Current speed: ");
        label.setFont(font);
        JTextArea text = new JTextArea();
        label.setLabelFor(text);
        text.setFont(font);
        text.setText("0");
        infoPanel.add(label);
        infoPanel.add(text);
        return text;
    }

    private JTextArea setupLimitComponent() {
        JLabel label = new JLabel("Speed Limit: ");
        label.setFont(font);
        JTextArea text = new JTextArea("None");
        text.setFont(font);
        label.setLabelFor(text);
        infoPanel.add(label);
        infoPanel.add(text);
        return text;
    }

    private JTextArea setupTrafficLightComponent() {
        JLabel label = new JLabel("Distance:  ");
        label.setFont(font);
        JTextArea text = new JTextArea("None");
        text.setFont(font);
        label.setLabelFor(text);
        infoPanel.add(label);
        infoPanel.add(text);
        return text;
    }

    private JTextArea amountOfFuel() {
        JLabel label = new JLabel("Amount of fuel");
        label.setFont(font);
        JTextArea text = new JTextArea("None");
        text.setFont(font);
        label.setLabelFor(text);
        infoPanel.add(label);
        infoPanel.add(text);
        return text;
    }

    public int getPosMul() {
        return posMul;
    }
}
