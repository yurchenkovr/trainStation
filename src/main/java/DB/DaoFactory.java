package DB;

import general.User;
import inerfaces.DaoFactoryInterface;
import inerfaces.GenericDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoFactory implements DaoFactoryInterface<Connection> {

    private String login;
    private String password;
    private String url;
    private String driver;
    private Connection connection = null;
    private Map<Class, DaoCreator> creators = new HashMap<>();


    @Override
    public Connection getContext() {
        connection = null;
        try {
            connection = DriverManager.getConnection(url, login, password);
            PreparedStatement ps = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS `trainstation`;");

            ScriptRunner runner = new ScriptRunner(connection, false, false);
            runner.runScript(new BufferedReader(new FileReader("src/main/resources/createDBandTables")));

            connection = DriverManager.getConnection(url, login, password);
            GenericDao genericDao = getDao(connection, User.class);

            if (genericDao.getAll().size() == 0 || genericDao.getAll().size() == -1) {
                runner.runScript(new BufferedReader(new FileReader("src/main/resources/addSomeData")));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) {
        DaoCreator creator = creators.get(dtoClass);
        return creator.create(connection);
    }

    public DaoFactory() {
        Configs configs = new Configs();
        ArrayList<String> properties = configs.getProperties();
        url = properties.get(0);
        login = properties.get(1);
        password = properties.get(2);
        driver = properties.get(3);

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
