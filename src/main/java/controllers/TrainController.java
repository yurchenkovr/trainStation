package controllers;

import db.DaoFactory;
import db.dao_exception.PersistException;
import services.TrainService;
import services.modelsUI.Train;

import java.io.IOException;
import java.util.List;

public class TrainController {
    DaoFactory factory;
    TrainService trainService;

    public TrainController() {
        try{
            factory = new DaoFactory();
            trainService = new TrainService(factory);
        }catch (IOException | PersistException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public List<Train> getAll() throws PersistException {
        return trainService.getAll();
    }
    public void updateTrain(Train trainUI) throws PersistException {
        trainService.updateTrain(trainUI);
    }
    public void deleteTrain(Integer tNumber) throws PersistException {
        trainService.deleteTrain(tNumber);
    }
    public void createTrain(Train trainUI) throws PersistException {
        trainService.createTrain(trainUI);
    }
    public Train getTrain(Integer tNumber) throws PersistException {
        return trainService.getTrain(tNumber);
    }
}
