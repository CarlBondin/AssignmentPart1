package test.AssignmentPart1.Task2Tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.AssignmentPart1.Task1;
import org.AssignmentPart1.Task2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Task2Steps {
    WebDriver driver;
    Task2 test;
    Task1 testAPI;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() {
        test = new Task2(driver);
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {
        test.login("46aba3d5-35a9-4850-b5c1-02824284c450");
    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        String alertsTitle = test.elementFinder("//main[@role='main']/h1");
        Assertions.assertEquals("Latest alerts for Carl Bondin", alertsTitle);
    }

    @When("I login using invalid credentials")
    public void iLoginUsingInvalidCredentials() {
        test.login("wrongCredentials");
    }

    @Then("I should see the login screen again")
    public void iShouldSeeTheLoginScreenAgain() {
        String loginPage = test.elementFinder("//form[@method='post']/b");
        Assertions.assertEquals("User ID:", loginPage);
    }

    @Given("I am an administrator of the website")
    public void iAmAnAdministratorOfTheWebsite() throws IOException {
        testAPI = new Task1(driver);
        //Deleting any previous alerts
        testAPI.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
    }

    @And("I upload {int} alerts")
    public void iUploadAlerts(int arg0) throws IOException {
        testAPI.navigation();
        testAPI.postRequest(arg0);
    }

    @When("I view a list of alerts")
    public void iViewAListOfAlerts() {
        test.login("46aba3d5-35a9-4850-b5c1-02824284c450");
    }

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
        for (int i = 0; i < 3; i++) {
            String icon = test.elementFinder("//img[@width='100']", "src");
            boolean check = icon.isEmpty();
            Assertions.assertFalse(check);
        }
    }

    @And("each alert should contain a heading")
    public void eachAlertShouldContainAHeading() {
        for (int i = 0; i < 3; i++) {
            String heading = test.elementFinder("//td[@colspan='2']/h4");
            boolean check = heading.isEmpty();
            Assertions.assertFalse(check);
        }
    }

    @And("each alert should contain a description")
    public void eachAlertShouldContainADescription() {
        for (int i = 0; i < 3; i++) {
            String description = test.elementFinder("/html/body/div/main/table/tbody/tr[3]/td");
            boolean check = description.isEmpty();
            Assertions.assertFalse(check);
        }
    }

    @And("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
        for(int i =0; i< 3; i++) {
        String imageUrl = test.elementFinder("//img[@width='200']", "src");
        boolean check = imageUrl.isEmpty();
        Assertions.assertFalse(check);
        }
    }

    @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
        for (int i = 0; i < 3; i++) {
            String price = test.elementFinder("/html/body/div/main/table/tbody/tr[4]/td");
            boolean check = price.isEmpty();
            Assertions.assertFalse(check);
        }
    }

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
        for(int i =0; i< 3; i++) {
            String imageUrl = test.elementFinder("/html/body/div/main/table/tbody/tr[5]/td/a", "href");
            boolean check = imageUrl.isEmpty();
            Assertions.assertFalse(check);
        }
    }

    @And("I upload more than {int} alerts")
    public void iUploadMoreThanAlerts(int arg0) throws IOException {
        testAPI.navigation();
        arg0++; //More than 5
        testAPI.postRequest(arg0);
    }

    @Then("I should see {int} alerts")
    public void iShouldSeeAlerts(int arg0) {
        int noOfAlerts = driver.findElements(By.xpath("//table/tbody")).size();
        Assertions.assertEquals(arg0, noOfAlerts);
    }

    @And("I upload an alert of type {string}")
    public void iUploadAnAlertOfType(String arg0) throws IOException {
        testAPI.navigation();
        testAPI.postRequest(1, arg0);
    }

    @And("the icon displayed should be {string}")
    public void theIconDisplayedShouldBe(String arg0) {
        test.login("46aba3d5-35a9-4850-b5c1-02824284c450");
        String icon = test.elementFinder("//img[@width='100']", "src");
        Assertions.assertEquals("https://www.marketalertum.com/images/" + arg0,icon);
    }
}
