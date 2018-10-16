/*
 * ProductTest.java
 */
package warehouse;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class ProductTest {
    
    Product instance;
    public ProductTest() {
        instance = new Product();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct method, of class Product.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        String id = "ptest12id";
        String name = "ptest12na";
        String supplier = "stest001id";
        String category = "testA001";
        String quantity = "150";
        String price = "24.99";
        String uStock = "50";
        String uOrder = "50";
        String reOlevel = "50";
        String disco = "false";
        String expResult = "FeedBack: \n" +" Done.";
        String result = instance.addProduct(id, name, supplier, category, quantity, price, uStock, uOrder, reOlevel, disco);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ProductList method, of class Product.
     */
    @Test
    public void testProductList_0args() {
        System.out.println("ProductList");
        String[] result = instance.ProductList();
        int rl = result.length;
        assert(rl == 10);
    }

    /**
     * Test of ProductList method, of class Product.
     *///*//
    @Test
    public void testProductList_String() {
        System.out.println("ProductList");
        String q = "sup";
        List expResult = new ArrayList();
        List result = instance.ProductList(q);
        assertEquals(expResult.getClass(), result.getClass());
        
    }
    //*/

    /**
     * Test of ProductList method, of class Product.
     */
    @Test
    public void testProductList_3args() {
        System.out.println("ProductList");
        String filter = "cat";
        String reqId = "testA01";
        String val = "cat2";
        List result = instance.ProductList(filter, reqId, val);
        int rl = result.size();
        assert(rl == 1);
        
    }

    /**
     * Test of updateProduct method, of class Product.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        String expResult = "FeedBack: ";
        String result = instance.updateProduct();
        assertEquals(expResult, result);
    }
    
}
