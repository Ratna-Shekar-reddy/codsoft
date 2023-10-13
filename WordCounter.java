import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text or provide the path to a file:");

        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("No input provided.");
            return;
        }

        String text;
        if (input.endsWith(".txt")) {
            text = readFile(input);
        } else {
            text = input;
        }

        String[] words = text.split("[\\s.,;]+");
        int wordCount = words.length;

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Total number of words: " + wordCount);

        // Displaying unique word count and word frequencies
        System.out.println("Unique word count: " + wordFrequency.size());
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    private static String readFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return contentBuilder.toString();
    }
}
