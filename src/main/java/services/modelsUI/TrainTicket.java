package services.modelsUI;

import enums.TypeCars;

public class TrainTicket {
    private TypeCars TypeCar;
    private int price;

    public TypeCars getTypeCars() {
        return TypeCar;
    }

    public void setTypeCars(TypeCars typeCar) {
        TypeCar = typeCar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TrainTicket(TypeCars TypeCar, int price) {
        this.TypeCar = TypeCar;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "TypeCar=" + TypeCar +
                ", price=" + price +
                '}';
    }
}
