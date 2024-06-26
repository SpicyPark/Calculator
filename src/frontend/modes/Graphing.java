package frontend.modes;
import javax.swing.*;
import backend.*;
import frontend.Settings;

import java.awt.*;
import java.awt.event.*;

public class Graphing extends JPanel {
    private static Graphing instance = null;
    Operations operation = Operations.getInstance();
    Detector detector = Detector.getInstance();
    Settings settings = Settings.getInstance();
    private boolean refresh = false;
    private boolean valid = false;
    private String eq;

    public Graphing() {
        super();
        setBackground(Color.WHITE);

        JTextField input = new JTextField(24);
        input.setText("Please input your equation here.");
        add(input);

        JButton submit = new JButton("Submit");
        add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eq = input.getText();
                if (detector.detectPolynomial(eq)) {
                    if (!refresh) operation.clearGrid();
                    valid = true;
                    refresh = true;
                }
                else {
                    input.setText("Invalid or unsupported input");
                    valid = false;
                }
            }
        });

        JButton clear = new JButton("Clear");
        add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                operation.clearGrid();
                refresh = false;
            }   
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (settings.getGridSelect()) operation.drawPlane(g);
        if (settings.getNumberSelect()) operation.drawNumbers(g);
        if (valid) operation.plotLine(eq);
        if (refresh) operation.drawGrid(g);
        g.setColor(Color.BLACK);
        g.drawString(Constants.Version.UID, Constants.Version.VX, Constants.Version.VY);
        repaint();
    }

    public static Graphing getInstance() {
        if (instance == null) instance = new Graphing();
        return instance;
    }
}