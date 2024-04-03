package src;

public class Bevande extends Portata{
    private String ph;
    public Bevande(String nome, String descrizione, String ingredienti, Double prezzo, MenuEnum enumMenu, Integer id, String ph) {
        super(nome, prezzo, enumMenu,descrizione, ingredienti, id);
        this.ph = ph;
    }

    @Override
    public String toString() {
        return "Bevande{}";
    }
}
