package DB;

import exceptions.PersistException;
import exceptions.TypeCarsException;
import DB.general.TrainTicket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DaoTrainTicket extends Dao<TrainTicket, Integer> {
    public DaoTrainTicket(Connection conn) {
        super(conn);
    }
    private class PersistTrainPrice extends TrainTicket {
        @Override
        protected void setId(int id){
            super.setId(id);
        }
    }


    @Override
    public String getSelect() {
        return "SELECT * FROM prices;";
    }

    @Override
    public String getCreate() {
        return "INSERT INTO prices ( TypeCar, Price )" +
                "VALUES (?, ?);";
    }

    @Override
    public String getUpdate() {
        return "UPDATE prices SET TypeCar = ?, Price = ?, WHERE TrainNumber = ?;";
    }

    @Override
    public String getDelete() {
        return "DELETE FROM prices WHERE TrainNumber = ?;";
    }

    @Override
    public String getFindByTrainNumber() {
        return "SELECT * FROM prices WHERE TrainNumber = ?;";
    }

    @Override
    public LinkedList<TrainTicket> parseToResult(ResultSet resultSet) throws SQLException, TypeCarsException {
        LinkedList<TrainTicket> trainTickets = new LinkedList<>();
            while (resultSet.next()) {
                PersistTrainPrice tp = new PersistTrainPrice();
                tp.setId(resultSet.getInt(1));
                tp.setTypeCars(resultSet.getString(2));
                tp.setPrice(resultSet.getInt(3));
                trainTickets.addAll(tp);
            }
        return trainTickets;
    }

    @Override
    public void prepareForInsert(PreparedStatement ps, TrainTicket entity) throws PersistException {
        try {
            ps.setString(1, entity.getTCars());
            ps.setInt(2, entity.getPrice());
        } catch (Exception e) {
            throw new PersistException();
        }
    }

    @Override
    public void prepareForUpdate(PreparedStatement ps, TrainTicket entity) throws PersistException {
        try{
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getTCars());
            ps.setInt(3,entity.getPrice());
        } catch (Exception e) {
            throw new PersistException();
        }
    }

    @Override
    public TrainTicket create(TrainTicket entity) throws PersistException {
        TrainTicket tt = entity;
        return persist(tt);
    }
}
