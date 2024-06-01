package frontend.modes.random;
import javax.swing.*;
import backend.*;
import java.awt.*;
import java.awt.event.*;

public class CoinPanel extends JPanel {
    private static CoinPanel instance = null;
    Operations operation = Operations.getInstance();
    
    public CoinPanel() {
        super();
        this.setBackground(new Color(0, 0, 0, 0));

        JTextField title = new JTextField(19);
        title.setText("Coin Flipper");
        title.setEditable(false);
        this.add(title);

        JTextField output = new JTextField(19);
        this.add(output);
        output.setEditable(false);

        JButton submit = new JButton("Flip");
        this.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText(operation.flipCoin());
            }
        });
    }

    public static CoinPanel getInstance() {
        if (instance == null) instance = new CoinPanel();
        return instance;
    }
}