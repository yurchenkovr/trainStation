package services;

import DB.DaoController;
import DB.DaoUsers;
import services.modelsUI.User;

public class UserService {
    private DaoController daoController;

    public UserService(DaoController daoController) {
     //   this.daoController = daoController.ge
    }

    public String CreateUser(String username, String password, String verifyPassword) {
        try {
            User user = new User(username, password, verifyPassword);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "Can't create user, " + e.getMessage();
        }


    }


}
