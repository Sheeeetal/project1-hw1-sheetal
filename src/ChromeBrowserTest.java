import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class ChromeBrowserTest {
    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driverE = new ChromeDriver();
//launce url
        driverE.get(baseUrl);
        //maximise window
        driverE.manage().window().maximize();
        //time given to driver to wait until page is loaded completely
        driverE.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //get and print title page in console
        String title= driverE.getTitle();
        System.out.println("page title is:"+title);
        //get current url
        System.out.println(("Current URL:"+ driverE.getCurrentUrl()));
        //get page source
        System.out.println("Page source:"+ driverE.getPageSource());
       //getting and entering email in email field
        WebElement emailField=driverE.findElement(By.id("Email"));
        emailField.sendKeys("sp@gmail.com");
        //getting and entering password in password field
        WebElement passwordField =driverE.findElement(By.id("Password"));
        passwordField.sendKeys("pass_234");

        // Closing the chrome browser
        driverE.quit();


    }
    }
