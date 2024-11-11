import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class Calculator {
    private JFrame frame;
    private JTextField numberEntry;
    private double fNum;
    private String math;

    public Calculator() {
        frame = new JFrame("Калькулятор");
        frame.setSize(380, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 4));

        numberEntry = new JTextField(20);
        frame.add(numberEntry);

        createButtons();

        frame.setVisible(true);
    }

    private void createButtons() {
        String[][] buttons = {
            {"1", "1"}, {"2", "2"}, {"3", "+"}, 
            {"4", "4"}, {"5", "5"}, {"6", "-"}, 
            {"7", "7"}, {"8", "8"}, {"9", "*"}, 
            {"C", "C"}, {"0", "0"}, {"=", "="}, 
            {"/", "/"}
        };

        for (String[] button : buttons) {
            String text = button[0];
            String number = button[1];

            JButton btn = new JButton(text);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (number.matches("\\d")) {
                        buttonClick(Integer.parseInt(number));
                    } else {
                        switch (text) {
                            case "C":
                                buttonClear();
                                break;
                            case "=":
                                buttonEqual();
                                break;
                            case "+":
                                buttonAdd();
                                break;
                            case "-":
                                buttonSubtract();
                                break;
                            case "*":
                                buttonMultiply();
                                break;
                            case "/":
                                buttonDivide();
                                break;
                        }
                    }
                }
            });
            frame.add(btn);
        }
    }

    private void buttonClick(int number) {
        String current = numberEntry.getText();
        numberEntry.setText(current + number);
    }

    private void buttonClear() {
        numberEntry.setText("");
    }

    private void buttonEqual() {
        try {
            double secondNum = Double.parseDouble(numberEntry.getText());
            double result = 0;

            switch (math) {
                case "addition":
                    result = fNum + secondNum;
                    break;
                case "subtraction":
                    result = fNum - secondNum;
                    break;
                case "multiplication":
                    result = fNum * secondNum;
                    break;
                case "division":
                    result = fNum / secondNum;
                    break;
            }

            numberEntry.setText(String.valueOf(result));
            math = "";
        } catch (Exception e) {
            numberEntry.setText("Ошибка");
        }
    }

    private void buttonAdd() {
        fNum = Double.parseDouble(numberEntry.getText());
        math = "addition";
        numberEntry.setText("");
    }

    private void buttonSubtract() {
        fNum = Double.parseDouble(numberEntry.getText());
        math = "subtraction";
        numberEntry.setText("");
    }

    private void buttonMultiply() {
        fNum = Double.parseDouble(numberEntry.getText());
        math = "multiplication";
        numberEntry.setText("");
    }

    private void buttonDivide() {
        fNum = Double.parseDouble(numberEntry.getText());
        math = "division";
        numberEntry.setText("");
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

