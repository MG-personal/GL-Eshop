package commands;

import dataToUse.Product;

import formatters.*;

import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import services.VendureClient;

import java.util.List;

@Command(name = "list", description = "List products")
public class ListCommand implements Runnable {

  @Option(names = "--format", defaultValue = "table", description = "Output format: table or json")
  private String format;

  @ParentCommand private MainCommand parent;

  @Override
  public void run() {
    VendureClient client = new VendureClient(parent.getUrl());
    List<Product> products = client.getProducts();

    Formatter formatter;

    if ("json".equals(format)) {
      formatter = new JSONFormatter();
    } else {
      formatter = new TableFormatter();
    }

    String result = formatter.format(products);
    System.out.println(result);
  }
}
