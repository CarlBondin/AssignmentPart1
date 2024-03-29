package org.AssignmentPart1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    WebDriver driver;

    public void login(String credentials){
        System.setProperty("webdriver.chrome.driver", "/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.marketalertum.com/Alerts/Login");
        WebElement searchField = driver.findElement(By.id("UserId"));
        searchField.sendKeys(credentials);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.submit();
    }

    public String elementFinder(String xpath){
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public int elementCounter(String xpath){
      return driver.findElements(By.xpath(xpath)).size();
    }

    public String elementFinder(String xpath, String attribute){
        return driver.findElement(By.xpath(xpath)).getAttribute(attribute);
    }

    public void teardown(){
        driver.quit();
    }
}
