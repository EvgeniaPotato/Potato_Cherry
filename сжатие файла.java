import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DeduplicateLines {

    public static void deduplicateAndRestore(String inputFilePath, String outputFilePath) throws IOException {
        Set<String> uniqueLines = new HashSet<>();
        Set<String> duplicateLines = new HashSet<>(); // Для хранения дубликатов

        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        String line;
        int duplicateCount = 0;

        // Читаем файл построчно и проверяем на дубликаты.
        while ((line = reader.readLine()) != null) {
            if (!uniqueLines.add(line)) { // false, если элемент уже существует
                duplicateLines.add(line);
                duplicateCount++;
            }
        }
        reader.close();


        // Запись в файл назначения: уникальные строки + количество дубликатов
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
        for (String uniqueLine : uniqueLines) {
            writer.write(uniqueLine);
            writer.newLine();
        }
        writer.write("Removed duplicates: " + duplicateCount); //Информация о удаленных строках
        writer.close();

        // Восстановление: добавление дубликатов
        restoreDuplicates(outputFilePath,duplicateLines);

    }

    private static void restoreDuplicates(String filePath, Set<String> duplicateLines) throws IOException {
        // Добавляем дубликаты в конец файла.
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        for(String line: duplicateLines){
            writer.newLine();
            writer.write(line);
        }
        writer.close();
    }


    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            deduplicateAndRestore(inputFile, outputFile);
            System.out.println("Deduplication and restoration complete. Check " + outputFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
