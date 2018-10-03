package general;

public class User {
    public static final byte CLIENT = 0;
    public static final byte ADMIN = 1;

    private String username;
    private String password;
    private Byte role;

    public User(String username, String password, Byte role) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    private boolean roleValidation() {
        return role.equals(CLIENT) || role.equals(ADMIN);
    }

    private boolean passwordValidation() {
        return password.length() >= 6;
    }

}
