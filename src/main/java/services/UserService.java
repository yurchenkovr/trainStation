package services;

import DB.DaoFactory;
import inerfaces.GenericDao;
import services.modelsUI.User;

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

    private general.User convertUserUIToUser(User userUI) {
        return new general.User(userUI.getUsername(), userUI.getPassword(), general.User.CLIENT);
    }

    private User convertUserToUserUI(general.User user) {
        return new User(user.getUsername(), user.getPassword(), user.getId());
    }
}