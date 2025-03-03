package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MiliLoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/anindita/Library/Application\\ Support/Google/Chrome"); // Mac
        options.addArguments("--profile-directory=Default");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://app.getmilitest.com/");
    }

    @Test
    public void detectEmailEditBox() {
        WebElement editBox = driver.findElement(By.xpath("//input[@placeholder='Enter work email']"));
        Assert.assertTrue(editBox.isDisplayed());
    }

    @Test
    public void inputEmailTriggerOtp() {
        try {
            WebElement editBox = driver.findElement(By.xpath("//input[@placeholder='Enter work email']"));
            editBox.sendKeys("mishraanindita95@gmail.com");
            Thread.sleep(2000);
            WebElement tryNowButton = driver.findElement(By.xpath("//button[contains(text(),'Try now')]"));
            tryNowButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inputOtpAndLogin() {
        try {
            Thread.sleep(45000);
            WebElement verifyButton = driver.findElement(By.xpath("//button[contains(text(),'Verify')]"));
            verifyButton.click();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser
        }
    }
}