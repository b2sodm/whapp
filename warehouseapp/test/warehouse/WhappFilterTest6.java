/*
 * WhappFilterTest6.java
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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Brian
 */
public class WhappFilterTest6 
{
    private final WebDriver driver;
    private final String url;
    
    public WhappFilterTest6()
    {
        driver = new FirefoxDriver();
        url = "http://localhost:1988/warehouseapp/index.jsp";
    }
    
    public static void main(String[] args)
    {
        
        try {
            /////////////////////////////////////////////////////
            WhappFilterTest6 app = new WhappFilterTest6();
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
            WebElement btnSupFilter = app.driver.findElement(By.id("btnSupFilter"));
            System.out.println("btnSupFilter: "+ btnSupFilter.getClass().getName());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            btnSupFilter.click();
            // Filter categories.
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            app.SupplierFilter("stest002id");
            app.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("btnOK: click");
            // Submit the filter form.
            app.driver.findElement(By.id("btnOK")).click();
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
    
    public void SupplierFilter(String sup)
    {
        try 
        {
            Select select = new Select(driver.findElement(By.id("result")));
            select.selectByVisibleText(sup);
            //Take a snap shot and save it.
            File pic2 = driver.findElement(By.id("txbFilter")).getScreenshotAs(OutputType.FILE);
            BufferedImage bit = ImageIO.read(pic2);
            File fstr = new File("sfiltest2pic.png");
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
