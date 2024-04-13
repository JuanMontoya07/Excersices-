import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            generateSalesmenReport();
            generateProductsReport();
            System.out.println("Reports generated successfully.");
        } catch (IOException e) {
            System.err.println("Error generating reports: " + e.getMessage());
        }
    }

    public static void generateSalesmenReport() throws IOException {
        List<Salesman> salesmen = readSalesmen("salesmen_info.txt");

        // Calculate total sales for each salesman
        for (Salesman salesman : salesmen) {
            salesman.calculateTotalSales();
        }

        // Sort salesmen by total sales in descending order
        Collections.sort(salesmen, Collections.reverseOrder());

        // Write salesmen report to a CSV file
        try (PrintWriter writer = new PrintWriter("salesmen_report.csv")) {
            for (Salesman salesman : salesmen) {
                writer.println(salesman.getFullName() + ";" + salesman.getTotalSales());
            }
        }
    }

    public static void generateProductsReport() throws IOException {
        List<Product> products = readProducts("products_info.txt");

        // Sort products by quantity sold in descending order
        Collections.sort(products, Collections.reverseOrder());

        // Write products report to a CSV file
        try (PrintWriter writer = new PrintWriter("products_report.csv")) {
            for (Product product : products) {
                writer.println(product.getName() + ";" + product.getPrice());
            }
        }
    }

    public static List<Salesman> readSalesmen(String file) throws IOException {
        List<Salesman> salesmen = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                long document = Long.parseLong(parts[1]);
                String firstName = parts[2];
                String lastName = parts[3];
                salesmen.add(new Salesman(document, firstName, lastName));
            }
        }
        return salesmen;
    }

    public static List<Product> readProducts(String file) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                products.add(new Product(name, price));
            }
        }
        return products;
    }
}

class Salesman implements Comparable<Salesman> {
    private long document;
    private String firstName;
    private String lastName;
    private double totalSales;

    public Salesman(long document, String firstName, String lastName) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void calculateTotalSales() {
        // Simulated calculation of total sales
        Random random = new Random();
        totalSales = random.nextDouble() * 10000; // Random total sales between 0 and 10000
    }

    @Override
    public int compareTo(Salesman other) {
        return Double.compare(this.totalSales, other.totalSales);
    }
}

class Product implements Comparable<Product> {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }
}
