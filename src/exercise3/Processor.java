package exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        File inputFile = new File("src/exercise3/student.txt");

        try (Scanner fileScanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter("src/exercise3/grades_report.txt")) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (line.isEmpty()) continue;

                try (Scanner lineScanner = new Scanner(line)) {

                    if (!lineScanner.hasNext()) {
                        continue;
                    }

                    String name = lineScanner.next();

                    try {

                        String s1 = lineScanner.next();
                        String s2 = lineScanner.next();
                        String s3 = lineScanner.next();

                        int score1 = Integer.parseInt(s1);
                        int score2 = Integer.parseInt(s2);
                        int score3 = Integer.parseInt(s3);

                        double avg = (score1 + score2 + score3) / 3.0;

                        try {
                            if (avg < 60) {
                                throw new LowGradeException("Average below 60");
                            }
                            writer.printf("Student: %s | Average: %.2f%n", name, avg);
                        } catch (LowGradeException e) {
                            writer.printf("Student: %s | Average: %.2f | Warning: LOW GRADE%n", name, avg);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Invalid score data for student line -> " + line);

                    } catch (Exception e) {
                        System.out.println("Warning: Corrupted or incomplete line -> " + line);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: students.txt not found. Make sure it's in the project folder.");
        } finally {
            System.out.println("Processing Complete");
        }
    }
}
