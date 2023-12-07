package API;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LAFAutoCorrect implements AutoCorrect{
    private final String API_URL = "https://api.apilayer.com/dymt/did_you_mean_this?q=";
    private final String API_KEY = "GU2P6QqVdWN26fD6wo35zcrJ2n3u2CgB";
    public String getCorrectedText(String originalText) {
        String updatedURL = API_URL + originalText.toLowerCase();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        JSONObject requestBody = new JSONObject();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody.toString());

        Request request = new Request.Builder()
                .url(updatedURL).addHeader("apikey", API_KEY)
                .method("GET", null).build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody.getString("result");

        } catch (IOException | JSONException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        LAFAutoCorrect c = new LAFAutoCorrect();
        System.out.println(c.getCorrectedText("Lost and Found aims to help student find their lost item"));
    }
}

