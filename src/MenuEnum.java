package src;

public enum MenuEnum {


    ANTIPASTI("Antipasto"),
    PRIMIPIATTI("Primo piatto"),
    SECONDIPIATTI("Secondo piatto"),
    DESSERT("Dessert"),
    BEVANDE( "Bevanda");
    private final String tipoDiPortata;

    MenuEnum(String tipoDiPortata) {
        this.tipoDiPortata = tipoDiPortata;
    }

    public String getTipoDiPortata() {
        return tipoDiPortata;
    }
}
