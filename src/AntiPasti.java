package src;

public class AntiPasti extends Portata{
    private String crudoOCotto;
    public AntiPasti(String nome, String descrizione, String ingredienti, Double prezzo, MenuEnum enumMenu, Integer id, String crudoOCotto) {
        super(nome, prezzo, enumMenu,descrizione, ingredienti, id);
        this.crudoOCotto = crudoOCotto;

    }

    @Override
    public void stampaPortate() {
        super.stampaPortate();
        System.out.print(this.getIngredienti()+"   ");

    }

    @Override
    public String toString() {
        return "AntiPasti{" +
                "ingredienti='" + this.getIngredienti() + '\'' +
                '}';
    }
}