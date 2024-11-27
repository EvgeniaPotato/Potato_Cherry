import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private final String incorrectWord = "неправильно"; // Пример неправильно введенного слова
    private final String correctWord = "правильно"; // Пример правильного слова

    public TextEditor() {
        setTitle("Текстовый редактор");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("Файл");
        
        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.addActionListener(new OpenFileAction());
        fileMenu.add(openItem);
        
        JMenuItem saveItem = new JMenuItem("Сохранить");
        saveItem.addActionListener(new SaveFileAction());
        fileMenu.add(saveItem);
        
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Добавляем слушатель клавиатуры для проверки текста
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    checkForCorrections();
                }
            }
        });
    }

    private void checkForCorrections() {
        new Thread(() -> {
            String text = textArea.getText();
            if (text.contains(incorrectWord)) {
                text = text.replace(incorrectWord, correctWord);
                SwingUtilities.invokeLater(() -> textArea.setText(text));
            }
        }).start();
    }

    private class OpenFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                    textArea.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка при открытии файла: " + ex.getMessage());
                }
            }
        }
    }

    private class SaveFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile))) {
                    bw.write(textArea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка при сохранении файла: " + ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditor editor = new TextEditor();
            editor.setVisible(true);
        });
    }
}
