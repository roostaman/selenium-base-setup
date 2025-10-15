package tests;

import helper.GetConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class BaseTest {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private final Integer IMPLICIT_WAIT = Integer.parseInt(GetConfig.get("IMPLICIT_WAIT"));

    @BeforeEach
    public void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-infobars", "--disable-extensions");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driverThread.set(driver);
    }

    @AfterEach
    public void tearDownDriver() {
        WebDriver driver = driverThread.get();
        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }

    protected WebDriver getDriver() {
        return driverThread.get();
    }
}
