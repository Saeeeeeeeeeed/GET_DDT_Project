package Tests;

import Utill.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void setup ()
    {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.navigate().to("https://phptravels.net/signup");
    }

    @AfterSuite
    public void teardown ()
    {
        driver.quit();
    }

    @AfterMethod
    public void screenshotFailure (ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            Helper.CapScreenShot(driver, result.getName());

        }
    }
}
