package tests;

import main.dataToUse.Product;
import main.formatters.JSONFormatter;
import main.formatters.TableFormatter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TableFormatterTest {
    private Product fakeProduct;
    private List<Product> fakeList;

    @Before
    public void createFakeList(){
        fakeProduct = new Product("MyTestProduct", 80);
        fakeList = new ArrayList<>();
        fakeList.add(this.fakeProduct);
    }


    @Test
    public void shouldContainProductName(){


        TableFormatter formatter =
                new TableFormatter();

        String result =
                formatter.format(fakeList);

        assertTrue(result.contains("MyTestProduct"));

    }

    @Test
    public void shouldContainProductPrice(){


        TableFormatter formatter =
                new TableFormatter();

        String result =
                formatter.format(fakeList);

        assertTrue(result.contains("80"));

    }


}
