package DB;

import exceptions.PlatformException;
import DB.general.Train;

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
        return "SELECT * FROM trainstation.trains";
    }

    @Override
    public String getCreate() {
        return "INSERT INTO trainstation.trains (TrainNumber, ArrivalTo, DepartureFrom," +
                " departureTime, arrivalTime, Platform) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
    }

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
        return "SELECT * FROM trainstation.trains WHERE TrainNumber = ?";
    }



    @Override
    public Train create(Train train){
        return  persist(train);
    }
    @Override
    public LinkedList<Train> parseToResult(ResultSet resultSet) {
        LinkedList<Train> list = new LinkedList<>();
        try {
            while (resultSet.next()) {
                Train train = new Train();
                train.setId(resultSet.getInt(1));
                train.setArrivalTo(resultSet.getString(2));
                train.setDepartureFrom(resultSet.getString(3));
                train.setdepartureTime(resultSet.getTime(4));
                train.setarrivalTime(resultSet.getTime(5));
                train.setTrainPlatform(resultSet.getString(6));
                list.add(train);
            }
        } catch (SQLException | PlatformException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void prepareForInsert(PreparedStatement ps, Train entity) {
        try {
            ps.setString(2, entity.getArrivalTo());
            ps.setString(3, entity.getDepartureFrom());
            ps.setTime(4, entity.getdepartureTime());
            ps.setTime(5, entity.getarrivalTime());
            ps.setString(6, entity.getTPlatform());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareForUpdate(PreparedStatement ps, Train entity) {
        try {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getArrivalTo());
            ps.setString(3, entity.getDepartureFrom());
            ps.setTime(4, entity.getdepartureTime());
            ps.setTime(5, entity.getarrivalTime());
            ps.setString(6, entity.getTPlatform());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
