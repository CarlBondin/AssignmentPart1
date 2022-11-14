package test.AssignmentPart1.Task2Tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.AssignmentPart1.Task1;
import org.AssignmentPart1.Task2;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class Task2Steps {

    Task2 test;
    Task1 testAPI;

    @Given("I am a user of marketalertum")
    public void iAmAUserOfMarketalertum() {
        test = new Task2();
    }

    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {
        test.login("46aba3d5-35a9-4850-b5c1-02824284c450");
    }

    @Then("I should see my alerts")
    public void iShouldSeeMyAlerts() {
        String alertsTitle = test.elementFinder("//main[@role='main']/h1");
        Assertions.assertEquals("Latest alerts for Carl Bondin", alertsTitle);
        //teardown
        test.teardown();
    }

    @When("I login using invalid credentials")
    public void iLoginUsingInvalidCredentials() {
        test.login("wrongCredentials");
    }

    @Then("I should see the login screen again")
    public void iShouldSeeTheLoginScreenAgain() {
        String loginPage = test.elementFinder("//form[@method='post']/b");
        Assertions.assertEquals("User ID:", loginPage);
        //teardown
        test.teardown();
    }

    @Given("I am an administrator of the website")
    public void iAmAnAdministratorOfTheWebsite(){
        testAPI = new Task1();
    }

    @And("I upload {int} alerts")
    public void iUploadAlerts(int arg0) throws IOException {
        testAPI.navigation();
        testAPI.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
        for(int i = 0; i < arg0; i++) {
            JSONObject alertData = testAPI.alertDetails();
            testAPI.postRequest(alertData);
        }
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

        //teardown
        test.teardown();
    }

    @And("I upload more than {int} alerts")
    public void iUploadMoreThanAlerts(int arg0) throws IOException {
        testAPI.navigation();
        testAPI.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
        JSONObject alertData = testAPI.alertDetails();
        arg0++; //More than 5
        for(int i = 0; i < arg0; i++) {
            testAPI.postRequest(alertData);
        }
    }

    @Then("I should see {int} alerts")
    public void iShouldSeeAlerts(int arg0) {
        int noOfAlerts = test.elementCounter("//table/tbody");
        Assertions.assertEquals(arg0, noOfAlerts);
    }

    @And("I upload an alert of type {string}")
    public void iUploadAnAlertOfType(String arg0) throws IOException {
        testAPI.navigation();
        testAPI.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
        //Dummy object containing alert type given in example of scenario outline
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",Integer.parseInt(arg0));
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");
        testAPI.postRequest(alertData);
    }

    @And("the icon displayed should be {string}")
    public void theIconDisplayedShouldBe(String arg0) {
        test.login("46aba3d5-35a9-4850-b5c1-02824284c450");
        String icon = test.elementFinder("//img[@width='100']", "src");
        Assertions.assertEquals("https://www.marketalertum.com/images/" + arg0,icon);
        //teardown
        test.teardown();
    }
}
