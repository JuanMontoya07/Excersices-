import java.io.*;
import java.util.*;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        try {
            createSalesManInfoFile(10); // Creates a File with the data of 10 Salesman (It can be higher adjusting the number of the parenthesis)
            createProductsFile(20); // Same logic as the Sales man info method 
            System.out.println("The files has been created successfully."); // Prints this message if the files could be created.
        } catch (IOException e) {
            System.err.println("An Eroor has been found while creating the file: " + e.getMessage());
            // In case the program gets an error this message notify the user and specify the error type.
        }
    }

    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
    	//Initiates the declaration of the createSalesManInfoFile Method
        List<String> names = Arrays.asList("Juan", "Pedro", "Maria", "Ana", "Luis", "Carlos");
        List<String> lastNames = Arrays.asList("Garcia", "Lopez", "Martinez", "Gonzalez", "Rodriguez");
        // We used arrays to assign realistic names to our Salesman
        try (PrintWriter writer = new PrintWriter("salesmen_info.txt")) {
            Random random = new Random();
            for (int i = 0; i < salesmanCount; i++) {
                long document = 10000000 + random.nextInt(900000000); // Creates a document number more realistic to a Colombia ID.
                String name = names.get(random.nextInt(names.size())); // Selects a name from the names array
                String lastname = lastNames.get(random.nextInt(lastNames.size())); // Selects a name from the names array
                writer.println("CC;" + document + ";" + name + ";" + lastname);
            }
        }
    }

    public static void createProductsFile(int productsCount) throws IOException {
        try (PrintWriter writer = new PrintWriter("products_info.txt")) {
            Random random = new Random();
            for (int i = 0; i < productsCount; i++) {
            	long id = 1000 + random.nextInt(9000); // Creates an ID for the products 
                writer.println("IDProduct" + id + ";" + "Product" + (i + 1) + ";" + (random.nextInt(10000) + 1));
            }
        }
    }
}
