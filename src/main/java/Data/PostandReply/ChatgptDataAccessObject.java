package Data.PostandReply;
import Entity.PostandReply.Message;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;
import use_case.postandreply.ChatwithAI.ChatgptDataAccessInterface;

public class ChatgptDataAccessObject implements ChatgptDataAccessInterface {

    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";

    @Override
    public String GetResponse(String model, Message message) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .POST(BodyPublishers.ofString(buildRequestBody(model, message)))
                .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return extractContentFromResponse(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String extractContentFromResponse(String responseBody) {
        JSONObject responseJson = new JSONObject(responseBody);
        JSONArray choices = responseJson.getJSONArray("choices");
        if (!choices.isEmpty()) {
            JSONObject firstChoice = choices.getJSONObject(0);
            JSONObject message = firstChoice.getJSONObject("message");
            return message.getString("content");
        }
        return "No response";
    }


    private String buildRequestBody(String model, Message message) {
        JSONObject json = new JSONObject();
        json.put("model", model);
        json.put("messages", new JSONObject[] { new JSONObject()
                .put("role", message.getRole())
                .put("content", message.getContent())
        });
        return json.toString();
    }
}
