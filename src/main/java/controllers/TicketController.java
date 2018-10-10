package controllers;

import db.DaoFactory;
import db.dao_exception.PersistException;
import services.TicketService;
import services.modelsUI.TrainTicket;

import java.io.IOException;
import java.util.LinkedList;

public class TicketController {
    DaoFactory factory;
    TicketService ticketService;

    public TicketController() {
        try {
            factory = new DaoFactory();
            ticketService = new TicketService(factory);
        } catch (IOException | PersistException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public LinkedList<TrainTicket> getAll() throws PersistException {
        return ticketService.getAll();
    }
    public void updateTrainTicket(TrainTicket ticketUI) throws PersistException {
        ticketService.updateTrainTicket(ticketUI);
    }
    public void deleteTrainTicket(Integer ticket) throws PersistException {
        ticketService.deleteTrainTicket(ticket);
    }
    public void createTrainTicket(TrainTicket trainTicketUI) throws PersistException {
        ticketService.createTrainTicket(trainTicketUI);
    }
    public void buyTicket(TrainTicket trainTicket) {
        ticketService.buyTicket(trainTicket);
    }
    public TrainTicket getTicket(Integer tNumber) throws PersistException {
        return ticketService.getTicket(tNumber);
    }

}
