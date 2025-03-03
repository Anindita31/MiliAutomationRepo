package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MiliHomeTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/anindita/Library/Application\\ Support/Google/Chrome");
        options.addArguments("--profile-directory=Default");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://app.getmilitest.com/");
    }

    @Test
    public void createMeetingTest() {
        try {
            Thread.sleep(4000);
            WebElement createMeetingElement = driver.findElement(By.xpath("//h6[contains(@class, 'MuiTypography-root') and text()='Create Meeting']"));
            createMeetingElement.click();
            Thread.sleep(4000);
            WebElement dropdown = driver.findElement(By.xpath("//div[@id='Meeting Template' and self::div]"));
            dropdown.click();
            Thread.sleep(2000);
            WebElement meetingType = driver.findElement(By.xpath("//li[@role='option']//p[text()='Onboarding meeting']"));
            meetingType.click();
            Thread.sleep(2000);
            WebElement meetingMembers = driver.findElement(By.xpath("//div[contains(@class, 'MuiOutlinedInput-root') and .//input[@id=':r2:']]"));
            meetingMembers.click();
            Thread.sleep(2000);
            WebElement selectMember = driver.findElement(By.xpath("//ul[@id=':r2:-listbox']/li[@data-option-index='0']"));
            selectMember.click();
            Thread.sleep(2000);
            WebElement clientMember = driver.findElement(By.xpath("//label[@id=':r4:-label']"));
            clientMember.click();
            Thread.sleep(2000);
            WebElement clientSelect = driver.findElement(By.xpath("//li[contains(@class, 'MuiAutocomplete-option')]//p[text()='Temp']"));
            clientSelect.click();
            Thread.sleep(2000);
            WebElement createMeeting = driver.findElement(By.xpath("//div[contains(@class, 'MuiBox-root') and contains(@class, 'css-kl1xo3')]//button"));
            createMeeting.click();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit(); // Close the browser
        }
    }
}