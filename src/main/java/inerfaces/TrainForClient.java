package inerfaces;

import java.sql.ResultSet;

public interface TrainForClient {
    ResultSet checkSchedule();
    ResultSet findTrainForNumber();
    ResultSet sortTrainsByNumber();

}
