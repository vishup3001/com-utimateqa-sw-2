package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // Close all windows
        closeBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        String expectedMessage = "Welcome Back!";
        // Element to click on Sign in link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']//a")).click();

        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on login button", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheErrorMessage() {
        String expectedMessage = "Invalid email or password.";
        // Element to click on Sign in link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']//a")).click();
        //Element to enter username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("Admin");
        //Element to enter password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Admin123");
        //Element to click on Sign in button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();

        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on login button", expectedMessage, actualMessage);

    }

}
