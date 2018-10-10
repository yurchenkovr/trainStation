package services;

import db.DaoFactory;
import db.dao_exception.PersistException;
import db.interfaces.GenericDao;
import services.modelsUI.User;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UserService {
    private GenericDao dao;

    @Override
    public int hashCode() {

        return Objects.hash(dao);
    }

    public UserService(DaoFactory daoFactory) throws IOException, PersistException {
        this.dao = daoFactory.getDao(daoFactory.getContext(), db.general.User.class);
    }

    public boolean loginUser(String username, String password) throws PersistException {
        if (getUserByUsername(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean createUser(String username, String password, String verifyPassword) throws PersistException {
        User userUI;
        try {
            userUI = new User(username, password, verifyPassword);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

        db.general.User user = convertUserUIToUser(userUI);

        dao.create(user);
        return true;
    }

    public User getUserByUsername(String username) throws PersistException {
        return convertUserToUserUI((db.general.User) dao.getByUserName(username));
    }

    public User getUser(Integer id) throws PersistException {
        return convertUserToUserUI((db.general.User) dao.getByID(id));
    }

    public List<User> getAll() throws PersistException {
        LinkedList<db.general.User> users = dao.getAll();
        LinkedList<User> result = new LinkedList<>();
        for (db.general.User e : users) {
            result.add(convertUserToUserUI(e));
        }
        return result;
    }

    public void delete(Integer id) throws PersistException {
        dao.delete(id);
    }

    public boolean changePassword(Integer id, String oldPassword, String newPassword) throws PersistException {
        db.general.User user = (db.general.User) dao.getByID(id);
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

    private db.general.User convertUserUIToUser(User userUI) {
        return new db.general.User(userUI.getUsername(), userUI.getPassword(), db.general.User.CLIENT);
    }

    private User convertUserToUserUI(db.general.User user) {
        return new User(user.getUsername(), user.getPassword(), user.getId());
    }
}