package services;

import DB.DaoFactory;
import inerfaces.GenericDao;
import services.modelsUI.User;

import java.util.LinkedList;

public class UserService {
    private GenericDao dao;

    public UserService(DaoFactory daoFactory) {
        this.dao = daoFactory.getDao(daoFactory.getContext(), general.User.class);
    }

    public boolean createUser(String username, String password, String verifyPassword) {
        User userUI;
        try {
            userUI = new User(username, password, verifyPassword);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

        general.User user = convertUserUIToUser(userUI);

        dao.create(user);
        return true;
    }

    public User getUser(Integer id) {
        return convertUserToUserUI((general.User) dao.getByID(id));
    }

    public LinkedList<User> getAll() {
        return (LinkedList<User>) dao.getAll();
    }

    public void delete(Integer id) {
        dao.delete(id);
    }

    public boolean changePassword(Integer id, String oldPassword, String newPassword) {
        general.User user = (general.User) dao.getByID(id);
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

    private general.User convertUserUIToUser(User userUI) {
        return new general.User(userUI.getUsername(), userUI.getPassword(), general.User.CLIENT);
    }

    private User convertUserToUserUI(general.User user) {
        return new User(user.getUsername(), user.getPassword(), user.getId());
    }
}