package src;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cliente {
    private Integer id;
    private String nome;
    private String cognome;
    private TipologiaEnum tipo;
    private AllergieEnum allergieEnum;
    private Integer punteggioCliente;
    private Menu menuScelto;

    public Cliente(String nome, String cognome, TipologiaEnum tipo, AllergieEnum allergieEnum, Menu menuScelto, Integer id) {
        this.nome = nome;
        this.cognome = cognome;
        this.tipo = tipo;
        this.allergieEnum = allergieEnum;
        this.punteggioCliente = 0;
        this.menuScelto = menuScelto;
        this.id = id;
    }
    // metodi getter e setter
    public Menu getMenuScelto() {
        return menuScelto;
    }

    public void setMenuScelto(Menu menuScelto) {
        this.menuScelto = menuScelto;
    }
    public void setTipo(TipologiaEnum tipo) {
        this.tipo = tipo;
    }

    public AllergieEnum getAllergieEnum() {
        return allergieEnum;
    }

    public void setAllergieEnum(AllergieEnum allergieEnum) {
        this.allergieEnum = allergieEnum;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipologiaEnum getTipo() {
        return tipo;
    }

    public Integer getPunteggioCliente() {
        return punteggioCliente;
    }

    public void setPunteggioCliente(Integer punteggioCliente) {
        this.punteggioCliente = punteggioCliente;
    }

    // questo metodo aggiunge punti ai clienti
    public void aggiungiPuntiClienti(Integer punti) {
        setPunteggioCliente(getPunteggioCliente() + punti);
        System.out.println("Punteggio del cliente : " + this.nome + " " + getPunteggioCliente());
    }

    // questo metodo rimuove i punti
    public void rimuoviPunteggioClienti() {
        this.punteggioCliente = 0;
    }

    // QUESTO METODO VERIFICA SE IL CLIENTE HA SUPERATO IL LIMITE MASSIMO DI PUNTEGGI
    public Boolean limitePunteggioClienti() {
        return punteggioCliente >= 100;
    }


    //Metodo per scegliere il menu usando tipologiaEnum per scegliere il tipo di menu.
    public void scegliMenu(TipologiaEnum tipoMenu, Set<Menu> menuList) {
        for (Menu menu : menuList) {
            if (menu.getTipologiaMenu() == tipoMenu) {
                this.menuScelto = menu;
                break;
            }
        }
    }
    // metodo per definire il costo di un certo Menu.
    public double costoMenuScelto() {
        if (menuScelto != null) {
            return menuScelto.getCostoTotale();
        } else {
            return 0.0;
        }
    }



    @Override
    public String toString() {
        return nome + " " +cognome;
    }
}
