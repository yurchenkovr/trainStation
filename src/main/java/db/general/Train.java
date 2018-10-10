package db.general;

import db.interfaces.Identified;
import enums.Platform;
import exceptions.PlatformException;
import java.sql.Timestamp;


public class Train implements Identified<Integer> {
    private int TrainNumber;
    private String DepartureFrom;
    private String ArrivalTo;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private Platform trainPlatform;


    public Train() {
    }

    public Train(int trainNumber, String departureFrom, String arrivalTo, Timestamp arrivalTime,
                 Timestamp departureTime, Platform trainPlatform) {
        TrainNumber = trainNumber;
        DepartureFrom = departureFrom;
        ArrivalTo = arrivalTo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.trainPlatform = trainPlatform;
    }

    @Override
    public Integer getId() {
        return TrainNumber;
    }

    public void setId(int id) {
        this.TrainNumber = id;
    }


  /*  public int getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(int TrainNumber) {
        this.TrainNumber = TrainNumber;
    }
*/
    public String getDepartureFrom() {
        return DepartureFrom;
    }

    public void setDepartureFrom(String DepartureFrom) {
        this.DepartureFrom = DepartureFrom;
    }

    public String getArrivalTo() {
        return ArrivalTo;
    }

    public void setArrivalTo(String ArrivalTo) {
        this.ArrivalTo = ArrivalTo;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Platform getTrainPlatform() {
        return trainPlatform;
    }

    public void setTrainPlatform(Platform trainPlatform) {
        this.trainPlatform = trainPlatform;
    }
//    public String getTPlatform() {
//        return getTrainPlatform().getAbbr();
//    }

//    public void setTrainPlatform(String trainPlatform) throws PlatformException {
//        Platform tPlatform = PlatformSTEnum(trainPlatform);
//        this.trainPlatform = tPlatform;
//    }


    @Override
    public String toString() {
        return "db.general.Train{" +
                "  TrainNumber=" + TrainNumber +
                ", DepartureFrom='" + DepartureFrom + '\'' +
                ", ArrivalTo='" + ArrivalTo + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", trainPlatform=" + trainPlatform +
                '}';
    }

//    private Platform PlatformSTEnum(String platform) throws PlatformException {
//        switch (platform) {
//            case "A":
//                return Platform.A;
//            case "B":
//                return Platform.B;
//            case "C":
//                return Platform.C;
//            case "D":
//                return Platform.D;
//            default:
//                throw new PlatformException("Wrong Platform!");
//        }
//    }
}
