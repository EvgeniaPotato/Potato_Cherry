import javax.swing.*;
import java.awt.*;

public class LayoutDemo {

    public static void main(String[] args) {
        // Создаем JFrame
        JFrame frame = new JFrame("Demonstration of Layout Managers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Устанавливаем BorderLayout для JFrame
        frame.setLayout(new BorderLayout());

        // Создаем JPanel с FlowLayout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Добавляем кнопки в JPanel
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));

        // Добавляем JPanel в JFrame
        frame.add(panel, BorderLayout.CENTER);

        // Добавляем кнопку в JFrame (BorderLayout.SOUTH)
        frame.add(new JButton("Border Layout Button"), BorderLayout.SOUTH);

        // Отображаем JFrame
        frame.setVisible(true);
    }
}
