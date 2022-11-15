import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {
    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver driverF=new FirefoxDriver();
        driverF.get(baseUrl);
        driverF.manage().window().maximize();
        driverF.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //get and print title page in console
        String title= driverF.getTitle();
        System.out.println("page title is:"+title);
        //get current url
        System.out.println(("Current URL:"+ driverF.getCurrentUrl()));
        //get page source
        System.out.println("Page source:"+ driverF.getPageSource());
        //getting and entering email in email field
        WebElement emailField=driverF.findElement(By.id("Email"));
        emailField.sendKeys("sp@gmail.com");
        //getting and entering password in password field
        WebElement passwoedField =driverF.findElement(By.id("Password"));
        passwoedField.sendKeys("pass_234");

        // Closing the chrome browser
        driverF.quit();


    }
}
