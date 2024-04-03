package src;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        //Creazione Portate
        Portata antipastoNormale = new AntiPasti("bruschette miste", "pomodorini al forno", "ingredienti: bruschetta, pomodoro, rosmarino", 3.50, MenuEnum.ANTIPASTI, 1, "cotto");
        Portata antipastoVegano = new AntiPasti("Insalata mista", "Insalata di stagione con olive e pomodoro", "ingredienti: insalata, olive, pomodoro", 4.50, MenuEnum.ANTIPASTI,2 , "crudo");
        Portata antipastoVegetariano = new AntiPasti("Caprese", "Mozzarella di bufala, pomodoro e basilico", "ingredienti: mozzarella di bufala, pomodoro, basilico", 6.00, MenuEnum.ANTIPASTI,3, "crudo");

        Portata primoPiattoNormale = new PrimiPiatti("pasta al pesto", "pasta corta con basilico pestato", "ingredienti: pasta e basilico", 8.00, MenuEnum.PRIMIPIATTI, 1, "12 minuti");
        Portata primoPiattoVegano = new PrimiPiatti("Pasta al pesto vegano", "Pasta con pesto vegano a base di basilico e noci", "ingredienti: pasta, basilico, noci", 9.00, MenuEnum.PRIMIPIATTI,2 , "11 minuti");
        Portata primoPiattoVegetariano = new PrimiPiatti("Risotto ai funghi", "Risotto con funghi porcini e parmigiano", "ingredienti: riso, funghi porcini, parmigiano", 10.50, MenuEnum.PRIMIPIATTI, 3, "15 minuti");

        Portata secondoPiattoNormale = new SecondiPiatti("tagliata", "manzo cotto al sangue e tagliato finemente", "ingredienti: manzo", 15.00, MenuEnum.SECONDIPIATTI,1, "20 minuti");
        Portata secondoPiattoVegano = new SecondiPiatti("Burger vegano", "Burger a base di lenticchie e quinoa", "ingredienti: lenticchie, quinoa", 8.00, MenuEnum.SECONDIPIATTI,2, "7 minuti");
        Portata secondoPiattoVegetariano = new SecondiPiatti("Melanzane alla parmigiana", "Melanzane grigliate con salsa di pomodoro e formaggio", "ingredienti: melanzane, pomodoro, formaggio", 12.00, MenuEnum.SECONDIPIATTI,3 ,"40 minuti");

        Portata dessertNormale = new Dessert("creme caramel", "crema ricoperta di caramello", "ingredienti: latte, uova, zucchero, caramello", 4.00, MenuEnum.DESSERT,1,"caldo");
        Portata dessertVegano = new Dessert("Torta al cioccolato vegana", "Torta senza uova e latte, solo cioccolato", "ingredienti: cioccolato, farina, zucchero", 5.00, MenuEnum.DESSERT,2,"calda");
        Portata dessertVegetariano = new Dessert("Tiramisù", "Dolce al cucchiaio con savoiardi e crema di mascarpone", "ingredienti: savoiardi, mascarpone", 7.00, MenuEnum.DESSERT,3, "freddo");

        Portata bevande1 = new Bevande("acqua", "bevanda dissetante che può essere naturale o frizzante" , "h2o",1.00,MenuEnum.BEVANDE , 1,"7 basico");
        Portata bevande2 = new Bevande("vino rosso","vino ricavato da uve ", "uva" ,4.00 ,MenuEnum.BEVANDE,2,"4 acido");
        Portata bevande3 = new Bevande("Coca Cola","bibita zuccherata accompagnata da una fetta di limone e ghiaccio", "Coca Cola", 2.00,MenuEnum.BEVANDE,3, "3 acido");



        // Creazione del menu
        Menu menuNormale = new Menu("Menu Normale", "VEGAN", "CuocoMarc", TipologiaEnum.NORMALE, 30.00, 1);
        Menu menuVegetariano = new Menu("Menu Veg", "VEGETARIANO", "CuocoVeg", TipologiaEnum.VEGETARIANO, 40.00,2);
        Menu menuVegan = new Menu("Menu Vegan", "NORMALE", "CuocoVegan", TipologiaEnum.VEGAN, 45.00,3);

        //Aggiunta delle portate ai menu'
        menuNormale.aggiungiPortata(antipastoNormale, MenuEnum.ANTIPASTI);
        menuVegan.aggiungiPortata(antipastoVegano, MenuEnum.ANTIPASTI);
        menuVegetariano.aggiungiPortata(antipastoVegetariano, MenuEnum.ANTIPASTI);

        menuNormale.aggiungiPortata(primoPiattoNormale, MenuEnum.PRIMIPIATTI);
        menuVegan.aggiungiPortata(primoPiattoVegano, MenuEnum.PRIMIPIATTI);
        menuVegetariano.aggiungiPortata(primoPiattoVegetariano, MenuEnum.PRIMIPIATTI);

        menuNormale.aggiungiPortata(secondoPiattoNormale, MenuEnum.SECONDIPIATTI);
        menuVegan.aggiungiPortata(secondoPiattoVegano, MenuEnum.SECONDIPIATTI);
        menuVegetariano.aggiungiPortata(secondoPiattoVegetariano, MenuEnum.SECONDIPIATTI);

        menuNormale.aggiungiPortata(dessertNormale, MenuEnum.DESSERT);
        menuVegan.aggiungiPortata(dessertVegano, MenuEnum.DESSERT);
        menuVegetariano.aggiungiPortata(dessertVegetariano, MenuEnum.DESSERT);

        menuNormale.aggiungiPortata(bevande1, MenuEnum.BEVANDE);
        menuVegan.aggiungiPortata(bevande2, MenuEnum.BEVANDE);
        menuVegetariano.aggiungiPortata(bevande3, MenuEnum.BEVANDE);

        //STAMPA DEL MENU'
        menuNormale.stampaMenu();

        // Creazione del ristorante
        Ristorante ristorante = new Ristorante(1,"Ristorante al taglio", 45);

        // Aggiunta dei menu a ristorante
        ristorante.aggiungiMenu(menuNormale);
        ristorante.aggiungiMenu(menuVegetariano);
        ristorante.aggiungiMenu(menuVegan);



        // Creazione dei clienti
        Cliente cliente1 = new Cliente("Mario", "Ostuni", TipologiaEnum.VEGAN, AllergieEnum.GLUTINE, menuVegan,1);
        ristorante.aggiungiPrenotazione(6,"lunedì 1 ottobre", cliente1);

        Cliente cliente2 = new Cliente("Federico", "Gonzales", TipologiaEnum.VEGETARIANO, AllergieEnum.NESSUNAALLERGIA, menuVegetariano,1);
        ristorante.aggiungiPrenotazione(4,"lunedì 3 ottobre", cliente2);


        //Stampa il menu che vuole il cliente
        ristorante.visualizzaMenuAndOrdina(cliente1);

        //Stampa le prenotazioni
        ristorante.stampaPrenotazioni();

        //Verifica la capienza massima, prenotazione e aggiunge 10 punti per ogni prenotazione
        ristorante.aggiungiPrenotazione(7, "13 ottobre 2024", cliente2);
        ristorante.aggiungiPrenotazione(7, "12 ottobre 2024", cliente1);


        //Stampa le prenotazioni dopo l'aggiunta
        ristorante.stampaPrenotazioni();
        //stampa il calcolo totale della spesa del cliente 1
        ristorante.pagaConto(cliente1);
        //stampa il calcolo totale della spesa del cliente 2
        ristorante.pagaConto(cliente2);

        //scelta del menu per il cliente e visualizzazione del costo del menu'
        cliente1.scegliMenu(TipologiaEnum.VEGAN, ristorante.getMenuSet());
        System.out.println("Costo menu scelto: "+cliente1.costoMenuScelto());
    }
}
