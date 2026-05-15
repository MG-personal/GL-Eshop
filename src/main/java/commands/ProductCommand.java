package commands;

import dataToUse.Product;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;
import services.VendureClient;

@Command(name = "product", description = "Show product details by id")
public class ProductCommand implements Runnable {

  @Option(names = "--id", required = true, description = "Product id")
  private String id;

  @ParentCommand private MainCommand parent;

  @Override
  public void run() {
    VendureClient client = new VendureClient(parent.getUrl());

    Product product = client.getProductById(id);

    System.out.println("Name: " + product.getName());
    System.out.println("Price: " + product.getPrice());
    System.out.println();
    System.out.println("Description:");
    System.out.println(product.getDescription());
  }
}
