package graphql;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataToUse.Product;

public class ProductQuery implements GraphQLQuery<Product> {

    private final String id;

    public ProductQuery(String id) {
        this.id = id;
    }

    @Override
    public String buildQuery() {
        return """
                query {
                  product(id: "%s") {
                    id
                    name
                    description
                    variants {
                      id
                      name
                      price
                    }
                  }
                }
                """.formatted(id);
    }

    @Override
    public Product parseResponse(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode productNode = mapper.readTree(json)
                    .path("data")
                    .path("product");

            String name = productNode.path("name").asText();

            int price = 0;

            String description = productNode.path("description").asText();

            JsonNode variants = productNode.path("variants");

            if (variants.isArray() && variants.size() > 0) {
                price = variants.get(0).path("price").asInt();
            }

            return new Product(name, price, description);

        } catch (Exception e) {
            throw new RuntimeException("Could not parse product response", e);
        }
    }
}