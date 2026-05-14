package formatters;

import dataToUse.Product;
import java.util.List;

public class JSONFormatter implements Formatter {

  public String format(List<Product> products) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for (int i = 0; i < products.size(); i++) {
      Product p = products.get(i);
      sb.append("{");
      sb.append("\"name\":\"").append(p.getName()).append("\",");
      sb.append("\"price\":").append(p.getPrice());
      sb.append("}");

      if (i < products.size() - 1) {
        sb.append(",");
      }
    }

    sb.append("]");
    return sb.toString();
  }
}
