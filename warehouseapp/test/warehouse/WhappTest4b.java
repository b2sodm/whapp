/*
 * WhappTest4b
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
public class WhappTest4b 
{
    private final WebDriver driver;
    private final String url;
    
    public WhappTest4b()
    {
        driver = new FirefoxDriver();
        url = "http://localhost:1988/warehouseapp/index.jsp";
    }
    
    public static void main(String[] args)
    {
        
        try {
            /////////////////////////////////////////////////////
            WhappTest4b app = new WhappTest4b();
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
            WebElement btnOrd = app.driver.findElement(By.id("btnOrd"));
            System.out.println("btnOrd: "+ btnOrd.getClass().getName());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            btnOrd.click();
            // Fill in the order form.
            // Goods received.
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            app.OrderFill("otest002id", "ptest002id", "29.99", "150", "0.00", "yes");
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("btnOK: click");
            // Submit the order form.
            // Update goods received.
            app.driver.findElement(By.id("btnOkOrd")).click();
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
    
    public void OrderFill(String oid, String pid, String uprice, String quantity, String discount, String OrderReceived)
    {
        try 
        {
            driver.findElement(By.linkText("Order Details.")).click();
            driver.findElement(By.id("odorder")).sendKeys(oid);
            driver.findElement(By.id("odprod")).sendKeys(pid);
            driver.findElement(By.id("odunitp")).sendKeys(uprice);
            driver.findElement(By.id("odquan")).sendKeys(quantity);
            driver.findElement(By.id("oddisc")).sendKeys(discount);
            Select select = new Select(driver.findElement(By.id("selupDate")));
            select.selectByVisibleText(OrderReceived);
            //Take a snap shot and save it.
            File pic2 = driver.findElement(By.id("ord")).getScreenshotAs(OutputType.FILE);
            BufferedImage bit = ImageIO.read(pic2);
            File fstr = new File("ordtest2bpic.png");
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
