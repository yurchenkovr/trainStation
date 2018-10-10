package db;

import db.dao_exception.PersistException;
import db.general.TrainTicket;
import enums.TypeCars;
import exceptions.TypeCarsException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class DaoTrainTicket extends Dao<TrainTicket, Integer> {
    public DaoTrainTicket(Connection conn) {
        super(conn);
    }

    @Override
    public String getSelect() {
        return "SELECT * FROM prices;";
    }

    @Override
    public String getCreate() {
        return "INSERT INTO prices ( TypeCar, Price ) " +
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
        LinkedList<TrainTicket> ticket = new LinkedList<>();
            while (resultSet.next()) {
                TrainTicket t = new TrainTicket();
                t.setId(resultSet.getInt("TrainNumber"));
                t.setTypeCar(Enum.valueOf(TypeCars.class, resultSet.getString("TypeCar")));
                t.setPrice(resultSet.getInt("price"));
                ticket.addAll((Collection<? extends TrainTicket>) t);
            }
        return ticket;
    }

    @Override
    public void prepareForInsert(PreparedStatement ps, TrainTicket entity) throws PersistException {
        try {
            ps.setString(1, entity.getTypeCars().toString());
            ps.setInt(2, entity.getPrice());
        } catch (Exception e) {
            throw new PersistException();
        }
    }

    @Override
    public void prepareForUpdate(PreparedStatement ps, TrainTicket entity) throws PersistException {
        try{
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getTypeCars().toString());
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
