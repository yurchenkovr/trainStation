package DB;

import general.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DaoUsers extends Dao<User, Integer> {

    public DaoUsers(Connection connection) {
        super(connection);
    }


    @Override
    public String getSelect() {
        return "SELECT * FROM trainstation.users";
    }

    @Override
    public String getCreate() {
        return "INSERT INTO trainstation.users (id, username, password," +
                " role) VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdate() {
        return "UPDATE trainstation.users SET username = ?," +
                "password = ?, role = ?, WHERE id = ?;";
    }

    @Override
    public String getDelete() {
        return "DELETE FROM trainstation.users " +
                "WHERE id = ?;";
    }

    @Override
    public String getFindByTrainNumber() {
        return "SELECT * FROM trainstation.users WHERE TrainNumber = ?";
    }

    @Override
    public LinkedList<User> parseToResult(ResultSet resultSet) {
        LinkedList<User> list = new LinkedList<>();
        try {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getByte("role")
                );
                list.add(user);
            }
        } catch (SQLException | IllegalArgumentException e ) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void prepareForInsert(PreparedStatement ps, User entity) {
        try {
            ps.setInt(1, entity.getID());
            ps.setString(2, entity.getUsername());
            ps.setString(3, entity.getPassword());
            ps.setByte(4, entity.getRole());
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForUpdate(PreparedStatement ps, User entity) {
        try {
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());
            ps.setByte(3, entity.getRole());
            ps.setInt(4, entity.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForFind(PreparedStatement ps, User entity) {
        try {
            ps.setInt(1, entity.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}