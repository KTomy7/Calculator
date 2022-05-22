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

    // Standard Operators:
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
    JRadioButton standardRButton;
    JRadioButton scientificRButton;

    // Scientific Operators:
    JButton sinButton;
    JButton cosButton;
    JButton tanButton;
    JButton cotButton;
    JButton lnButton;
    JButton logButton;
    JButton expButton;
    JButton xyButton;
    JButton piButton;
    JButton eButton;

    // Variables:
    char var;
    double number, answer;

    // Constructor
    public Calculator() {
        initGUI();
        addNumbers();
        addStandardOperators();
        addScientificOperators();
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

    public void addStandardOperators() {
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

        standardRButton = new JRadioButton("Standard");
        standardRButton.setBounds(10, 130, 120, 25);
        standardRButton.setFont(new Font("Arial", Font.BOLD, 15));
        standardRButton.setBackground(Color.BLACK);
        standardRButton.setForeground(Color.WHITE);
        standardRButton.setSelected(true);
        standardRButton.setEnabled(false);
        frame.add(standardRButton);

        scientificRButton = new JRadioButton("Scientific");
        scientificRButton.setBounds(10, 155, 120, 25);
        scientificRButton.setFont(new Font("Arial", Font.BOLD, 15));
        scientificRButton.setBackground(Color.BLACK);
        scientificRButton.setForeground(Color.WHITE);
        scientificRButton.setSelected(false);
        scientificRButton.setEnabled(true);
        frame.add(scientificRButton);
    }

    private void addScientificOperators() {
        sinButton = new JButton("sin");
        sinButton.setBounds(330, 350, 75, 50);
        sinButton.setFont(new Font("Arial", Font.BOLD, 25));
        sinButton.setBackground(new Color(255,165,0));
        sinButton.setForeground(Color.WHITE);
        sinButton.setVisible(false);
        frame.add(sinButton);

        cosButton = new JButton("cos");
        cosButton.setBounds(330, 295, 75, 50);
        cosButton.setFont(new Font("Arial", Font.BOLD, 23));
        cosButton.setBackground(new Color(255,165,0));
        cosButton.setForeground(Color.WHITE);
        cosButton.setVisible(false);
        frame.add(cosButton);

        tanButton = new JButton("tan");
        tanButton.setBounds(330, 240, 75, 50);
        tanButton.setFont(new Font("Arial", Font.BOLD, 25));
        tanButton.setBackground(new Color(255,165,0));
        tanButton.setForeground(Color.WHITE);
        tanButton.setVisible(false);
        frame.add(tanButton);

        cotButton = new JButton("cot");
        cotButton.setBounds(330, 185, 75, 50);
        cotButton.setFont(new Font("Arial", Font.BOLD, 25));
        cotButton.setBackground(new Color(255,165,0));
        cotButton.setForeground(Color.WHITE);
        cotButton.setVisible(false);
        frame.add(cotButton);

        lnButton = new JButton("ln");
        lnButton.setBounds(410, 350, 75, 50);
        lnButton.setFont(new Font("Arial", Font.BOLD, 25));
        lnButton.setBackground(new Color(255,165,0));
        lnButton.setForeground(Color.WHITE);
        lnButton.setVisible(false);
        frame.add(lnButton);

        logButton = new JButton("log");
        logButton.setBounds(410, 295, 75, 50);
        logButton.setFont(new Font("Arial", Font.BOLD, 25));
        logButton.setBackground(new Color(255,165,0));
        logButton.setForeground(Color.WHITE);
        logButton.setVisible(false);
        frame.add(logButton);

        expButton = new JButton("exp");
        expButton.setBounds(410, 240, 75, 50);
        expButton.setFont(new Font("Arial", Font.BOLD, 20));
        expButton.setBackground(new Color(255,165,0));
        expButton.setForeground(Color.WHITE);
        expButton.setVisible(false);
        frame.add(expButton);

        xyButton = new JButton("x^y");
        xyButton.setBounds(410, 185, 75, 50);
        xyButton.setFont(new Font("Arial", Font.BOLD, 20));
        xyButton.setBackground(new Color(255,165,0));
        xyButton.setForeground(Color.WHITE);
        xyButton.setVisible(false);
        frame.add(xyButton);

        piButton = new JButton("\u03C0");
        piButton.setBounds(330, 130, 75, 50);
        piButton.setFont(new Font("Arial", Font.BOLD, 30));
        piButton.setBackground(new Color(255,165,0));
        piButton.setForeground(Color.WHITE);
        piButton.setVisible(false);
        frame.add(piButton);

        eButton = new JButton("e");
        eButton.setBounds(410, 130, 75, 50);
        eButton.setFont(new Font("Arial", Font.BOLD, 30));
        eButton.setBackground(new Color(255,165,0));
        eButton.setForeground(Color.WHITE);
        eButton.setVisible(false);
        frame.add(eButton);
    }

    public void standardMode() {
        standardRButton.setEnabled(false);
        scientificRButton.setEnabled(true);
        scientificRButton.setSelected(false);

        frame.setSize(350, 505);
        textField.setSize(315, 50);
        label.setSize(85, 50);
        equalButton.setSize(75, 50);

        sinButton.setVisible(false);
        cosButton.setVisible(false);
        tanButton.setVisible(false);
        cotButton.setVisible(false);
        lnButton.setVisible(false);
        logButton.setVisible(false);
        expButton.setVisible(false);
        xyButton.setVisible(false);
        piButton.setVisible(false);
        eButton.setVisible(false);
    }

    public void scientificMode() {
        scientificRButton.setEnabled(false);
        standardRButton.setEnabled(true);
        standardRButton.setSelected(false);

        frame.setSize(510, 505);
        textField.setSize(475, 50);
        label.setSize(245, 50);
        equalButton.setSize(235, 50);

        sinButton.setVisible(true);
        cosButton.setVisible(true);
        tanButton.setVisible(true);
        cotButton.setVisible(true);
        lnButton.setVisible(true);
        logButton.setVisible(true);
        expButton.setVisible(true);
        xyButton.setVisible(true);
        piButton.setVisible(true);
        eButton.setVisible(true);
    }

    public void addActionListener() {
        // Add ActionListener to number buttons:
        for (JButton button : numberButtons) {
            button.addActionListener(this);
        }
        piButton.addActionListener(this);
        eButton.addActionListener(this);

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
        standardRButton.addActionListener(this);
        scientificRButton.addActionListener(this);
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);
        cotButton.addActionListener(this);
        lnButton.addActionListener(this);
        logButton.addActionListener(this);
        expButton.addActionListener(this);
        xyButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == standardRButton) {
            standardMode();
        }
        else if (e.getSource() == scientificRButton) {
            scientificMode();
        }
        else if (e.getSource() == clearButton) {
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
        else if (e.getSource() == piButton) {
            textField.setText(textField.getText() + Math.PI);
        }
        else if (e.getSource() == eButton) {
            textField.setText(textField.getText() + Math.E);
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
        else if (e.getSource() == xyButton) {
            String str = textField.getText();
            number = Double.parseDouble(str);
            textField.setText("");
            label.setText(str + "^");
            var = '^';
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
                case '^' -> {
                    answer = Math.pow(number, Double.parseDouble(textField.getText()));
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
        else if (e.getSource() == sinButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.sin(number);
            checkResult(answer);
        }
        else if (e.getSource() == cosButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.cos(number);
            checkResult(answer);
        }
        else if (e.getSource() == tanButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.tan(number);
            checkResult(answer);
        }
        else if (e.getSource() == cotButton) {
            number = Double.parseDouble(textField.getText());
            answer = 1/Math.tan(number);
            checkResult(answer);
        }
        else if (e.getSource() == lnButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.log(number);
            checkResult(answer);
        }
        else if (e.getSource() == logButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.log10(number);
            checkResult(answer);
        }
        else if (e.getSource() == expButton) {
            number = Double.parseDouble(textField.getText());
            answer = Math.exp(number);
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
