package backend;
import javax.swing.*;

import frontend.*;
import frontend.modes.*;
import frontend.modes.random.*;

public class UserInterface {
    public static void initialize() {
        try {UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");} 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
        
        JFrame frame = new JFrame();
        JTabbedPane panel = new JTabbedPane();
        HomePanel home = new HomePanel();
        panel.addTab("Home", null, home);
        ArithmeticPanel arithmetic = new ArithmeticPanel();
        panel.addTab("A", null, arithmetic);
        GraphingPanel graphing = new GraphingPanel();
        panel.addTab("G", null, graphing);
        ConversionPanel conversion = new ConversionPanel();
        panel.addTab("C", null, conversion);
        DerivativePanel derivative = new DerivativePanel();
        panel.addTab("D", null, derivative);
        TopPanel random = new TopPanel();
        panel.addTab("R", null, random);
        
        frame.setTitle("Calculator");
        frame.setSize(410,410);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);
    }
}