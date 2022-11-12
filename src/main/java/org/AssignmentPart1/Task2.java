package org.AssignmentPart1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    WebDriver driver;
    public Task2(WebDriver driver){
        this.driver = driver;
    }

    public void login(String credentials){
        driver.get("https://www.marketalertum.com/Alerts/Login");
        WebElement searchField = driver.findElement(By.id("UserId"));
        searchField.sendKeys(credentials);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.submit();
    }

    public String elementFinder(String xpath){
        String text = driver.findElement(By.xpath(xpath)).getText();
        return text;
    }

    public String elementFinder(String xpath, String attribute){
        String element = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
        return element;
    }
}
