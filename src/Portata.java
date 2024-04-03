package src;

public class Portata {

    private String nome;
    private Double prezzo;
    private MenuEnum enumMenu;
    private String descrizione;
    private String ingredienti;
    private Integer id;



    public Portata(String nome, double prezzo, MenuEnum enumMenu, String descrizione, String ingredienti, Integer id) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.enumMenu = enumMenu;
        this.descrizione = descrizione;
        this.ingredienti = ingredienti;
        this.id = id;
    }

    //    metodi getter e setter

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public MenuEnum getEnumMenu() {
        return enumMenu;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setEnumMenu(MenuEnum enumMenu) {
        this.enumMenu = enumMenu;
    }

    //    metodo per stampare le portate

    public void stampaPortate() {
        System.out.println(enumMenu + ":");
        System.out.printf("%-20s $%-10s\n", nome, prezzo);
        System.out.println(descrizione);
    }

}
