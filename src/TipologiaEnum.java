package src;

public enum TipologiaEnum {
    VEGETARIANO("Menu Vegetariano"),
    VEGAN("Menu Vegan"),
    NORMALE("Menu Del Giorno"),
    CELIACO("Menu Senza Glutine"),
    NOLATTOSIO("Menu Senza Lattosio");

    private final String tipoMenu;
    TipologiaEnum(String tipoMenu){
        this.tipoMenu = tipoMenu;
    }
    public String getTipoMenu() {
        return tipoMenu;
    }


}
