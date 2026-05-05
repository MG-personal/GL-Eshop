package test;

import dataToUse.Product;
import formatters.JSONFormatter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JSONFormatterTest {
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

        JSONFormatter formatter =
                new JSONFormatter();

        String result =
                formatter.format(fakeList);

        assertTrue(result.contains("MyTestProduct"));

    }

    @Test
    public void shouldContainProductPrice(){


        JSONFormatter formatter =
                new JSONFormatter();

        String result =
                formatter.format(fakeList);

        assertTrue(result.contains("80"));

    }

    @Test
    public void shouldFormatAsJsonWhenRequested(){

        JSONFormatter formatter = new JSONFormatter();
        String result = formatter.format(fakeList);

        assertTrue(result.startsWith("{") || result.startsWith("["));
    }

    @Test
    public void shouldContainJsonStructure(){

        JSONFormatter formatter = new JSONFormatter();
        String result = formatter.format(fakeList);

        assertTrue(result.contains("name"));
        assertTrue(result.contains("price"));
    }



}
