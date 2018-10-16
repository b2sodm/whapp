/*
 * CategoryTest.java
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
public class CategoryTest {
    
    Category instance;
    public CategoryTest() {
        instance = new Category();
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
     * Test of addCategory method, of class Category.
     */
    @Test
    public void testAddCategory() {
        System.out.println("addCategory");
        String id = "testA001";
        String name = "testA00";
        String des = "testA00";
        String pic = "testA00.png";
        //Category instance = new Category();
        String expResult = "FeedBack: \n" +" Done.";
        String result = instance.addCategory(id, name, des, pic);
        assertEquals(expResult, result);
        //
    }
    
    ///////////////////1//////////////
    
    /**
     * Test of setCategoryId method, of class Category.
     */
    @Test
    public void testSetCategoryId() {
        System.out.println("setCategoryId");
        String catid = "c123id";
        //Category instance = new Category();
        instance.setCategoryId(catid);
        //
    }
    
    /**
     * Test of setCategoryName method, of class Category.
     */
    @Test
    public void testSetCategoryName() {
        System.out.println("setCategoryName");
        String name = "c123n";
        //Category instance = new Category();
        instance.setCategoryName(name);
        //
    }

    /**
     * Test of setDescription method, of class Category.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String des = "c123d";
        //Category instance = new Category();
        instance.setDescription(des);
        //
    }

    /**
     * Test of setPicture method, of class Category.
     */
    @Test
    public void testSetPicture() {
        System.out.println("setPicture");
        String pic = "c123p.png";
        //Category instance = new Category();
        instance.setPicture(pic);
        //
    }
    
    //////////////////2///////
    /*
    /**
     * Test of CategoryList method, of class Category.
     *//*
    @Test
    public void testCategoryList() {
        System.out.println("CategoryList");
        //Category instance = new Category();
        String[] expResult = {"c123id","c123n","c123d ","c123p.png "};
        int el= expResult.length;
        String[] result = instance.CategoryList();
        int rl = result.length;
        assert(el == rl);
        //
    }
    */

    /**
     * Test of getCategoryId method, of class Category.
     *//*
    @Test
    public void testGetCategoryId() {
        System.out.println("getCategoryId");
        //Category instance = new Category();
        String expResult = "c123id";
        String result = instance.getCategoryId();
        assertEquals(expResult, result);
        //
    }
    */

    /**
     * Test of getCategoryName method, of class Category.
     *//*
    @Test
    public void testGetCategoryName() {
        System.out.println("getCategoryName");
        //Category instance = new Category();
        String expResult = "c123n";
        String result = instance.getCategoryName();
        assertEquals(expResult, result);
        //
    }
    */

    /**
     * Test of getDescription method, of class Category.
     *//*
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        //Category instance = new Category();
        String expResult = "c123d";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        //
    }
    */

    /**
     * Test of getPicture method, of class Category.
     *//*
    @Test
    public void testGetPicture() {
        System.out.println("getPicture");
        //Category instance = new Category();
        String expResult = "c123p.png";
        String result = instance.getPicture();
        assertEquals(expResult, result);
        //
    }
    */
    //////////////////////////////////////////////

}
