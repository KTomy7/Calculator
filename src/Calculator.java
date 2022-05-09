import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calculator {
    JFrame frame;
    JLabel label;
    JTextField textField;

    // Numbers
    ArrayList<JButton> numberButtons;

    // Operators
    JButton dotButton;
    JButton plusButton;
    JButton minusButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton equalButton;
    JButton squareButton;
    JButton reciprocalButton;
    JButton clearButton;
    JButton deleteButton;

    public Calculator() {
        initGUI();
        addNumberButtons();
    }

    public void initGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(350, 500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addNumberButtons() {
        numberButtons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberButtons.add(new JButton(Integer.toString(i)));
        }

        for (JButton button : numberButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 30));
            button.setBackground(new Color(64,64,64));
            button.setForeground(Color.WHITE);
            frame.add(button);
        }
        for (JButton button : numberButtons) {
            if (button.getText().equals("0")) {
                button.setBounds(10, 405, 155, 50);
            }
            else if (button.getText().equals("1")) {
                button.setBounds(10, 350, 75, 50);
            }
            else if (button.getText().equals("2")) {
                button.setBounds(90, 350, 75, 50);
            }
            else if (button.getText().equals("3")) {
                button.setBounds(170, 350, 75, 50);
            }
            else if (button.getText().equals("4")) {
                button.setBounds(10, 295, 75, 50);
            }
            else if (button.getText().equals("5")) {
                button.setBounds(90, 295, 75, 50);
            }
            else if (button.getText().equals("6")) {
                button.setBounds(170, 295, 75, 50);
            }
            else if (button.getText().equals("7")) {
                button.setBounds(10, 240, 75, 50);
            }
            else if (button.getText().equals("8")) {
                button.setBounds(90, 240, 75, 50);
            }
            else if (button.getText().equals("9")) {
                button.setBounds(170, 240, 75, 50);
            }
        }
    }
}
