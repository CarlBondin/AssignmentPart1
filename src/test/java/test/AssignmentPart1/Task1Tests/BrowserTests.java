package test.AssignmentPart1.Task1Tests;

import org.AssignmentPart1.Task1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;

public class BrowserTests {
    Task1 task1;
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        task1 = new Task1(driver);
    }

    @AfterEach
    public void teardown() throws IOException {
        task1.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
    }

    @Test
    public void testMaltaparkNavigation(){
        //Testing title of tab
        String title = task1.navigation();
        Assertions.assertEquals("Cars | Maltapark", title);
    }

    @Test
    public void testAdd5ItemsToMyAlerts() throws IOException {
        List<Integer> statusCodes = task1.screenScraper();
        boolean check = statusCodes.contains(201);
        Assertions.assertTrue(check);
    }

    @Test
    public void testAddItemToMyAlerts() throws IOException, NumberFormatException{
        //Testing the addition of one item to My Alerts

        //Navigating to car listings page
        task1.navigation();

        //Calling REST API
        List<Integer> statusCodes = task1.postRequest(1);
        boolean check = statusCodes.contains(201);
        Assertions.assertTrue(check);
    }

    @Test
    public void testDeleteAllItems() throws IOException {
        //Calling REST API
        int statusCode = task1.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
        Assertions.assertEquals(200,statusCode);
    }
}


