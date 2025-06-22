import java.util.Scanner;

// Product class representing an item in the e-commerce platform
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

// Search utility class
class Search {
    // Linear search by product name
    public static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary search by product name (array must be sorted by productName)
    public static int binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

public class EcommerceSearchDemo {
    public static void main(String[] args) {
        // Sample products
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Book", "Books"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Shoes", "Footwear")
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        // Linear search demonstration
        int linearIndex = Search.linearSearch(products, searchName);
        System.out.println("\nLinear Search: Searching for '" + searchName + "'");
        if (linearIndex != -1) {
            System.out.println("Found at index: " + linearIndex + " -> " + products[linearIndex]);
        } else {
            System.out.println("Product not found.");
        }

        // Prepare for binary search: sort by productName
        java.util.Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
        int binaryIndex = Search.binarySearch(products, searchName);
        System.out.println("\nBinary Search: Searching for '" + searchName + "' (after sorting)");
        if (binaryIndex != -1) {
            System.out.println("Found at index: " + binaryIndex + " -> " + products[binaryIndex]);
        } else {
            System.out.println("Product not found.");
        }

        // Analysis
        System.out.println("\nAnalysis:");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n) (requires sorted array)");
        System.out.println("For large datasets, binary search is much faster, but requires sorting. For small or unsorted data, linear search is simpler.");
    }
} 