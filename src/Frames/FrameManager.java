package Frames;

import Frames.Setups.Info;
import Frames.Setups.Operator;

import javax.swing.*;
import java.util.*;

public class FrameManager {

    private Map<String, JComponent> infoComponents;
    private Map<String, JComponent> operatorComponents;

    public FrameManager() {
        this.infoComponents = new Info(this).setupFrame();
        this.operatorComponents = new Operator(this).setupFrame();
    }

    public Map<String, JComponent> getInfoComponents() {
        return infoComponents;
    }
    public Map<String, JComponent> getOperatorComponents() {
        return operatorComponents;
    }
}
