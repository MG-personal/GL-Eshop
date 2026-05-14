package services;

import dataToUse.Product;
import dataToUse.MockProductList;
import graphql.GraphQLQuery;
import graphql.ProductsQuery;

import java.util.List;

public class VendureClient {

  private final String url;

  public VendureClient(String url) {
    this.url = url;
  }

  public List<Product> getProducts() {
    // return MockProductList.getProducts();    // temporaire
    return execute(new ProductsQuery());
  }

  public <T> T execute(GraphQLQuery<T> query) {
    System.out.println("Connecting to: " + url);

    // envoyer HTTP POST
    // récupérer JSON
    // return query.parseResponse(json);

    String queryString = query.buildQuery();
    System.out.println("Printing query: " + queryString);
    String fakeJson = "{fake json}";
    return query.parseResponse(fakeJson);
  }
}
