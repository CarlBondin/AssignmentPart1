package test.AssignmentPart1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTests {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Code/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testSimpleGoogleSearch(){
        driver.get("https://www.marketalertum.com/");
    }
}
