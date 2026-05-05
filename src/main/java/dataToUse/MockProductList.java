package dataToUse;

import java.util.ArrayList;
import java.util.List;

public class MockProductList {

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Computer", 790));
        products.add(new Product("Keyboard", 120));
        return products;
    }
}
