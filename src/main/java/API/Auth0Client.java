package API;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Auth0Client implements Auth0surface {
    private static final String AUTH0_DOMAIN = "dev-rjfiaoqdsj63w030.us.auth0.com";
    private static final String CLIENT_ID = "ACiPex0SsHwCVIXb7GHW6IY64YPitRHj";
    private final HttpClient client;

    public Auth0Client() {
        this.client = createHttpClient();
    }

    private HttpClient createHttpClient() {
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD)
                .build();
        return HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .build();
    }

    public String loginUser(String email, String password) {
        try {
            HttpPost post = new HttpPost("https://" + AUTH0_DOMAIN + "/oauth/token");

            post.setHeader("Content-Type", "application/json");
            JSONObject body = new JSONObject();
            body.put("client_id", CLIENT_ID);
            body.put("grant_type", "password");
            body.put("username", email);
            body.put("password", password);
            body.put("audience", "YOUR_AUDIENCE");
            body.put("scope", "openid");

            post.setEntity(new StringEntity(body.toString()));

            HttpResponse response = client.execute(post);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(jsonResponse);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                return "Login failed: " + jsonObject.optString("error_description", "Unknown error");
            }

            return jsonObject.optString("access_token", "No access token received");
        } catch (Exception e) {
            return "Login failed with exception: " + e.getMessage();
        }
    }

    public String signupUser(String email, String password) {
        try {
            HttpClient client = createHttpClient();
            HttpPost post = new HttpPost("https://" + AUTH0_DOMAIN + "/dbconnections/signup");

            post.setHeader("Content-Type", "application/json");
            JSONObject body = new JSONObject();
            body.put("client_id", CLIENT_ID);
            body.put("email", email);
            body.put("password", password);
            body.put("connection", "Username-Password-Authentication");

            post.setEntity(new StringEntity(body.toString()));

            HttpResponse response = client.execute(post);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject responseJson = new JSONObject(responseBody);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                System.out.println("Signup failed with status code: " + statusCode);
                System.out.println("Response: " + responseBody);
                return responseJson.optString("error_description", "Signup failed for an unknown reason");
            }

            return "Signup successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Signup failed with exception: " + e.getMessage();
        }
    }
}
