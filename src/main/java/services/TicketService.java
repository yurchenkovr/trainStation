package services;

import db.DaoFactory;
import db.dao_exception.PersistException;
import db.interfaces.GenericDao;
import services.modelsUI.TrainTicket;

import java.io.IOException;
import java.sql.Connection;
import java.util.LinkedList;
public class TicketService {

    private Connection connection;
    private GenericDao dao;

    public TicketService(DaoFactory daoFactory) throws PersistException, IOException {
        this.dao = daoFactory.getDao(daoFactory.getContext(), db.general.TrainTicket.class);
    }

    public LinkedList<TrainTicket> getAll() throws PersistException {
       LinkedList<db.general.TrainTicket> tickets = dao.getAll();
       LinkedList<TrainTicket> result = dao.getAll();
       for(db.general.TrainTicket e : tickets) {
           result.add(convertTrainTicketToTrainTicketUI(e));
       }
       return result;
    }

    public void updateTrainTicket(TrainTicket ticketUI) throws PersistException {
        db.general.TrainTicket result = convertTrainTicketUIToTrainTicket(ticketUI);
        dao.update(result);
    }

    public void deleteTrainTicket(Integer ticket) throws PersistException {
        dao.delete(ticket);
    }

    public void createTrainTicket(TrainTicket trainTicketUI) throws PersistException {
        db.general.TrainTicket ticket = convertTrainTicketUIToTrainTicket(trainTicketUI);
        dao.create(ticket);
    }

    public TrainTicket getTicket(Integer tNumber) throws PersistException {
        return convertTrainTicketToTrainTicketUI((db.general.TrainTicket)dao.getByID(tNumber));
    }
    public void buyTicket(TrainTicket trainTicket){
        System.out.println("Thank you for using our services!\n" +
                 "\nTypeCar: " + trainTicket.getTypeCars() + "Price: " + trainTicket.getPrice());
    }
/*
    public ObservableList<FlightPrice> find(FlightPrice object) throws PersistException {
        ObservableList<FlightPrice> result = dao.getBy(object);
        return result;
    }*/
    private db.general.TrainTicket convertTrainTicketUIToTrainTicket(TrainTicket trainTicketUI){
        return new db.general.TrainTicket(trainTicketUI.getTypeCars(),trainTicketUI.getPrice());
    }
    private TrainTicket convertTrainTicketToTrainTicketUI(db.general.TrainTicket trainTicket){
        return new TrainTicket(trainTicket.getTypeCars(),trainTicket.getPrice());
    }
}
