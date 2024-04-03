package src;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;
    private String nomeMenu;
    private String tipoMenu;
    private String nomeCuoco;
    private List<Portata> portate;
    private TipologiaEnum tipologiaMenu;
    private Double costoTotale;

    public Menu(String nomeMenu, String tipoMenu, String nomeCuoco, TipologiaEnum tipologiaMenu,Double costoTotale, Integer id) {
        this.nomeMenu = nomeMenu;
        this.tipoMenu = tipoMenu;
        this.nomeCuoco = nomeCuoco;
        this.portate = new ArrayList<>();
        this.tipologiaMenu = tipologiaMenu;
        this.costoTotale = costoTotale;
        this.id = id;
    }
    // metodi getter e setter

    public String getNomeMenu() {
        return nomeMenu;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public String getNomeCuoco() {
        return nomeCuoco;
    }

    public List<Portata> getPortate() {
        return portate;
    }

    public TipologiaEnum getTipologiaMenu() {
        return tipologiaMenu;
    }
    //nuovo getter costoTotale.
    public Double getCostoTotale() {
        return costoTotale;
    }

    public void setNomeMenu(String nomeMenu) {
        this.nomeMenu = nomeMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public void setNomeCuoco(String nomeCuoco) {
        this.nomeCuoco = nomeCuoco;
    }

    public void setPortate(List<Portata> portate) {
        this.portate = portate;
    }
    //nuovo setter costoTotale.
    public void setCostoTotale(Double costoTotale) {
        this.costoTotale = costoTotale;
    }
    // metodo per aggiungere una portata
    public void aggiungiPortata(Portata portata, MenuEnum enumMenu) {
        portata.setEnumMenu(enumMenu);
        portate.add(portata);
    }

    // metodo per stampare il menù
    public void stampaMenu() {
                                  //Scegli colore
        EnumColori coloreScelto = EnumColori.VERDE;
        String reset = "\u001B[0m";
        if (!portate.isEmpty()) {
            for (Portata portata : portate) {
                System.out.println(coloreScelto.getColore());
                portata.stampaPortate();
            }
            System.out.println(reset);
        } else {
            // aggiunto nomeMenu per capire qualle menu è vuoto.
            System.out.println("Il menu " + nomeMenu + " è vuoto.");
        }

    }


    @Override
    public String toString() {
        return "Menu{" +
                "nomeMenu='" + nomeMenu + '\'' +
                ", tipoMenu='" + tipoMenu + '\'' +
                ", nomeCuoco='" + nomeCuoco + '\'' +
                ", portate=" + portate +
                ", tipologiaMenu=" + tipologiaMenu +
                '}';
    }
}
