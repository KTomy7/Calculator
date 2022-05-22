import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator implements ActionListener {
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

    // Variables:
    char var;
    double number, answer;

    // Constructor
    public Calculator() {
        initGUI();
        addNumbers();
        addOperators();
        addActionListener();
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

    public void addActionListener() {
        // Add ActionListener to number buttons:
        for (JButton button : numberButtons) {
            button.addActionListener(this);
        }

        // Add ActionListener to operator buttons:
        dotButton.addActionListener(this);
        equalButton.addActionListener(this);
        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        sqrtButton.addActionListener(this);
        squareButton.addActionListener(this);
        reciprocalButton.addActionListener(this);
        clearButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            label.setText("");
            textField.setText("");
        }
        else if (e.getSource() == deleteButton) {
            int nb = textField.getText().length() - 1;

            if (textField.getText().length() > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(nb);
                textField.setText(back.toString());
            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        }
        else if (e.getSource() == numberButtons.get(0)) {
            if (textField.getText().equals("0")) {
                return;
            }
            else
                textField.setText(textField.getText() + "0");
        }
        else if (e.getSource() == numberButtons.get(1)) {
            textField.setText(textField.getText() + "1");
        }
        else if (e.getSource() == numberButtons.get(2)) {
            textField.setText(textField.getText() + "2");
        }
        else if (e.getSource() == numberButtons.get(3)) {
            textField.setText(textField.getText() + "3");
        }
        else if (e.getSource() == numberButtons.get(4)) {
            textField.setText(textField.getText() + "4");
        }
        else if (e.getSource() == numberButtons.get(5)) {
            textField.setText(textField.getText() + "5");
        }
        else if (e.getSource() == numberButtons.get(6)) {
            textField.setText(textField.getText() + "6");
        }
        else if (e.getSource() == numberButtons.get(7)) {
            textField.setText(textField.getText() + "7");
        }
        else if (e.getSource() == numberButtons.get(8)) {
            textField.setText(textField.getText() + "8");
        }
        else if (e.getSource() == numberButtons.get(9)) {
            textField.setText(textField.getText() + "9");
        }
        else if (e.getSource() == dotButton) {
            if (textField.getText().contains(".")) {
                return;
            }
            else
                textField.setText(textField.getText() + ".");
        }
        else if (e.getSource() == plusButton) {
            String str = textField.getText();
            number = Double.parseDouble(str);
            textField.setText("");
            label.setText(str + "+");
            var = '+';
        }
        else if (e.getSource() == minusButton) {
            String str = textField.getText();
            number = Double.parseDouble(str);
            textField.setText("");
            label.setText(str + "-");
            var = '-';
        }
        else if (e.getSource() == multiplyButton) {
            String str = textField.getText();
            number = Double.parseDouble(str);
            textField.setText("");
            label.setText(str + "*");
            var = '*';
        }
        else if (e.getSource() == divideButton) {
            String str = textField.getText();
            number = Double.parseDouble(str);
            textField.setText("");
            label.setText(str + "/");
            var = '/';
        }
        else if (e.getSource() == equalButton) {
            switch (var) {
                case '+' -> {
                    answer = number + Double.parseDouble(textField.getText());
                    checkResult(answer);
                    label.setText("");
                }
                case '-' -> {
                    answer = number - Double.parseDouble(textField.getText());
                    checkResult(answer);
                    label.setText("");
                }
                case '*' -> {
                    answer = number * Double.parseDouble(textField.getText());
                    checkResult(answer);
                    label.setText("");
                }
                case '/' -> {
                    answer = number / Double.parseDouble(textField.getText());
                    checkResult(answer);
                    label.setText("");
                }
            }
        }

        else if (e.getSource() == sqrtButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.sqrt(number);
            checkResult(answer);
        }
        else if (e.getSource() == squareButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.pow(number, 2);
            checkResult(answer);
        }
        else if (e.getSource() == reciprocalButton) {
            number = Double.parseDouble(textField.getText());
            answer = 1/ number;
            checkResult(answer);
        }
    }

    public void checkResult(double result) {
        if (Double.toString(result).endsWith(".0")) {
            textField.setText(Double.toString(result).replace(".0", ""));
        }
        else {
            textField.setText(Double.toString(result));
        }
    }
}
