package javaPract;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FbLogin {

    public static void main(String[] args) throws IOException {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Facebook login page
        driver.get("https://www.facebook.com/");

        // Get and print the page title
        String title = driver.getTitle();
        System.out.println("Facebook Login Page Title: " + title);

        // Take screenshot and save in resources folder
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(
                src,
                new File("src/main/resources/screenshots/fb_login_page.png")
        );

        // Close the browser
        driver.quit();
    }
}
