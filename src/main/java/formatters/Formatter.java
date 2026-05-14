package formatters;

import dataToUse.Product;
import java.util.List;

public interface Formatter {
  String format(List<Product> products);
}
