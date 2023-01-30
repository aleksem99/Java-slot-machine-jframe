import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SlotMachine extends JFrame implements ActionListener {
    private JLabel balanceLabel, betLabel, resultLabel;
    private JTextField balanceField, betField;
    private JButton spinButton;
    private String[] fruits = {"Cherry", "Lemon", "Plum", "Bell", "Bar", "Seven"};

    public SlotMachine() {
        // Set the layout manager
        setLayout(new GridLayout(4, 2));

        // Balance label and text field
        balanceLabel = new JLabel("Balance:", SwingConstants.RIGHT);
        balanceField = new JTextField("999", 5);
        balanceField.setEditable(false);
        add(balanceLabel);
        add(balanceField);

        // Bet label and text field
        betLabel = new JLabel("Bet:", SwingConstants.RIGHT);
        betField = new JTextField("0", 5);
        add(betLabel);
        add(betField);

        // Spin button
        spinButton = new JButton("Spin");
        spinButton.addActionListener(this);
        add(spinButton);

        // Result label
        resultLabel = new JLabel("Welcome to the Fruit Slot Machine!", SwingConstants.CENTER);
        add(resultLabel);

        // Set the window properties
        setTitle("Fruit Slot Machine");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        int balance = Integer.parseInt(balanceField.getText());
        int bet = Integer.parseInt(betField.getText());
        if (bet > balance) {
            resultLabel.setText("Error: Bet exceeds balance.");
        } else if (bet <= 0) {
            resultLabel.setText("Error: Bet must be positive.");
        } else {
            balance -= bet;
            balanceField.setText(Integer.toString(balance));
            int r1 = (int) (Math.random() * 6);
            int r2 = (int) (Math.random() * 6);
            int r3 = (int) (Math.random() * 6);
            String result = fruits[r1] + " - " + fruits[r2] + " - " + fruits[r3];
            if (r1 == r2 && r2 == r3) {
                balance += bet * 3;
                resultLabel.setText("You win! " + result);
            } else {
                resultLabel.setText("You lose! " + result);
            }
        }
    }

    public static void main(String[] args) {
        SlotMachine window = new SlotMachine();
        window.setVisible(true);
    }
}
