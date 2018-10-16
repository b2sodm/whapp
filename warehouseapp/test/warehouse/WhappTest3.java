/*
 * WhappTest3.java
 */
package warehouse;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Brian
 */
public class WhappTest3 
{
    private final WebDriver driver;
    private final String url;
    
    public WhappTest3()
    {
        driver = new FirefoxDriver();
        url = "http://localhost:1988/warehouseapp/index.jsp";
    }
    
    public static void main(String[] args)
    {
        
        try {
            /////////////////////////////////////////////////////
            WhappTest3 app = new WhappTest3();
            //Page0
            app.driver.get(app.url);
            //
            System.out.println("Welcome to: "+app.driver.getTitle());
            app.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement admin = app.driver.findElement(By.linkText("Admin."));
            System.out.println("Admin: "+ admin.getText());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            admin.click();
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //Page1
            String url2 = app.driver.getCurrentUrl();
            //
            System.out.println("url2: "+ url2);
            WebElement btnPro = app.driver.findElement(By.id("btnPro"));
            System.out.println("btnPro: "+ btnPro.getClass().getName());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            btnPro.click();
            // Fill in the product form.
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            app.ProductFill("ptest002id", "ptest002name", "stest002id", "ctest006id", "150", "29.99", "60", "100", "50", "false");
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("btnOK: click");
            // Submit the product form.
            app.driver.findElement(By.id("btnOkPro")).click();
            //
            System.out.println("btnOK: OK");
        } 
        catch (Exception ex) 
        {
            System.out.println("///////////Exc: /////////////\n");
            Logger.getLogger(WhappTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\n///////////Exc:///////////// ");
        }
    }
    
    public void ProductFill(String pid, String pname, String supid, String catid, String qpunit, String uprice, String uistock, String uoorder, String rlevel, String disco)
    {
        try 
        {
            driver.findElement(By.linkText("Products.")).click();
            driver.findElement(By.id("proid")).sendKeys(pid);
            driver.findElement(By.id("proname")).sendKeys(pname);
            driver.findElement(By.id("prosupid")).sendKeys(supid);
            driver.findElement(By.id("procatid")).sendKeys(catid);
            driver.findElement(By.id("proquantpu")).sendKeys(qpunit);
            driver.findElement(By.id("prounitp")).sendKeys(uprice);
            driver.findElement(By.id("prounitins")).sendKeys(uistock);
            driver.findElement(By.id("prounitono")).sendKeys(uoorder);
            driver.findElement(By.id("proreorderl")).sendKeys(rlevel);
            driver.findElement(By.id("prodiscon")).sendKeys(disco);
            
            //Take a snap shot and save it.
            File pic2 = driver.findElement(By.id("pro")).getScreenshotAs(OutputType.FILE);
            BufferedImage bit = ImageIO.read(pic2);
            File fstr = new File("protest2pic.png");
            ImageIO.write(bit, "png", fstr);
            //
            System.out.println("\n//////\n"+pic2.length() +" \n//////\n");
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(WhappTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //////done//////////
    
}
