package test.AssignmentPart1.Task2Tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.AssignmentPart1.Task2;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2Steps {
    protected WebDriver driver;
    Task2 test;

    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() {
        System.setProperty("webdriver.chrome.driver", "/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
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
        Assertions.assertEquals("User ID: ", loginPage);
    }

    @Given("I am an administrator of the website")
    public void iAmAnAdministratorOfTheWebsite() {
    }

    @And("I upload {int} alerts")
    public void iUploadAlerts(int arg0) {
    }

    @When("I view a list of alerts")
    public void iViewAListOfAlerts() {
    }

    @Then("each alert should contain an icon")
    public void eachAlertShouldContainAnIcon() {
    }

    @And("each alert should contain a heading")
    public void eachAlertShouldContainAHeading() {
    }

    @And("each alert should contain a description")
    public void eachAlertShouldContainADescription() {
    }

    @And("each alert should contain an image")
    public void eachAlertShouldContainAnImage() {
    }

    @And("each alert should contain a price")
    public void eachAlertShouldContainAPrice() {
    }

    @And("each alert should contain a link to the original product website")
    public void eachAlertShouldContainALinkToTheOriginalProductWebsite() {
    }

    @And("I upload more than {int} alerts")
    public void iUploadMoreThanAlerts(int arg0) {
    }

    @Then("I should see {int} alerts")
    public void iShouldSeeAlerts(int arg0) {
    }

    @And("I upload an alert of type <alert-type>")
    public void iUploadAnAlertOfTypeAlertType() {
    }

    @And("the icon displayed should be <file-name>")
    public void theIconDisplayedShouldBeFileName() {
    }
}
