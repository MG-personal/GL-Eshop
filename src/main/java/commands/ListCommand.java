package commands;

import dataToUse.Product;
import dataToUse.MockProductList;
import formatters.*;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.List;

@Command(name = "list", description = "List products")
public class ListCommand implements Runnable {

    @Option(names = "--format", defaultValue = "table",
            description = "Output format: table or json")
    private String format;

    @Override
    public void run() {
        List<Product> products = MockProductList.getProducts();

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