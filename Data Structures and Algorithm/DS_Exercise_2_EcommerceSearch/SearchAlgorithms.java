import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    public static Product linearSearch(Product[] products, String productId) {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productId) {
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted, Comparator.comparing(Product::getProductId));

        int left = 0;
        int right = sorted.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sorted[mid].getProductId().compareTo(productId);
            if (cmp == 0) {
                return sorted[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Keyboard", "Electronics"),
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Mouse", "Electronics")
        };

        Product found = linearSearch(products, "P002");
        System.out.println("Linear Search: " + (found != null ? found : "Not found"));

        found = binarySearch(products, "P001");
        System.out.println("Binary Search: " + (found != null ? found : "Not found"));
    }
}
