package ca.qaguru.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeTest {

    WebDriver driver;
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void validLogin() {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='Submit' and @id='btnLogin']")).click();
        WebElement welcome = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertEquals(welcome.getText(), "Welcome Paul", "Text not matching");
    }
    @Test
    public void invalidLogin() {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin12345");
        driver.findElement(By.xpath("//input[@name='Submit' and @id='btnLogin']")).click();
        WebElement invalidMsg = driver.findElement(By.xpath("//*[@id='spanMessage']"));
        Assert.assertEquals(invalidMsg.getText(), "Invalid credentials", "Text not matching");
    }


}
