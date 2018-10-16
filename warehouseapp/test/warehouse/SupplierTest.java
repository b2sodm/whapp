/*
 * SupplierTest.java
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
public class SupplierTest {
    
    Supplier instance;
    public SupplierTest() {
        instance = new Supplier();
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
     * Test of addSupplier method, of class Supplier.
     */
    @Test
    public void testAddSupplier() {
        System.out.println("addSupplier");
        String id = "stest001id";
        String company = "Stest5co";
        String name = "Stest6na";
        String cTitle = "Mr";
        String cAddress = "Stest12ca";
        String cCity = "Stest12cc";
        String cRegion = "Stest12cr";
        String pCode = "stest12pc";
        String cCountry = "Stest12cc";
        String cPhone = "011-123-1235";
        String cFax = "011-123-1234";
        String homePage = "www.ctest12co.com";
        //Supplier instance = new Supplier();
        String expResult = "FeedBack: \n" +" Done.";
        String result = instance.addSupplier(id, company, name, cTitle, cAddress, cCity, cRegion, pCode, cCountry, cPhone, cFax, homePage);
        assertEquals(expResult, result);
        //
    }

    /**
     * Test of SupplierList method, of class Supplier.
     */
    @Test
    public void testSupplierList() {
        System.out.println("SupplierList");
        //Supplier instance = new Supplier();
        int expResult = 12;
        String[] result = instance.SupplierList();
        int res = result.length;
        assert(expResult == res);
        //
    }
    
}
