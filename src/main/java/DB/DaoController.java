package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class DaoController<T, PK> {
    private Connection connection;
    private final String URL = "jdbc:mysql://jdbcStation/TrainStation?useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "vitmantekoR_2408";

    public DaoController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract List<T> getAll();

    public abstract T getByID(Integer tN);

    public abstract void update(T entity);

    public abstract void delete(Integer id);

    public abstract void create(T entity);

    public Connection getConnection() {
        return connection;
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
