package graphql;

import dataToUse.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsQuery implements GraphQLQuery<List<Product>> {
  @Override
  public String buildQuery() {
    return """
                query {
                  products {
                    items {
                      id
                      name
                      variants {
                        price
                      }
                    }
                  }
                }
                """;
  }

  @Override
  public List<Product> parseResponse(String json) {
    // temporaire pour tester le flow
    List<Product> products = new ArrayList<>();
    products.add(new Product("GraphQLProduct", 100));
    return products;
  }
}
