package DB;

import exceptions.TypeCarsException;
import general.TrainTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DaoTrainPrice extends Dao<TrainTicket, Integer> {
    public DaoTrainPrice(Connection conn) {
        super(conn);
    }

    @Override
    public String getSelect() {
        return "SELECT * FROM Prices;";
    }

    @Override
    public String getCreate() {
        return "INSERT INTO Prices ( TypeCar, Price )" +
                "VALUES (?, ?);";
    }

    @Override
    public String getUpdate() {
        return "UPDATE Prices SET TypeCar = ?, Price = ?, WHERE TrainNumber = ?;";
    }

    @Override
    public String getDelete() {
        return "DELETE FROM Prices WHERE TrainNumber = ?;";
    }

    @Override
    public String getFindByTrainNumber() {
        return "SELECT * FROM Prices WHERE TrainNumber = ?;";
    }

    @Override
    public LinkedList<TrainTicket> parseToResult(ResultSet resultSet) {
        LinkedList<TrainTicket> trainTickets = new LinkedList<>();

        try {
            while (resultSet.next()) {
                TrainTicket tickets = new TrainTicket();
                tickets.setId(resultSet.getInt(1));
                tickets.setTypeCars(resultSet.getString(2));
                tickets.setPrice(resultSet.getInt(3));
                trainTickets.add(tickets);
            }
        } catch (SQLException | TypeCarsException e) {
            e.printStackTrace();
        }
        return trainTickets;
    }

    @Override
    public void prepareForInsert(PreparedStatement ps, TrainTicket entity) {
        try {
            ps.setString(1, entity.getTCars());
            ps.setInt(2, entity.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForUpdate(PreparedStatement ps, TrainTicket entity) {
        try{
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getTCars());
            ps.setInt(3,entity.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
