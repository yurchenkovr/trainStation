package enums;


public enum Platform {
    A("A"),
    B("B"),
    C("C"),
    D("D");

    private String abbr;

    Platform(String abbr){
        this.abbr = abbr;
    }

    public String getAbbr(){
        return abbr;
    }

}
