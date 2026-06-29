public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Smartphone", "Electronics"),
                new Product(103, "Headphones", "Electronics"),
                new Product(104, "Monitor", "Electronics")
        };

        Product result1 = SearchEngine.linearSearch(products, 102);
        if (result1 != null) {
            System.out.println("Linear Search Found: " + result1.productName);
        } else {
            System.out.println("Linear Search: Product not found");
        }

        Product result2 = SearchEngine.binarySearch(products, 104);
        if (result2 != null) {
            System.out.println("Binary Search Found: " + result2.productName);
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}