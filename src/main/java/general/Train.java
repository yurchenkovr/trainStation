package general;

import enums.Platform;
import exceptions.PlatformException;
import inerfaces.Identified;

import java.sql.Time;

public class Train implements Identified<Integer> {
    private int TrainNumber;
    private String DepartureFrom;
    private String ArrivalTo;
    private Time arrivalTime;
    private Time departureTime;
    private Platform trainPlatform;

    public Train() {
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

    public String getTPlatform() {
        return getTrainPlatform().getAbbr();
    }

    public void setTrainPlatform(String trainPlatform) throws PlatformException {
        Platform tPlatform = PlatformSTEnum(trainPlatform);
        this.trainPlatform = tPlatform;
    }


    @Override
    public String toString() {
        return "general.Train{" +
                "  TrainNumber=" + TrainNumber +
                ", DepartureFrom='" + DepartureFrom + '\'' +
                ", ArrivalTo='" + ArrivalTo + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", trainPlatform=" + trainPlatform +
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
