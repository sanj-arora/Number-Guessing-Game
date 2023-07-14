import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame implements ActionListener {
    JTextField textField;
    JButton guess;
    JLabel msg;
    int num;
    int totguess;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK);

        textField = new JTextField(15);
        guess = new JButton("GUESS");
        msg = new JLabel("GUESS THE NUMBER BETWEEN 1 TO 100");
        msg.setForeground(Color.WHITE);

        guess.addActionListener(this);

        add(textField);
        add(guess);
        add(msg);

        Random random = new Random();
        num = random.nextInt(100) + 1;
        totguess = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(textField.getText());
            if (guess < 1 || guess > 100) {
                JOptionPane.showMessageDialog(NumberGuessingGameGUI.this,
                        "Please enter a number between 1 and 100.");
                return;
            }
            totguess++;

            if (guess < num) {
                msg.setText("Too low! Try again.");
            } else if (guess > num) {
                msg.setText("Too high! Try again.");
            } else {
                msg.setText("You guessed the number in " + totguess + " tries.");

            }

            textField.setText("");
        } catch (NumberFormatException ex) {

        }
    }

    public static void main(String[] args) {

        NumberGuessingGameGUI game = new NumberGuessingGameGUI();
        game.setVisible(true);
    }
};
