package services;

import dataToUse.Product;

import graphql.GraphQLQuery;
import graphql.ProductQuery;
import graphql.ProductsQuery;

import java.util.List;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VendureClient {

  private final String url;

  public VendureClient(String url) {
    this.url = url;
  }

  public List<Product> getProducts() {
    return execute(new ProductsQuery());
  }

  public Product getProductById(String id) {
    return execute(new ProductQuery(id));
  }

  public <T> T execute(GraphQLQuery<T> query) {

    try {

      String queryString = query.buildQuery();

      String payload =
          "{\"query\":\"" + queryString.replace("\"", "\\\"").replace("\n", " ") + "\"}";

      HttpClient client = HttpClient.newHttpClient();

      HttpRequest request =
          HttpRequest.newBuilder()
              .uri(URI.create(url))
              .header("Content-Type", "application/json")
              .POST(HttpRequest.BodyPublishers.ofString(payload))
              .build();

      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      String json = response.body();

      //System.out.println(json);

      return query.parseResponse(json);

    } catch (Exception e) {
      throw new RuntimeException(
          "Could not connect to Vendure at " + url + ". Make sure the Vendure server is running.",
          e);
    }
  }
}
