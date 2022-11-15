import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
//Declaring static variable of static type to store browser name
    static String browser ="Edge";
    //declaring static variable of string type to store target url
            static String baseurl="https://demo.nopcommerce.com/login?returnUrl=%2F";
           //initialising static variable of webdriver type to store web driver value

            static WebDriver driverMulti;
//Main method
    public static void main(String[] args) {
        //using condition statment to set up required browser
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driverMulti = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driverMulti = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driverMulti =new FirefoxDriver();

        }
        else {
            System.out.println("Invalic browser");
        }
        //opening selected browser inside try and catch block to handle exception
        try{
            driverMulti.get(baseurl);
        }catch (Exception e){
            System.out.println("End of the program due to invalid entry (" + e.getMessage()+")");
        System.exit(0);

        }
        //Maximising browser window upon opening
        driverMulti.manage().window().maximize();
        //providing timeout for complete loading of page
        driverMulti.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     //printing title of the selected browser in console
        //get the title of the page
        String title = driverMulti.getTitle();
        System.out.println(title);
        // get current URL
        System.out.println("Current URl :" + driverMulti.getCurrentUrl());

        // Get page source
        System.out.println("Page source : " + driverMulti.getPageSource());

        // Nevigate to login page
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driverMulti.navigate().to(loginUrl);

        // Navigate to log in page by clicking on log in link
        WebElement loginLink = driverMulti.findElement(By.linkText("Log in"));
        loginLink.click();

        // find the email field element
        // driver.findElement(By.id());
        WebElement emailField = driverMulti.findElement(By.id("email"));
        emailField.sendKeys("test123@gmail.com");

        // Find the password field element
        //  driver.findElement(By.name(""));
        WebElement passwordField = driverMulti.findElement(By.name("Password"));
        passwordField.sendKeys("test123");

        // Close the browser automatically
        // driver.close();
        driverMulti.quit();
    }
}
