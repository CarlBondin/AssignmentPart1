package test.AssignmentPart1.Task1Tests;

import org.AssignmentPart1.Task1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class BrowserTests {
    WebDriver driver;
    Task1 call;

    @BeforeEach
    public void setup() {
        call = new Task1();

        System.setProperty("webdriver.chrome.driver", "/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        //Navigating to Maltapark website
        driver.get("https://www.maltapark.com/");
        //Navigating to Cars Category by hovering on Cars & Parts hoverable menu
        Actions actions = new Actions(driver);
        WebElement primarySearchCategory = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/ul/li[4]/a"));
        actions.moveToElement(primarySearchCategory).perform();
        WebElement searchCategory = driver.findElement(By.xpath("/html/body/div/header/div[2]/div/div/ul/li[4]/ul/li[2]/a"));
        searchCategory.click();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testMaltaparkSearch(){
        //Testing title of tab
        String title = driver.getTitle();
        Assertions.assertEquals("Cars | Maltapark", title);
    }

    @Test
    public void testAddItemToMyAlerts() throws IOException, NumberFormatException{
        //Testing the addition of one item to My Alerts
        //Getting item information
        String url = driver.findElement(By.xpath("//a[@class='header']")).getAttribute("href");
        driver.get(url);
        String title = driver.findElement(By.xpath("//h1[@class='top-title']")).getText();
        String imageUrl = driver.findElement(By.xpath("//a[@class = 'fancybox']")).getAttribute("href");
        String description = driver.findElement(By.xpath("//div[@class='readmore-wrapper']")).getText();
        String priceString = driver.findElement(By.xpath("//h1[@class='top-price']")).getText();
        priceString = priceString.replace("€ ", "");
        if (priceString.contains(",")) {
            priceString = priceString.replace(",", "");
        }
        int price = Integer.parseInt(priceString);
        int priceCents = price * 100;

        //Logging of details
        System.out.println("URL: " + url);
        System.out.println("Title: " + title);
        System.out.println("Image URL: " + imageUrl);
        System.out.println("Description: " + description);
        System.out.println("Price in cents: " + priceCents);

        //Calling REST API
        call.postRequest(
                1,
                title,
                description,
                url,
                imageUrl,
                "46aba3d5-35a9-4850-b5c1-02824284c450",
                priceCents
        );


    }

    @Test
    public void testDeleteAllItems() throws IOException {
        call.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
    }
}


