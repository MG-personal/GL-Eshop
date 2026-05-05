package test;

import dataToUse.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Product testProduct;

    @Before
    public void createProduct(){
        testProduct = new Product("testedProduct", 90);
    }

    @Test
    public void shouldReturnCorrectName(){
        assertEquals("testedProduct", testProduct.getName());
    }

    @Test
    public void shouldReturnCorrectPrice(){
        assertEquals(90, testProduct.getPrice());
    }




}
