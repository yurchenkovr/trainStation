package DB;

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

    public abstract LinkedList<T> parseToResult(ResultSet resultSet);

    public abstract void prepareForInsert(PreparedStatement ps, T entity);

    public abstract void prepareForUpdate(PreparedStatement ps, T entity);

    @Override
    public List<T> getAll() {
        LinkedList<T> trains = new LinkedList<>();
        String query = getSelect();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            trains.addAll(parseToResult(resultSet));
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    @Override
    public T getByID(Integer tN) {
        LinkedList<T> train = new LinkedList<>();
        String query = getFindByTrainNumber();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, tN);
            ResultSet resultSet = ps.executeQuery();
            train.addAll(parseToResult(resultSet));
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return train.iterator().next();
    }

    @Override
    public void update(T entity) {
        String query = getUpdate();

        try{
            conn.setAutoCommit(true);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            prepareForUpdate(ps, entity);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String query = getDelete();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    }
}
