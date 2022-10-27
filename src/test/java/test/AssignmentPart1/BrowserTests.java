package test.AssignmentPart1;

import org.AssignmentPart1.apiCalls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class BrowserTests {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
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

    @Test
    public void testPostAPICall() throws IOException {
        apiCalls call = new apiCalls();
        call.postRequest(
        6,
        "Jumper Windows 11 Laptop",
        "Jumper Windows 11 Laptop 1080P Display,12GB RAM 256GB SSD",
        "https://www.amazon.co.uk/Windows-Display-Ultrabook-Processor-Bluetooth",
        "https://m.media-amazon.com/images/I/712Xf2LtbJL._AC_SX679_.jpg",
        "46aba3d5-35a9-4850-b5c1-02824284c450",
        24999
        );
    }

    @Test
    public void testDeleteAPICall() throws IOException {
        apiCalls call = new apiCalls();
        call.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
    }
}
