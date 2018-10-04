package services;

import DB.DaoFactory;
import DB.general.TrainTicket;
import exceptions.PersistException;
import inerfaces.GenericDao;
import sun.security.krb5.internal.Ticket;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class PriceController {

    private Connection connection;
    private GenericDao dao;

    public PriceController(DaoFactory daoFactory) throws PersistException, IOException {
        this.dao = daoFactory.getDao(daoFactory.getContext(), DB.general.TrainTicket.class);
    }

    public List<TrainTicket> getAll() throws PersistException {
        return dao.getAll();
    }

    public void update(TrainTicket t1) throws PersistException {
        dao.update(t1);
    }

    public void delete(Integer t2) throws PersistException {
        dao.delete(t2);
    }

    public void create(TrainTicket trainTicket) throws PersistException {
        TrainTicket t1 = (TrainTicket) dao.create(trainTicket);
    }
/*
    public ObservableList<FlightPrice> find(FlightPrice object) throws PersistException {
        ObservableList<FlightPrice> result = dao.getBy(object);
        return result;
    }*/

}
