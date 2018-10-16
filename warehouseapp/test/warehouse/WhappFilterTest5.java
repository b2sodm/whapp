/*
 * WhappFilterTest5.java
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
public class WhappFilterTest5 
{
    private final WebDriver driver;
    private final String url;
    
    public WhappFilterTest5()
    {
        driver = new FirefoxDriver();
        url = "http://localhost:1988/warehouseapp/index.jsp";
    }
    
    public static void main(String[] args)
    {
        
        try {
            /////////////////////////////////////////////////////
            WhappFilterTest5 app = new WhappFilterTest5();
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
            WebElement btnCatFilter = app.driver.findElement(By.id("btnCatFilter"));
            System.out.println("btnCatFilter: "+ btnCatFilter.getClass().getName());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            btnCatFilter.click();
            // Filter categories.
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            app.CategoryFilter("ctest006id");
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
    
    public void CategoryFilter(String cat)
    {
        try 
        {
            Select select = new Select(driver.findElement(By.id("result")));
            select.selectByVisibleText(cat);
            //
            //Take a snap shot and save it.
            File pic2 = driver.findElement(By.id("txbFilter")).getScreenshotAs(OutputType.FILE);
            BufferedImage bit = ImageIO.read(pic2);
            File fstr = new File("cfiltest2pic.png");
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
