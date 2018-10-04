package services;

import DB.DaoFactory;
import inerfaces.GenericDao;
import services.modelsUI.User;

public class UserService {
    private GenericDao dao;

    public UserService(DaoFactory daoFactory) {
        this.dao = daoFactory.getDao(daoFactory.getContext(), general.User.class);
    }

    public boolean CreateUser(String username, String password, String verifyPassword) {
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

    private general.User convertUserUIToUser(User userUI) {
        return new general.User(userUI.getUsername(), userUI.getPassword(), general.User.CLIENT);
    }
}