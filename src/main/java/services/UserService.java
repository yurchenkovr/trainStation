package services;

import DB.DaoFactory;
import exceptions.PersistException;
import inerfaces.GenericDao;
import services.modelsUI.User;

import java.io.IOException;
import java.util.LinkedList;

public class UserService {
    private GenericDao dao;

    public UserService(DaoFactory daoFactory) throws IOException, PersistException {
        this.dao = daoFactory.getDao(daoFactory.getContext(), DB.general.User.class);
    }

    public boolean createUser(String username, String password, String verifyPassword) throws PersistException {
        User userUI;
        try {
            userUI = new User(username, password, verifyPassword);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

        DB.general.User user = convertUserUIToUser(userUI);

        dao.create(user);
        return true;
    }

    public User getUser(Integer id) throws PersistException {
        return convertUserToUserUI((DB.general.User) dao.getByID(id));
    }

    public LinkedList<User> getAll() throws PersistException {
       LinkedList<DB.general.User> users = (LinkedList<DB.general.User>) dao.getAll();
       LinkedList<User> result = new LinkedList<User>();
       for (DB.general.User e : users) {
            result.add(convertUserToUserUI(e));
        }

        return result;
    }

    public void delete(Integer id) throws PersistException {
        dao.delete(id);
    }

    public boolean changePassword(Integer id, String oldPassword, String newPassword) throws PersistException {
        DB.general.User user = (DB.general.User) dao.getByID(id);
        if (!user.getPassword().equals(oldPassword)) {
            return false;
        }

        try {
            user.setPassword(newPassword);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

        dao.update(user);
        return true;
    }

    private DB.general.User convertUserUIToUser(User userUI) {
        return new DB.general.User(userUI.getUsername(), userUI.getPassword(), DB.general.User.CLIENT);
    }

    private User convertUserToUserUI(DB.general.User user) {
        return new User(user.getUsername(), user.getPassword(), user.getId());
    }
}