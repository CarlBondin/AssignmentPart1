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
        WebElement searchField = driver.findElement(By.id("search"));
        searchField.sendKeys("BMW");
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testMaltaparkSearch(){
        String title = driver.getTitle();
        Assertions.assertEquals("Home | Maltapark", title);
    }

    @Test
    public void testAddItemToMyAlerts() throws IOException, NumberFormatException{
        String itemCheck = driver.findElement(By.xpath("//div[@id='page-content-left']/div/@class")).toString();
        System.out.println(itemCheck);
        if(!(itemCheck.contains("item featured"))) {
            //Getting item information
            String url = driver.findElement(By.xpath("//a[@class='header']")).getAttribute("href");
            driver.get(url);
            System.out.println(url);

            String heading = driver.findElement(By.xpath("//h1[@class='top-title']")).getText();
            System.out.println(heading);

            String imageUrl = driver.findElement(By.xpath("//a[@class = 'fancybox']")).getAttribute("href");
            System.out.println(imageUrl);

            String description = driver.findElement(By.xpath("//div[@class='readmore-wrapper']")).getText();
            System.out.println(description);

            String priceString = driver.findElement(By.xpath("//h1[@class='top-price']")).getText();
            priceString = priceString.replace("€ ", "");
            if (priceString.contains(",")) {
                priceString = priceString.replace(",", "");
            }
            int price = Integer.parseInt(priceString);
            System.out.println(price);
            int priceCents = price * 100;
            System.out.println(priceCents);

            call.postRequest(
                    1,
                    heading,
                    description,
                    url,
                    imageUrl,
                    "46aba3d5-35a9-4850-b5c1-02824284c450",
                    priceCents
            );
        }
    }
}


