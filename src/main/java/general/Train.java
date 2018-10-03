package general;

import enums.Platform;
import enums.TrainCars;
import exceptions.PlatformException;

import java.sql.Time;

public  class  Train {
    private int id;
    private int TrainNumber;
    private String DepartureFrom;
    private String ArrivalTo;
    private Time arrivalTime;
    private Time departureTime;
    private Platform trainPlatform;
    private int trainPlacesInCar;
    private TrainCars trainCars;

    public Train() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TrainCars getTrainCars() {
        return trainCars;
    }

    public void setTrainCars(TrainCars trainCars) {
        this.trainCars = trainCars;
    }

    public int getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(int TrainNumber) {
        this.TrainNumber = TrainNumber;
    }

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

    public Time getarrivalTime() {
        return arrivalTime;
    }

    public void setarrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getdepartureTime() {
        return departureTime;
    }

    public void setdepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Platform getTrainPlatform() {
        return trainPlatform;
    }
    public String getTPlatform(){
        return getTrainPlatform().getAbbr();
    }

    public void setTrainPlatform(String trainPlatform) throws  PlatformException{
        Platform tPlatform = PlatformSTEnum(trainPlatform);
        this.trainPlatform = tPlatform;
    }

    public int getTrainPlacesInCar() {
        return trainPlacesInCar;
    }

    public void setTrainPlacesInCar(int trainPlacesInCar) {
        this.trainPlacesInCar = trainPlacesInCar;
    }

    @Override
    public String toString() {
        return "general.Train{" +
                "id=" + id +
                ", TrainNumber=" + TrainNumber +
                ", DepartureFrom='" + DepartureFrom + '\'' +
                ", ArrivalTo='" + ArrivalTo + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", trainPlatform=" + trainPlatform +
                ", trainPlacesInCar=" + trainPlacesInCar +
                ", trainCars=" + trainCars +
                '}';
    }
    private Platform PlatformSTEnum(String platform) throws PlatformException {
        switch (platform) {
            case "A":
                return Platform.A;
            case "B":
                return Platform.B;
            case "C":
                return Platform.C;
            case "D":
                return Platform.D;
            default:
                throw new PlatformException("Wrong Platform!");
        }
    }
}
