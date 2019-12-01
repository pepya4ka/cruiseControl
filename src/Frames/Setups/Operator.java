package Frames.Setups;

import Frames.Actions;
import Frames.Enums.OperatorComponents;
import Frames.FrameManager;
import Frames.Setups.Base;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Operator extends Base {
    private JFrame operatorScreen = new JFrame() {};
    private JPanel operatorPanel = new JPanel();
    private FrameManager manager;
    private int posMul = -1;

    public Operator (FrameManager manager) {
        this.manager = manager;
    }

    @Override
    public Map<String, JComponent> setupFrame() {
        Map<String, JComponent> components = new HashMap<>();
        setupBase(posMul, operatorScreen);
        setupPanel();
        components.put(OperatorComponents.START.toString(), setupStartButton());
        components.put(OperatorComponents.CRUISE.toString(), setupCruiseButton());
        components.put(OperatorComponents.GAS.toString(), setupSpeedUpButton());
        components.put(OperatorComponents.BRAKE.toString(), setupSpeedDownButton());

        operatorScreen.setVisible(true);
        return components;
    }

    @Override
    void setupBase(int stepMul, JFrame screen) {
        super.setupBase(stepMul, screen);
        screen.setTitle("Information");
    }

    private void setupPanel() {
        operatorPanel.setLayout(new GridLayout(2, 2));
        operatorPanel.setName("operator_panel");
        operatorPanel.setBackground(Color.PINK);
        operatorScreen.setTitle("Operator");
        operatorScreen.add(operatorPanel);
    }

    private JButton setupStartButton() {
        JButton button = new JButton("Start!");
        button.setFont(font);
        button.setBackground(Color.PINK);
        operatorPanel.add(button);

        return button;
    }

    private JButton setupCruiseButton() {
        JButton button = new JButton("Cruise");
        button.setFont(font);
        button.setBackground(Color.PINK);
        operatorPanel.add(button);

        return button;
    }

    private JButton setupSpeedUpButton() {
        JButton button = new JButton("Gas");
        button.setFont(font);
        button.setBackground(Color.PINK);
        operatorPanel.add(button);

        return button;
    }

    private JButton setupSpeedDownButton() {
        JButton button = new JButton("Brake");
        button.setFont(font);
        button.setBackground(Color.PINK);
        operatorPanel.add(button);

        return button;
    }

    public int getPosMul() {
        return posMul;
    }
}
