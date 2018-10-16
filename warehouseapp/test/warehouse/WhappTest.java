/*
 * WhappTest.java
 */
package warehouse;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.gson.JsonObject;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import javax.imageio.ImageIO;



/**
 *
 * @author Brian
 */
public class WhappTest 
{
    //
    private final WebDriver driver;
    private final String url;
    
    public WhappTest()
    {
        driver = new FirefoxDriver();
        url = "http://localhost:1988/warehouseapp/index.html";
    }
    public static void main(String[] args)
    {
        
        try {
            String proxy = "localhost";
            int port = 2828;
            //String url = "http://localhost:1988/warehouseapp/index.html";
            String geckoDr = "pathto\\geckodriver0230w64\\geckodriver.exe";
            System.out.println(geckoDr);
            JsonObject json = new JsonObject();
            json.addProperty("proxyType", "MANUAL");
            json.addProperty("httpProxy", proxy);
            json.addProperty("httpProxyPort", port);
            json.addProperty("sslProxy", proxy);
            json.addProperty("sslProxyPort", port);
            System.out.println("JSON: "+json.toString());
            /////////////////////////////////////////////////////////
            //System.setProperty("webdriver.gecko.driver", geckoDr);
            //WebDriver driver = new FirefoxDriver();
            /////////////////////////////////////////////////////////
            WhappTest app = new WhappTest();
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
            WebElement btnCat = app.driver.findElement(By.id("btnCat"));
            System.out.println("btnCat: "+ btnCat.getClass().getName());
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            btnCat.click();
            // Fill in the category form.
            app.CategoryFill("ctest006id", "ctestF00", "ctest006des", "ctest006pic.png");
            app.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            System.out.println("btnOK: click");
            // Submit the category form.
            app.driver.findElement(By.id("btnOkCat")).click();
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
    
    public void CategoryFill(String id, String name, String des,String pic)
    {
        try 
        {
            driver.findElement(By.linkText("Categories.")).click();
            driver.findElement(By.id("ccatid")).sendKeys(id);
            driver.findElement(By.name("catname")).sendKeys(name);
            driver.findElement(By.name("descr")).sendKeys(des);
            File pic2 = driver.findElement(By.id("cat")).getScreenshotAs(OutputType.FILE);
            BufferedImage bit = ImageIO.read(pic2);
            File fstr = new File(pic);
            ImageIO.write(bit, "png", fstr);
            driver.findElement(By.name("pict")).sendKeys(fstr.getAbsolutePath());
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
