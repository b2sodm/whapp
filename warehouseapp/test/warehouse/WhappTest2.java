/*
 * WhappTest2.java
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
public class WhappTest2 
{
    private final WebDriver driver;
    private final String url;
    
    public WhappTest2()
    {
        driver = new FirefoxDriver();
        url = "http://localhost:1988/warehouseapp/index.jsp";
    }
    
    public static void main(String[] args)
    {
        
        try {
            /////////////////////////////////////////////////////
            WhappTest2 app = new WhappTest2();
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
            WebElement btnSup = app.driver.findElement(By.id("btnSup"));
            System.out.println("btnSup: "+ btnSup.getClass().getName());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            btnSup.click();
            // Fill in the supplier form.
            app.SupplierFill("stest002id", "stest002name", "stest002conn", "stest02cont", "stest02add", "stest02city", "stest02reg", "stest02code", "stest02count", "011-123-5430", "011-123-4323", "www.stest02page.com");
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("btnOK: click");
            // Submit the supplier form.
            app.driver.findElement(By.id("btnOkSup")).click();
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
    
    public void SupplierFill(String id, String name, String contact,String title, String addr, String city, String reg, String code, String count, String phone, String fax, String page)
    {
        try 
        {
            driver.findElement(By.linkText("Suppliers.")).click();
            driver.findElement(By.name("ssupid")).sendKeys(id);
            driver.findElement(By.name("compname")).sendKeys(name);
            driver.findElement(By.name("contname")).sendKeys(contact);
            driver.findElement(By.name("contt")).sendKeys(title);
            driver.findElement(By.name("addr")).sendKeys(addr);
            driver.findElement(By.name("city")).sendKeys(city);
            driver.findElement(By.name("regi")).sendKeys(reg);
            driver.findElement(By.name("postc")).sendKeys(code);
            driver.findElement(By.name("countr")).sendKeys(count);
            driver.findElement(By.name("phon")).sendKeys(phone);
            driver.findElement(By.name("fax")).sendKeys(fax);
            driver.findElement(By.name("homep")).sendKeys(page);
            //Take a snap shot and save it.
            File pic2 = driver.findElement(By.id("sup")).getScreenshotAs(OutputType.FILE);
            BufferedImage bit = ImageIO.read(pic2);
            File fstr = new File("suptest2pic.png");
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
