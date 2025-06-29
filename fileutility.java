import java.io.*;
import java.util.Scanner;

public class fileutility {

    static Scanner scanner = new Scanner(System.in);

    public static void createFile(String filename) {
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing.");
            e.printStackTrace();
        }
    }

    public static void appendToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(content);
            writer.close();
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending.");
            e.printStackTrace();
        }
    }

    public static void readFile(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);
            System.out.println("File content:");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nFile Handling Utility Menu:");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Append to File");
            System.out.println("4. Read File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter file name: ");
            String filename = scanner.nextLine();

            switch (choice) {
                case 1:
                    createFile(filename);
                    break;
                case 2:
                    System.out.print("Enter content to write: ");
                    String writeContent = scanner.nextLine();
                    writeToFile(filename, writeContent);
                    break;
                case 3:
                    System.out.print("Enter content to append: ");
                    String appendContent = scanner.nextLine();
                    appendToFile(filename, appendContent);
                    break;
                case 4:
                    readFile(filename);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
