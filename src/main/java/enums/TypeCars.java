package enums;

public enum TypeCars {
    PlANEBOARD("Planeboard"),
    COMPARTMENT("Compartment"),
    ELECTRICIY("Sitting");

    private String abbr;

    TypeCars(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }
}

