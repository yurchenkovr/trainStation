package db.general;

import db.interfaces.Identified;

public class User implements Identified<Integer> {
    public static final Integer CLIENT = 0;
    public static final Integer ADMIN = 1;
    public static final String INVALIDPASSWORD = "Password must be more than 5 chars";

    private Integer id;
    private String username;
    private String password;
    private Integer role;

    public User(String username, String password, Integer role) throws IllegalArgumentException {
        this.username = username;
        this.password = password;
        this.role = role;

        if (!roleValidation() || !passwordValidation()) {

            throw new IllegalArgumentException();
        }
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) throws IllegalArgumentException {
        if (!roleValidation()) {
            throw new IllegalArgumentException();
        }

        this.role = role;
    }

    @Override
    public Integer getId() {
        return id;
    }

    private boolean roleValidation() {

        return role.equals(CLIENT) || role.equals(ADMIN);
    }

    private boolean passwordValidation() {
        return password.length() >= 6;
    }

}
