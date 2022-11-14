package test.AssignmentPart1.Task1Tests;

import org.AssignmentPart1.Task1;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MockTests {
    @Test
    public void testNoAlertType() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testNoHeading() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testDescription() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testNoUrl() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testNoImageUrl() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testNoPostedBy() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testNoPrice() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(400);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }

    @Test
    public void testValidUpload() throws IOException {
        //Setup
        JSONObject alertData = new JSONObject();
        alertData.put("alertType",1);
        alertData.put("heading","Maserati Ghibli");
        alertData.put("description","Maserati Ghibli V6 Diesel, 2015, black leather interior, 32,000 miles, Automatic.");
        alertData.put("url","https://www.maltapark.com/item/details/9525491");
        alertData.put("imageURL","https://www.maltapark.com/asset/itemphotos/9525491/9525491_1.jpg/?x=TWF4Vz01NjMmTWF4SD00MjI=&_ts=4");
        alertData.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
        alertData.put("priceInCents","5000000");

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.postRequest(alertData)).thenReturn(201);

        int statusCode = task1.postRequest(alertData);

        //Verify
        Assertions.assertEquals(201,statusCode);
    }

    @Test
    public void testValidDelete() throws IOException {
        //Setup
        String userId = "46aba3d5-35a9-4850-b5c1-02824284c450";

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.deleteRequest(userId)).thenReturn(200);

        int statusCode = task1.deleteRequest(userId);

        //Verify
        Assertions.assertEquals(200,statusCode);
    }

    @Test
    public void testInvalidDelete() throws IOException {
        //Setup
        String userId = "WrongCredentials";

        //Exercise
        Task1 task1 = Mockito.mock(Task1.class);
        Mockito.when(task1.deleteRequest(userId)).thenReturn(400);

        int statusCode = task1.deleteRequest(userId);

        //Verify
        Assertions.assertEquals(400,statusCode);
    }
}