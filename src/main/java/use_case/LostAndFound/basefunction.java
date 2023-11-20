package use_case.LostAndFound;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import Data.LAFDataAccess;

public class basefunction{
    public void reportLostItem(LAFDataAccess LAFDataAccess) throws Exception {
        String jsonPayload = toJson(LAFDataAccess);
        sendPostRequest("test/api/lost", jsonPayload);
    }

    public void reportFoundItem(LAFDataAccess LAFDataAccess) throws Exception {
        String jsonPayload = toJson(LAFDataAccess);
        sendPostRequest("test/api/found", jsonPayload);
    }

    private void sendPostRequest(String urlString, String jsonInputString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(java.io.OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

    private String toJson(LAFDataAccess LAFDataAccess) {
        // Convert the Item object to JSON string.
        // This is a placeholder. In a real application, use a library like Gson or Jackson.
        return String.format("{\"name\":\"%s\", \"description\":\"%s\", \"locationLostOrFound\":\"%s\"}",
                LAFDataAccess.getName(), LAFDataAccess.getDescription(), LAFDataAccess.getLocationLostOrFound());
    }
}
