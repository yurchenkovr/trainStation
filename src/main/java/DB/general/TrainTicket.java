package DB.general;

import enums.TypeCars;
import exceptions.TypeCarsException;
import inerfaces.Identified;

public class TrainTicket implements Identified<Integer> {
    private int TrainNumber;
    private TypeCars TypeCar;
    private int id;
    private int price;
    private int trainNumber;

    protected void setId(int trainNumber){
        this.trainNumber = trainNumber;
    }

    public TypeCars getTypeCars() {
        return TypeCar;
    }
    public String getTCars(){
        return getTypeCars().getAbbr();
    }

    public void setTypeCars(String TypeCar) throws TypeCarsException {
        TypeCars tCar= TrainCarsSTEnum(TypeCar);
        this.TypeCar = tCar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Integer getId() {
        return TrainNumber;
    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "TrainNumber=" + TrainNumber +
                ", TypeCars=" + TypeCar +
                ", price=" + price +
                '}';
    }
    private TypeCars TrainCarsSTEnum(String platform) throws TypeCarsException{
        switch (platform) {
            case "Planeboard":
                return TypeCars.PlANEBOARD;
            case "Compartment":
                return TypeCars.COMPARTMENT;
            case "Electricity":
                return TypeCars.ELECTRICIY;
            default:
                throw new TypeCarsException("Wrong TypeCar!");
        }
    }
}
