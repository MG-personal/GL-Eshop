package graphql;

import dataToUse.Product;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductsQuery implements GraphQLQuery<List<Product>> {
  @Override
  public String buildQuery() {
    return """
                query {
                  products {
                    items {
                      id
                      name
                      description
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
    List<Product> products = new ArrayList<>();

    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode items = mapper.readTree(json).path("data").path("products").path("items");

      for (JsonNode item : items) {
        String name = item.path("name").asText();

        int price = 0;

        String description = item.path("description").asText();

        JsonNode variants = item.path("variants");
        if (variants.isArray() && variants.size() > 0) {
          price = variants.get(0).path("price").asInt();
        }

        products.add(new Product(name, price, description));
      }

      return products;

    } catch (Exception e) {
      throw new RuntimeException("Could not parse Vendure response", e);
    }
  }
}
