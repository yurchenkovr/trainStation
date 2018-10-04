package DB;

import general.Train;
import general.TrainTicket;
import general.User;
import inerfaces.DaoFactoryInterface;
import exceptions.PersistException;
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
    private Map<Class, DaoCreator> creators;


    @Override
    public Connection getContext() throws PersistException, IOException {
        connection = null;
        try {
            connection = DriverManager.getConnection(url, login, password);
            PreparedStatement ps = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS `trainstation`;");

            ScriptRunner runner = new ScriptRunner(connection, false, false);
            runner.runScript(new BufferedReader(new FileReader("src/main/resources/createDBandTables")));

            connection = DriverManager.getConnection(url + "/TrainStation?useSSL=false", login, password);
            GenericDao genericDao = getDao(connection, User.class);

            if (genericDao.getAll().size() == 0 || genericDao.getAll().size() == -1) {
                runner.runScript(new BufferedReader(new FileReader("src/main/resources/addSomeData")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws PersistException{
        DaoCreator creator = creators.get(dtoClass);

        if(creator == null){
            throw new PersistException("Dao object for " + dtoClass + " not found.");
            }
        return creator.create(connection);
    }

    public DaoFactory() throws IOException {
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

        creators = new HashMap<>();

        creators.put(User.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new DaoUsers(connection);
            }
        });

        creators.put(Train.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new DaoTrains(connection);
            }
        });

        creators.put(TrainTicket.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                //TODO Add DaoTrainTicket and replace here from DaoTrains to DaoTrainTicket
                return new DaoTrains(connection);
            }
        });

    }
}
