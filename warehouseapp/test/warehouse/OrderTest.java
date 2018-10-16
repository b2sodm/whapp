/*
 * OrderTest.java
 */
package warehouse;

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
public class OrderTest {
    
    Order instance;
    public OrderTest() {
        instance = new Order();
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
     * Test of addOrder method, of class Order.
     */
    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        String id = "otest001id";
        String product = "ptest12id";
        String uprice = "24.99";
        String quant = "100";
        String disc = "0.00";
        String expResult = "FeedBack: \n" +" Done.\n" +" Done.";
        String result = instance.addOrder(id, product, uprice, quant, disc);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of OrderList method, of class Order.
     */
    @Test
    public void testOrderList() {
        System.out.println("OrderList");
        String[] result = instance.OrderList();
        int n = result.length;
        assert(n == 5);
        
    }

    /**
     * Test of updateOrder method, of class Order.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        String product = "ptest123id";
        String unitp = "24.99";
        String quantityp = "100";
        String id = "otest123id";
        Order instance = new Order();
        String expResult = "FeedBack:  x:50.0 <br>\n" +" Done.";
        String result = instance.updateOrder(product, unitp, quantityp, id);
        assertEquals(expResult.charAt(0), result.charAt(0));
        
    }
    
}
