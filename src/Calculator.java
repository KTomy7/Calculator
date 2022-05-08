import javax.swing.*;
import java.awt.*;

public class Calculator {
    JFrame frame;
    JLabel label;
    JTextField textField;

    // Numbers
    JButton zeroButton;
    JButton oneButton;
    JButton twoButton;
    JButton threeButton;
    JButton fourButton;
    JButton fiveButton;
    JButton sixButton;
    JButton sevenButton;
    JButton eightButton;
    JButton nineButton;

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

}
