import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTest {
//creating main method of the class
    public static void main(String[] args) {
        // declaring string type local variable
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        // setting chrome browser
        System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
       //initialising interface object
        WebDriver driverE = new EdgeDriver();
//opening url in chrome
        driverE.get(baseUrl);
        //maximising window upon opening
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
        emailField.sendKeys("spsp@gmail.com");
        //getting and entering password in password field
        WebElement passwordField =driverE.findElement(By.id("Password"));
        passwordField.sendKeys("1234Pass");

        // Closing the chrome browser
        driverE.quit();


    }


}
