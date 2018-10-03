package enums;

public enum WorkerPositions {
    ADMIN("Admin"),
    CASHIER("Cashier"),
    CLEANER("Cleaner"),
    CONDUCTOR("Conductor"),
    MACHINIST("Machinist");

    private String abbr;

    WorkerPositions(String abbr){
        this.abbr = abbr;
    }

    public String getAbbr(){
        return abbr;
    }
}
