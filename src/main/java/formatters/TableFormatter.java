package formatters;

import dataToUse.Product;
import java.util.List;

public class TableFormatter implements Formatter {

    public String format(List<Product> products) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name | Price\n");
        sb.append("------------\n");

        for (Product p : products) {
            sb.append(p.getName())
                    .append(" | ")
                    .append(p.getPrice())
                    .append("\n");
        }

        return sb.toString();
    }
}
