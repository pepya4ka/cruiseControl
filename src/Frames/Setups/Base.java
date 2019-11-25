package Frames.Setups;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public abstract class Base {
    Font font = new Font("Impact", Font.ITALIC, 32);
    private int width = 600;
    private int height = 500;

    public abstract Map<String, JComponent> setupFrame();

    void setupBase(int stepMul, JFrame screen){
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        screen.setBounds(dimension.width/2 - width/2*stepMul, dimension.height/2 - height/2, width, height);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
