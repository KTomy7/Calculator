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
    JButton sqrtButton;
    JButton squareButton;
    JButton reciprocalButton;
    JButton clearButton;
    JButton deleteButton;

    public Calculator() {
        initGUI();
        addNumbers();
        addOperators();
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

    public void addNumbers() {
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

        numberButtons.get(0).setBounds(10, 405, 155, 50);

        int xOffset = 10;
        for (int i = 1; i < 4; i++) {
            numberButtons.get(i).setBounds(xOffset, 350, 75, 50);
            numberButtons.get(i+3).setBounds(xOffset, 295, 75, 50);
            numberButtons.get(i+6).setBounds(xOffset, 240, 75, 50);
            xOffset += 80;
        }
    }

    public void addOperators() {
        dotButton = new JButton(".");
        dotButton.setFont(new Font("Arial", Font.BOLD, 30));
        dotButton.setBackground(new Color(64,64,64));
        dotButton.setForeground(Color.WHITE);
        dotButton.setBounds(170, 405, 75, 50);
        frame.add(dotButton);

        equalButton = new JButton("=");
        equalButton.setFont(new Font("Arial", Font.BOLD, 25));
        equalButton.setBackground(new Color(255,165,0));
        equalButton.setForeground(Color.WHITE);
        equalButton.setBounds(250, 405, 75, 50);
        frame.add(equalButton);

        plusButton = new JButton("+");
        plusButton.setFont(new Font("Arial", Font.BOLD, 25));
        plusButton.setBackground(new Color(255,165,0));
        plusButton.setForeground(Color.WHITE);
        plusButton.setBounds(250, 350, 75, 50);
        frame.add(plusButton);

        minusButton = new JButton("-");
        minusButton.setFont(new Font("Arial", Font.BOLD, 25));
        minusButton.setBackground(new Color(255,165,0));
        minusButton.setForeground(Color.WHITE);
        minusButton.setBounds(250, 295, 75, 50);
        frame.add(minusButton);

        multiplyButton = new JButton("*");
        multiplyButton.setFont(new Font("Arial", Font.BOLD, 25));
        multiplyButton.setBackground(new Color(255,165,0));
        multiplyButton.setForeground(Color.WHITE);
        multiplyButton.setBounds(250, 240, 75, 50);
        frame.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setFont(new Font("Arial", Font.BOLD, 25));
        divideButton.setBackground(new Color(255,165,0));
        divideButton.setForeground(Color.WHITE);
        divideButton.setBounds(250,185,75,50);
        frame.add(divideButton);

        sqrtButton = new JButton("\u221A");
        sqrtButton.setFont(new Font("Arial", Font.BOLD, 25));
        sqrtButton.setBackground(new Color(255,165,0));
        sqrtButton.setForeground(Color.WHITE);
        sqrtButton.setBounds(170, 185, 75, 50);
        frame.add(sqrtButton);

        squareButton = new JButton("x\u00B2");
        squareButton.setFont(new Font("Arial", Font.BOLD, 25));
        squareButton.setBackground(new Color(255,165,0));
        squareButton.setForeground(Color.WHITE);
        squareButton.setBounds(90, 185, 75, 50);
        frame.add(squareButton);

        reciprocalButton = new JButton("1/x");
        reciprocalButton.setFont(new Font("Arial", Font.BOLD, 25));
        reciprocalButton.setBackground(new Color(255,165,0));
        reciprocalButton.setForeground(Color.WHITE);
        reciprocalButton.setBounds(10, 185, 75, 50);
        frame.add(reciprocalButton);

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.setBackground(new Color(255,165,0));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBounds(170, 130, 75, 50);
        frame.add(clearButton);

        deleteButton = new JButton("DEL");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 20));
        deleteButton.setBackground(new Color(255,165,0));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBounds(250, 130, 75, 50);
        frame.add(deleteButton);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 30));
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBounds(10, 40, 315, 50);
        frame.add(textField);

        label = new JLabel("");
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBounds(230, 0, 85, 50);
        frame.add(label);
    }

}
