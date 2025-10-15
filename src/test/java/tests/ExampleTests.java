package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ExampleTests extends BaseTest {


    @Test
    public void testGoogle() {
        WebDriver driver = getDriver();

        driver.get("https://practice-automation.com/");


    }

    @Disabled
    @Test
    public void testAmazon() {
        WebDriver driver = getDriver();

        driver.get("https://www.amazon.com");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
    }

    @Disabled
    @Test
    public void testReddit() {
        WebDriver driver = getDriver();

        driver.get("https://reddit.com");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0);");
    }
}
