package db.general;

import db.interfaces.Identified;
import enums.TypeCars;
import exceptions.TypeCarsException;

public class TrainTicket implements Identified<Integer> {
    private int TrainNumber;
    private TypeCars TypeCar;
    private int price;

    public TrainTicket() {

    }

    public TrainTicket(TypeCars TypeCar, int price) {
        this.TypeCar = TypeCar;
        this.price = price;

    }

    public TypeCars getTypeCars() {
        return TypeCar;
    }

    public void setTypeCar(TypeCars typeCar) {
        TypeCar = typeCar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int TrainNumber) {
        this.TrainNumber = TrainNumber;
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
//    private TypeCars TrainCarsSTEnum(String platform) throws TypeCarsException{
//        switch (platform) {
//            case "Planeboard":
//                return TypeCars.PlANEBOARD;
//            case "Compartment":
//                return TypeCars.COMPARTMENT;
//            case "Electricity":
//                return TypeCars.ELECTRICIY;
//            default:
//                throw new TypeCarsException("Wrong TypeCar!");
//        }
//    }
}
