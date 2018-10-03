package enums;

public enum TrainCars {
    PlANEBOARD("Planeboard"),
    COMPARTMENT("Compartment"),
    ELECTRICIY("Sitting");

    private String abbr;

    TrainCars(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}

