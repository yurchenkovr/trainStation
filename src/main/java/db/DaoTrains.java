package db;

import db.dao_exception.PersistException;
import db.general.Train;
import enums.Platform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DaoTrains extends Dao<Train, Integer> {

    public DaoTrains(Connection connection) {
        super(connection);
    }


    @Override
    public String getSelect() {
        return "SELECT * FROM trainstation.trains;";
    }

    @Override
    public String getCreate() {
        return "INSERT INTO trainstation.trains (TrainNumber, ArrivalTo, DepartureFrom," +
                " departureTime, arrivalTime, Platform) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

   /* @Override
    public String getLastCreated(){
        return "SELECT "
    }*/

    @Override
    public String getUpdate() {
        return "UPDATE trainstation.trains SET ArrivalTo = ?, DepartureFrom = ?," +
                "departureTime = ?, arrivalTime = ?, Platform = ?" +
                "WHERE TrainNumber = ?;";
    }

    @Override
    public String getDelete() {
        return "DELETE FROM trainstation.trains " +
                "WHERE TrainNumber = ?;";
    }

    @Override
    public String getFindByTrainNumber() {
        return "SELECT * FROM trainstation.trains WHERE TrainNumber = ?;";
    }

    @Override
    public Train create(Train train) throws PersistException {
        return  persist(train);
    }
    @Override
    public LinkedList<Train> parseToResult(ResultSet resultSet) {
        LinkedList<Train> list = new LinkedList<>();
        try {
            while (resultSet.next()) {
                Train train = new Train();
                train.setId(resultSet.getInt("TrainNumber"));
                train.setArrivalTo(resultSet.getString("ArrivalTo"));
                train.setDepartureFrom(resultSet.getString("DepartureFrom"));
                train.setDepartureTime(resultSet.getTimestamp("departureTime"));
                train.setArrivalTime(resultSet.getTimestamp("arrivalTime"));
                train.setTrainPlatform(Enum.valueOf(Platform.class, resultSet.getString("Platform").toUpperCase()));

                list.add(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void prepareForInsert(PreparedStatement ps, Train entity) {
        try {
            ps.setString(2, entity.getArrivalTo());
            ps.setString(3, entity.getDepartureFrom());
            ps.setTimestamp(4, entity.getDepartureTime());
            ps.setTimestamp(5, entity.getArrivalTime());
            ps.setString(6, entity.getTrainPlatform().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void prepareForUpdate(PreparedStatement ps, Train entity) {
        try {
            ps.setString(1, entity.getArrivalTo());
            ps.setString(2, entity.getDepartureFrom());
            ps.setTimestamp(3, entity.getDepartureTime());
            ps.setTimestamp(4, entity.getArrivalTime());
            ps.setString(5, entity.getTrainPlatform().toString());
            ps.setInt(6, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
