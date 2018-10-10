package services.modelsUI;

public class User {
    private Integer id;
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

    public User(String username, String password, Integer id) throws IllegalArgumentException {
        this.username = username;
        this.password = password;
        this.verifyPassword = password;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private boolean passwordValidation() {
        return password.length() >= 6;
    }

    private boolean comparePasswords() {
        return password.equals(verifyPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifyPassword='" + verifyPassword + '\'' +
                '}';
    }
}
