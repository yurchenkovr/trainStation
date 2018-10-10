package controllers;

import db.DaoFactory;
import db.dao_exception.PersistException;
import services.UserService;
import services.modelsUI.User;

import java.io.IOException;
import java.util.List;

public class UserController {
    DaoFactory factory;
    UserService userService;

    public UserController() {
        try {
            factory = new DaoFactory();
            userService = new UserService(factory);
        } catch (IOException | PersistException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public boolean createUser(String username, String password, String verifyPassword) throws PersistException {
        return userService.createUser(username, password, verifyPassword);
    }
    public User getUser(Integer id) throws PersistException {
        return userService.getUser(id);
    }
    public void delete(Integer id ) throws PersistException {
        userService.delete(id);
    }
    public List<User> getAll() throws PersistException {
        return userService.getAll();
    }
    public boolean changePassword(Integer id, String oldPassword, String newPassword) throws PersistException {
        return userService.changePassword(id,oldPassword,newPassword);
    }
    public boolean loginUser (String username, String password) throws PersistException {
        return userService.loginUser(username,password);
    }
}
