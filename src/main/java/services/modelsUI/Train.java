package services.modelsUI;

import enums.Platform;

import java.sql.Timestamp;

public class Train {

    private int TrainNumber;
    private String DepartureFrom;
    private String ArrivalTo;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private Platform trainPlatform;

    public int getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        TrainNumber = trainNumber;
    }

    public String getDepartureFrom() {
        return DepartureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        DepartureFrom = departureFrom;
    }

    public String getArrivalTo() {
        return ArrivalTo;
    }

    public void setArrivalTo(String arrivalTo) {
        ArrivalTo = arrivalTo;
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

    public Train(int trainNumber, String departureFrom, String arrivalTo, Timestamp arrivalTime,
                 Timestamp departureTime, Platform trainPlatform) {
        TrainNumber = trainNumber;
        DepartureFrom = departureFrom;
        ArrivalTo = arrivalTo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.trainPlatform = trainPlatform;
    }

    public Train(String departureFrom, String arrivalTo, Timestamp arrivalTime, Timestamp departureTime, Platform trainPlatform) {
        DepartureFrom = departureFrom;
        ArrivalTo = arrivalTo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.trainPlatform = trainPlatform;
    }

    @Override
    public String toString() {
        return "Train{" +
                "TrainNumber=" + TrainNumber +
                ", DepartureFrom='" + DepartureFrom + '\'' +
                ", ArrivalTo='" + ArrivalTo + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", trainPlatform=" + trainPlatform +
                '}';
    }
}
