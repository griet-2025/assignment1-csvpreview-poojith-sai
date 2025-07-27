package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        int previewRows = 5; // Number of rows to preview

        ArrayList<String[]> records = new ArrayList<>();
        String[] headers = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowCount = 0;

            // Read header
            if ((line = br.readLine()) != null) {
                headers = line.split(",");
            }

            // Read records
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
                rowCount++;
            }

            // Output format
            System.out.println("=== Data Preview ===\n");
            System.out.println("Columns:");
            if (headers != null) {
                for (String header : headers) {
                    System.out.print(header.trim() + "\t");
                }
                System.out.println("\nTotal Columns: " + headers.length + "\n");
            }

            System.out.println("First " + previewRows + " Records:\n");
            for (int i = 0; i < Math.min(previewRows, records.size()); i++) {
                String[] record = records.get(i);
                for (String field : record) {
                    System.out.print(field.trim() + "\t");
                }
                System.out.println();
            }

            System.out.println("\nTotal Records (excluding header): " + records.size());
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}
