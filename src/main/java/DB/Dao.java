package DB;

import exceptions.PersistException;
import DB.general.Train;
import exceptions.TypeCarsException;
import inerfaces.GenericDao;
import inerfaces.Identified;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class Dao<T extends Identified<PK>, PK extends Integer> implements GenericDao<T, PK> {
    private Connection conn;

    public Dao(Connection conn) {
        this.conn = conn;
    }

    public abstract String getSelect();

    public abstract String getCreate();

    public abstract String getUpdate();

    public abstract String getDelete();

    public abstract String getFindByTrainNumber();

    public abstract LinkedList<T> parseToResult(ResultSet resultSet) throws SQLException, PersistException, TypeCarsException;

    public abstract void prepareForInsert(PreparedStatement ps, T entity) throws PersistException;

    public abstract void prepareForUpdate(PreparedStatement ps, T entity) throws PersistException;

    @Override
    public List<T> getAll() throws PersistException {
        LinkedList<T> trains = new LinkedList<>();
        String query = getSelect();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            trains.addAll(parseToResult(resultSet));
            ps.close();
        } catch (Exception e) {
            throw new PersistException();
        }
        return trains;
    }

    @Override
    public T getByID(Integer key) throws PersistException {
        LinkedList<T> train = new LinkedList<>();
        String query = getFindByTrainNumber();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, key);
            ResultSet resultSet = ps.executeQuery();
            train.addAll(parseToResult(resultSet));
            ps.close();
        } catch (Exception e) {
            throw new PersistException();
        }
        return train.iterator().next();
    }

    @Override
    public void update(T entity) throws PersistException {
        String query = getUpdate();

        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            prepareForUpdate(ps, entity);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            throw new PersistException();
        }
    }

    @Override
    public void delete(Integer key) throws PersistException {
        String query = getDelete();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            try {
                ps.setInt(1, key);
            } catch (Exception e) {
                throw new PersistException();
            }
            int count = ps.executeUpdate();
            if (count != 1) {
                throw new PersistException("On delete more than 1 record + " + count);
            }
            ps.close();
        } catch (Exception e) {
            throw new PersistException();
        }
    }

    /*
        @Override
        public void create(T entity) {
            String query = getCreate();

            try {
                PreparedStatement ps = conn.prepareStatement(query);
                prepareForInsert(ps, entity);
                ps.execute();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    @Override
    public T persist(T object) throws PersistException {
        T persistInstance;
        // Adding Entry
        String query = getCreate();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            prepareForInsert(ps, object);
            int count = ps.executeUpdate();
            if (count != 1) {
                throw new PersistException("One persist modify more than 1 record " + count);
            }
        } catch (Exception e) {
            throw new PersistException();
        }
        // We get the newly inserted record
        if (object.getClass() == Train.class) {
            query = "SELECT * FROM trains WHERE TrainNumber = LAST_INSERT_TrainNumber();";
        } else {
            query = getSelect();
        }
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<T> list = parseToResult(rs);
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new PersistException();
        }
        return persistInstance;
    }
}
