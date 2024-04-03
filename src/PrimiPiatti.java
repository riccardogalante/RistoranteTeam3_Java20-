package src;

public class PrimiPiatti extends Portata{
    private String cottura;

    public PrimiPiatti(String nome, String descrizione, String ingredienti, Double prezzo, MenuEnum enumMenu, Integer id, String cottura) {
        super(nome, prezzo, enumMenu,descrizione, ingredienti, id);
        this.cottura = cottura;
    }

    @Override
    public void stampaPortate() {
        super.stampaPortate();
        System.out.print(this.getIngredienti()+"   ");

    }

    @Override
    public String toString() {
        return "PrimiPiatti{" +
                "ingredienti='" + this.getIngredienti() + '\'' +
                '}';
    }
}