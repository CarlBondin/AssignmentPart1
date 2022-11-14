package test.AssignmentPart1.Task1Tests;

import org.AssignmentPart1.Task1;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UnitTests {
    Task1 task1;

    @BeforeEach
    public void setup() {
        task1 = new Task1();
    }

    @Test
    public void testMaltaparkNavigation(){
        //Checking title of tab to test navigation
        String title = task1.navigation();
        Assertions.assertEquals("Cars | Maltapark", title);
    }

    @Test
    public void testAdd5ItemsToMyAlertsViaScraper() throws IOException {
        //Testing the addition of 5 alerts using the screen whole scraper
        List<Integer> statusCodes = task1.screenScraper();
        for(int i = 0; i < 5; i++) {
            int statusCode = statusCodes.get(i);
            Assertions.assertEquals(201,statusCode);
        }
    }

    @Test
    public void testAdd5ItemsToMyAlertsViaPostMethod() throws IOException, NumberFormatException{
        //Testing the addition of five items to My Alerts using postRequest method

        //JSON Object dummy
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        List<Integer> statusCodes = new ArrayList<>();//storage of the 5 status codes representing 5 api calls

        //Calling REST API
        for(int i = 0; i < 5; i++) {
            int statusCode = task1.postRequest(alertData);
            statusCodes.add(statusCode);
        }

        boolean check = statusCodes.contains(201);
        Assertions.assertTrue(check);
    }

    @Test
    public void testAddItemToMyAlerts() throws IOException, NumberFormatException{
        //Testing the addition of one item to My Alerts

        //JSON Object dummy
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Calling REST API
        int statusCode = task1.postRequest(alertData);
        Assertions.assertEquals(201,statusCode);
    }

    @Test
    public void testDeleteAllItems() throws IOException {
        //Calling REST API
        int statusCode = task1.deleteRequest("46aba3d5-35a9-4850-b5c1-02824284c450");
        Assertions.assertEquals(200,statusCode);
    }
}


