package frontend.modes.random;
import javax.swing.*;
import backend.*;
import frontend.Settings;

import java.awt.*;
import java.awt.event.*;

public class RandomGenerator extends JPanel {
    private static RandomGenerator instance = null;
    Detector detector = Detector.getInstance();
    Operations operation = Operations.getInstance();
    Settings settings = Settings.getInstance();

    public RandomGenerator() {
        super();
        setBackground(new Color(0, 0, 0, 0));

        JTextField title = new JTextField(19);
        title.setText("Random Number Generator");
        title.setEditable(false);
        add(title);

        JTextField output = new JTextField(19);
        add(output);
        output.setEditable(false);

        JButton inputSubmit = new JButton("Generate");
        add(inputSubmit);
        inputSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (settings.getFalseLimit()) output.setText("Invalid or unsupported input");
                else output.setText("" + operation.generateRandomNumber(settings.getUpperBound()));
            }
        });
    }

    public static RandomGenerator getInstance() {
        if (instance == null) instance = new RandomGenerator();
        return instance;
    }
}