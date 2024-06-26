package backend;
import javax.swing.*;

import frontend.*;
import frontend.modes.*;
import frontend.modes.random.*;

public class UserInterface {
    private static JFrame frame;
    private static JTabbedPane panel;

    public static void initialize() {
        try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");} 
        catch (Exception e) {}

        frame = new JFrame();
        panel = new JTabbedPane();
        
        Home home = Home.getInstance();
        panel.addTab("Home", null, home);
        Settings settings = Settings.getInstance();
        panel.addTab("Settings", null, settings);
        Arithmetic arithmetic = Arithmetic.getInstance();
        panel.addTab("A", null, arithmetic);
        Graphing graphing = Graphing.getInstance();
        panel.addTab("G", null, graphing);
        Conversion conversion = Conversion.getInstance();
        panel.addTab("C", null, conversion);
        // DerivativePanel derivative = DerivativePanel.getInstance();
        // panel.addTab("D", null, derivative);
        Random random = Random.getInstance();
        panel.addTab("R", null, random);
        
        frame.setTitle("Calculator");
        frame.setSize(410,410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void showDev() {
        DevTestbed devTestbed = DevTestbed.getInstance();
        panel.insertTab("Dev", null, devTestbed, null, 2);
    }

    public static void hideDev() {
        panel.remove(2);
    }
}