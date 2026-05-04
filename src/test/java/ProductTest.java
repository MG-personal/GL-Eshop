package tests;

import main.dataToUse.Product;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    Product testProduct;

    @Before
    public void createProduct(){
        testProduct = new Product("testedProduct", 90);
    }

    @Test
    public void getterTest(){
        assert true (testProduct.getName().contains("testedProduct"));
    }




}
