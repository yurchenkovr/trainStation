package services.modelsUI;

public class User {
    private String username;
    private String password;
    private String verifyPassword;
    public static final String INVALIDPASSWORD = "Password must be more than 5 chars";
    public static final String PASSWORDDOESNTMATCH = "Password doesn't match";

    public User(String username, String password, String verifyPassword) throws IllegalArgumentException {
        if (!passwordValidation()) {
            throw new IllegalArgumentException(INVALIDPASSWORD);
        }

        if (!comparePasswords()) {
            throw new IllegalArgumentException(PASSWORDDOESNTMATCH);
        }

        this.username = username;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws IllegalArgumentException {
        if (!passwordValidation()) {
            throw new IllegalArgumentException();
        }

        this.password = password;
    }

    private boolean passwordValidation() {
        return password.length() >= 6;
    }

    private boolean comparePasswords() {
        return password.equals(verifyPassword);
    }
}
