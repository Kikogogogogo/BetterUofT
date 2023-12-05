package API;

public interface Auth0surface {
    String loginUser(String email, String password);
    String signupUser(String email, String password);
}
