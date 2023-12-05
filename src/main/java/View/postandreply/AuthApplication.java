package View.postandreply;
import API.Auth0Client;
import javax.swing.*;
import java.awt.*;


public class AuthApplication extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);
    private final Auth0Client auth0Client = new Auth0Client();

    public AuthApplication() {
        super("Auth0 Authentication");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 300);

        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createSignupPanel(), "Signup");

        add(mainPanel);
    }
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton switchToSignupButton = new JButton("Sign Up");
        JToggleButton showHidePasswordButton = new JToggleButton("Show Password");


        emailField.setPreferredSize(new Dimension(300, 30));
        passwordField.setPreferredSize(new Dimension(300, 30));


        loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        loginButton.setBackground(new Color(0, 122, 204));
        loginButton.setForeground(Color.WHITE);
        switchToSignupButton.setForeground(new Color(0, 122, 204));

        c.gridx = 0;
        c.gridy = 0;
        loginPanel.add(new JLabel("Email:"), c);

        c.gridx = 1;
        loginPanel.add(emailField, c);

        c.gridx = 0;
        c.gridy = 1;
        loginPanel.add(new JLabel("Password:"), c);

        c.gridx = 1;
        loginPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        loginPanel.add(loginButton, c);

        c.gridy = 3;
        loginPanel.add(switchToSignupButton, c);

        c.gridy = 4;
        loginPanel.add(showHidePasswordButton, c);

        loginButton.addActionListener(e -> performLogin(emailField.getText(), new String(passwordField.getPassword())));
        switchToSignupButton.addActionListener(e -> cardLayout.show(mainPanel, "Signup"));
        showHidePasswordButton.addActionListener(e -> togglePasswordVisibility(passwordField));

        return loginPanel;
    }

    private JPanel createSignupPanel() {
        JPanel signupPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton signupButton = new JButton("Sign Up");
        JButton switchToLoginButton = new JButton("Login");
        JToggleButton showHidePasswordButton = new JToggleButton("Show Password");


        emailField.setPreferredSize(new Dimension(300, 30));
        passwordField.setPreferredSize(new Dimension(300, 30));


        c.gridx = 0;
        c.gridy = 0;
        signupPanel.add(new JLabel("Email:"), c);

        c.gridx = 1;
        signupPanel.add(emailField, c);

        c.gridx = 0;
        c.gridy = 1;
        signupPanel.add(new JLabel("Password:"), c);

        c.gridx = 1;
        signupPanel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        signupPanel.add(signupButton, c);

        c.gridy = 3;
        signupPanel.add(switchToLoginButton, c);

        c.gridy = 4;
        signupPanel.add(showHidePasswordButton, c);


        JLabel passwordRequirementsLabel = new JLabel("Password Requirements: " +
                "At least 8 characters, 3 of the following 4 types: " +
                "lowercase, uppercase, numbers, characters(!@#$%^&*)");
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        signupPanel.add(passwordRequirementsLabel, c);

        signupButton.addActionListener(e -> performSignup(emailField.getText(), new String(passwordField.getPassword())));
        switchToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        showHidePasswordButton.addActionListener(e -> togglePasswordVisibility(passwordField));

        return signupPanel;
    }
    private void togglePasswordVisibility(JPasswordField passwordField) {
        if (passwordField.getEchoChar() == '\0') {
            passwordField.setEchoChar('*');
        } else {
            passwordField.setEchoChar('\0');
        }
    }

    private void performLogin(String email, String password) {
        String token = auth0Client.loginUser(email, password);
        if (token != null && !token.isEmpty()) {
            dispose();
            SwingUtilities.invokeLater(() -> new DiscussionBoard().setVisible(true));
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void performSignup(String email, String password) {
        String result = auth0Client.signupUser(email, password);
        JOptionPane.showMessageDialog(this, result, "Signup Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthApplication().setVisible(true));
    }
}
