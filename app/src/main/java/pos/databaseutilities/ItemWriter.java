package pos.databaseutilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ItemWriter {
    private String filepath = "preloaded_items.csv"; // Set the filepath to root "POS" folder

    private String newItem;

    private String formattedNewItem;

    public ItemWriter(String newItem){

        this.newItem = newItem;
        this.formattedNewItem = this.formatItem(newItem);
    }

    public String formatItem(String newItem){
        String[] in= this.newItem.split(",");
        Double in5 = Double.parseDouble(in[4]);
        String formatted = String.format("\"%s\",\"%s\",\"%s\",\"%s\",%,.2f",in[0],in[1],in[2],in[3],in5);

        return formatted;
    }

    public boolean write() {
        try {

            File file = new File(filepath);

            // Check if the file exists
            if (file.exists()) {
                // Check if the new item is already in the file
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.equals(this.formattedNewItem)) {
                        // The item is already in the file, so return false
                        scanner.close();
                        return false;
                    }
                }
                scanner.close();
            }

            // If the file does not exist or the item is not in the file, write the item to the file
            PrintWriter writer = new PrintWriter(new FileWriter(file, true)); // Set "true" to append to the file
            writer.println(this.formattedNewItem); // Write the new item and a newline character
            writer.close(); // Close the writer to save the file
            return true; // Return true to indicate that the write was successful
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace if there is an error
            return false; // Return false to indicate that the write was not successful
        }
    }
}