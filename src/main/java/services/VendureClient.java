package services;

import dataToUse.Product;
import dataToUse.MockProductList;

import java.util.List;

public class VendureClient {

    private final String url;

    public VendureClient(String url) {
        this.url = url;
    }

    public List<Product> getProducts() {

        System.out.println("Connecting to: " + url);

        // temporaire
        return MockProductList.getProducts();
    }
}