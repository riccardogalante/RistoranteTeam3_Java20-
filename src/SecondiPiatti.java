package src;

public class SecondiPiatti extends Portata{

    private String cotturaCarne;
    public SecondiPiatti(String nome, String descrizione, String ingredienti, Double prezzo, MenuEnum enumMenu, Integer id, String cotturaCarne) {
        super(nome, prezzo, enumMenu,descrizione, ingredienti, id);
        this.cotturaCarne = cotturaCarne;
    }

    @Override
    public void stampaPortate() {
        super.stampaPortate();
        System.out.print(this.getIngredienti()+"   ");

    }

    @Override
    public String toString() {
        return "SecondiPiatti{" +
                "ingredienti='" + this.getIngredienti() + '\'' +
                '}';
    }
}
