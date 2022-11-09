package org.AssignmentPart1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task1 {
    WebDriver driver;

    public List<Integer> screenScraper() throws IOException {
        //Navigating to car category in maltapark
        navigation();
        List<Integer> statusCodes = postRequest(5);
        return statusCodes;
    }

    public String navigation(){
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

        //Will be used in testing
        return driver.getTitle();
    }

    public List<Integer> postRequest(int noOfAlerts) throws IOException {
        //List containing all status codes of every POST request
        List<Integer> statusCodes = new ArrayList<Integer>();
        for(int i = 0; i < noOfAlerts; i++){
            //Setting up HTTP request connection + headers
            URL endpoint = new URL("https://api.marketalertum.com/Alert");
            HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            //Getting Item Details
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

            //Body
            JSONObject body = new JSONObject();
            body.put("alertType",1);
            body.put("heading",title);
            body.put("description",description);
            body.put("url",url);
            body.put("imageURL",imageUrl);
            body.put("postedBy","46aba3d5-35a9-4850-b5c1-02824284c450");
            body.put("priceInCents",priceCents);

            String stringBody = body.toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = stringBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
            Integer statusCode = Integer.valueOf(con.getResponseCode());
            statusCodes.add(statusCode);
        }
        driver.quit();
        return statusCodes;
    }

    public int deleteRequest(String userId) throws IOException{
        System.setProperty("webdriver.chrome.driver", "/Documents/UM/3rd year Sem1/CPS3230-Software Testing/Exercises/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        URL endpoint = new URL("https://api.marketalertum.com/Alert?userId=" + userId);
        HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(false);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            System.out.println(response.toString());
            driver.quit();
            return con.getResponseCode();
        }
    }
}