package services;

import db.DaoFactory;
import db.dao_exception.PersistException;
import db.interfaces.GenericDao;
import services.modelsUI.Train;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TrainService {
    private GenericDao dao;

    public TrainService(DaoFactory daoFactory) throws IOException, PersistException {
        this.dao = daoFactory.getDao(daoFactory.getContext(), db.general.Train.class);
    }

    public List<Train> getAll() throws PersistException {
        LinkedList<db.general.Train> trains =  dao.getAll();
        LinkedList<Train> result = new LinkedList<>();
        for(db.general.Train e: trains) {
            result.add(convertTrainToTrainUI(e));
        }
        return result;
    }
    public void updateTrain(Train trainUI) throws PersistException {
        db.general.Train result = convertTrainUIToTrain(trainUI);
        dao.update(result);
    }
    public void deleteTrain(Integer tNumber) throws PersistException {
        dao.delete(tNumber);
    }
    public void createTrain(Train trainUI) throws PersistException {
        db.general.Train train = convertTrainUIToTrain(trainUI);
        dao.create(train);
    }

    public Train getTrain(Integer tNumber) throws PersistException {
        return convertTrainToTrainUI((db.general.Train)dao.getByID(tNumber));
    }

    private db.general.Train convertTrainUIToTrain(Train trainUI) {
        return new db.general.Train(trainUI.getTrainNumber(),trainUI.getDepartureFrom(),trainUI.getArrivalTo(),
                trainUI.getArrivalTime(),trainUI.getDepartureTime(),trainUI.getTrainPlatform());
    }

    private Train convertTrainToTrainUI(db.general.Train train) {
        return new Train(train.getId(),train.getDepartureFrom(),train.getArrivalTo(),
                train.getArrivalTime(),train.getDepartureTime(),train.getTrainPlatform());
    }
}
