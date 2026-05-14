package test;

import dataToUse.Product;
import graphql.ProductQuery;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductQueryTest {

    @Test
    public void shouldBuildProductQuery() {

        ProductQuery query =
                new ProductQuery("2");

        String result = query.buildQuery();

        assertTrue(result.contains("product"));
        assertTrue(result.contains("id: \"2\""));
        assertTrue(result.contains("name"));
        assertTrue(result.contains("price"));
    }

    @Test
    public void shouldParseProductResponse() {

        String json = """
                {
                  "data": {
                    "product": {
                      "id": "2",
                      "name": "Tablet",
                      "variants": [
                        {
                          "price": 32900
                        }
                      ]
                    }
                  }
                }
                """;

        ProductQuery query =
                new ProductQuery("2");

        Product product =
                query.parseResponse(json);

        assertEquals("Tablet",
                product.getName());

        assertEquals(32900,
                product.getPrice());
    }
}