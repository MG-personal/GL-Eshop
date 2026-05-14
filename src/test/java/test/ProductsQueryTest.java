package test;

import dataToUse.Product;
import graphql.ProductsQuery;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductsQueryTest {

    @Test
    public void shouldBuildProductsQuery() {

        ProductsQuery query = new ProductsQuery();

        String result = query.buildQuery();

        assertTrue(result.contains("products"));
        assertTrue(result.contains("items"));
        assertTrue(result.contains("name"));
        assertTrue(result.contains("variants"));
        assertTrue(result.contains("price"));
    }

    @Test
    public void shouldParseProductsResponse() {

        String json = """
                {
                  "data": {
                    "products": {
                      "items": [
                        {
                          "id": "1",
                          "name": "Laptop",
                          "variants": [
                            {
                              "price": 129900
                            }
                          ]
                        }
                      ]
                    }
                  }
                }
                """;

        ProductsQuery query = new ProductsQuery();

        List<Product> products =
                query.parseResponse(json);

        assertEquals(1, products.size());
        assertEquals("Laptop",
                products.get(0).getName());

        assertEquals(129900,
                products.get(0).getPrice());
    }
}