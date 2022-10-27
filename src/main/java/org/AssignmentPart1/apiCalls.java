package org.AssignmentPart1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class apiCalls {
    public void postRequest(
        int alertType,
        String heading,
        String description,
        String url,
        String imageURL,
        String postedBy,
        long priceInCents
    ) throws IOException {
        //Setting up HTTP request connection + headers
        URL endpoint = new URL("https://api.marketalertum.com/Alert");
        HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        //Body
        JSONObject body = new JSONObject();
        body.put("alertType",alertType);
        body.put("heading",heading);
        body.put("description",description);
        body.put("url",url);
        body.put("imageURL",imageURL);
        body.put("postedBy",postedBy);
        body.put("priceInCents",priceInCents);

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
    }

    public void deleteRequest(String userId) throws IOException{
        URL endpoint = new URL("https://api.marketalertum.com/Alert?userId=" + userId);
        HttpURLConnection con = (HttpURLConnection) endpoint.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(false);

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}