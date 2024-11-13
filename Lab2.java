import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try {
            // Open the input file with Scanner
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);

            // Open output file for writing
            PrintWriter writer = new PrintWriter(outputFile);

            // Read the entire line from the input file
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                
                // Split the line by commas
                String[] numbers = line.split(",");

                // Process each number in the array
                for (String numStr : numbers) {
                    // Trim any extra whitespace and parse each split part to an integer
                    numStr = numStr.trim();
                    if (!numStr.isEmpty()) { // Check to avoid empty strings
                        int highest = Integer.parseInt(numStr);

                        // Calculate the sum of the series from 1 to `highest`
                        int seriesSum = (highest * (highest + 1)) / 2;

                        // Write the series sum to output file
                        writer.println("Sum of series 1 to " + highest + ": " + seriesSum);
                    }
                }
            }

            // Close the resources
            scanner.close();
            writer.close();

            System.out.println("Series sums have been written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in input file - " + e.getMessage());
        }
    }
}
