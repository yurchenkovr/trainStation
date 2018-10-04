package services;

import DB.DaoFactory;
import DB.general.Train;
import exceptions.PersistException;
import inerfaces.GenericDao;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TrainService {
    private GenericDao dao;

    public TrainService(DaoFactory daoFactory) throws IOException, PersistException {
        this.dao = daoFactory.getDao(daoFactory.getContext(), DB.general.Train.class);
    }

    public List<Train> getAll() throws PersistException {
        return dao.getAll();
    }
    public void update(Train train) throws PersistException {
        dao.update(train);
    }
    public void delete(Integer tNumber) throws PersistException {
        dao.delete(tNumber);
    }
    public void create(Train train) throws PersistException {
        Train ft = (Train) dao.create(train);
    }

    public LinkedList<Train> find(Integer tNumber) throws PersistException {
        LinkedList<Train> res = (LinkedList<Train>) dao.getByID(tNumber);
        return res;
    }
}
