package general;

public class User {
    public static final byte CLIENT = 0;
    public static final byte ADMIN = 1;
    public static final String INVALIDPASSWORD = "Password must be more than 5 chars";

    private Integer id;
    private String username;
    private String password;
    private Byte role;

    public User(String username, String password, Byte role) throws IllegalArgumentException {
        if (!roleValidation() || !passwordValidation()) {
            throw new IllegalArgumentException();
        }

        this.username = username;
        this.password = password;
        this.role = role;
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
            throw new IllegalArgumentException(INVALIDPASSWORD);
        }

        this.password = password;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) throws IllegalArgumentException {
        if (!roleValidation()) {
            throw new IllegalArgumentException();
        }

        this.role = role;
    }

    public Integer getID() {
        return id;
    }

    private boolean roleValidation() {
        return role.equals(CLIENT) || role.equals(ADMIN);
    }

    private boolean passwordValidation() {
        return password.length() >= 6;
    }

}
