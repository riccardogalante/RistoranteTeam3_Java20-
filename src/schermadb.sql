//TODO per uil db dobbiamo fare un file schermadb.sql dove ognugno di voi inserirà le proprie tabelle, quelle comuni le fate insieme (menu, risto) il resto ve le dividete
//TODO dobbiamo usare lucid app per fare il diagramma ER(entità releazione).
CREATE TABLE ristorante(
    id_ristorante INT PRIMARY KEY,
    nome_ristorante VARCHAR(255),
    coperti_ristorante INT
);
INSERT INTO Ristorante (id_ristorante, nome_ristorante, coperti_ristorante) VALUES
(1, "Cracco mi fa un baffo", 150);



CREATE TABLE cliente(
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    id_ristorante INT,
    nome VARCHAR(255),
    cognome VARCHAR(255),
    punteggioCliente INT
);
ALTER TABLE cliente ADD FOREIGN KEY (id_ristorante) REFERENCES ristorante(id_ristorante);
INSERT INTO cliente (id_ristorante, nome, cognome, punteggioCliente) VALUES
(1,"Mario", "Ostuni", 0),
(1,"Federico", "Gonzales", 5);


CREATE TABLE prenotazione(
    id_prenotazione INT PRIMARY KEY,
    id_ristorante INT,
    id_cliente INT,
    data DATE
);
ALTER TABLE prenotazione ADD FOREIGN KEY (id_ristorante) REFERENCES ristorante(id_ristorante);
ALTER TABLE prenotazione ADD FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);
INSERT INTO prenotazione (id_prenotazione, data, id_ristorante, id_cliente) VALUES
(1,"2024-02-21",1,1),
(2,"2024-02-27",1,2);


CREATE TABLE menu(
    id_menu INT PRIMARY KEY,
    id_ristorante INT,
    nome_menu VARCHAR(255),
    tipo_menu VARCHAR(255),
    nome_cuoco VARCHAR(255)
);
ALTER TABLE menu ADD FOREIGN KEY (id_ristorante) REFERENCES ristorante(id_ristorante);
INSERT INTO menu (id_menu, id_ristorante, nome_menu, tipo_menu, nome_cuoco) VALUES
(1,1,"Menu di terra", "Normale", "Gianfranco"),
(2,1,"Menu speciale", "Vegano", "Marc"),
(3,1,"Menu specialissimo", "Vegetariano", "Louis");


CREATE TABLE secondi_piatti(
    id_secondi_piatti INT PRIMARY KEY AUTO_INCREMENT,
    id_menu INT,
    nome VARCHAR(255),
    descrizione VARCHAR(255),
    ingredienti VARCHAR(255),
    prezzo double,
    cottura_carne VARCHAR(255)
);
ALTER TABLE secondi_piatti ADD FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
INSERT INTO secondi_piatti (id_menu, nome, descrizione, ingredienti, prezzo, cottura_carne) VALUES
(1,"tagliata", "manzo cotto al sangue e tagliato finemente", "manzo", 15.00, "15 minuti"),
(2,"Burger vegano", "Burger a base di lenticchie e quinoa", "lenticchie, quinoa", 8.00, "7 minuti"),
(3,"Melanzane alla parmigiana", "Melanzane grigliate con salsa di pomodoro e formaggio", "melanzane, pomodoro, formaggio", 12.00, "40 minuti");

CREATE TABLE bevande (
    id_bevande INT PRIMARY KEY AUTO_INCREMENT,
    id_menu INT,
    nome VARCHAR(255),
    descrizione VARCHAR(255),
    prezzo double,
    ph VARCHAR(255)
);
ALTER TABLE bevande ADD FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
INSERT INTO bevande (id_menu, nome, descrizione, prezzo, ph) VALUES
(1,"acqua", "bevanda dissetante che può essere naturale o frizzante", 1.00, "7 basica"),
(2,"vino rosso", "vino ricavato da uve", 4.00, "3,8 acido"),
(3,"Coca Cola", "bibita zuccherata accompagnata da una fetta di limone e ghiaccio", 2.00, "2,5 acida");

CREATE TABLE antipasti (
    id_antipasti INT PRIMARY KEY AUTO_INCREMENT,
    id_menu INT,
    nome VARCHAR(255),
    descrizione VARCHAR(255),
    ingredienti VARCHAR(255),
    prezzo double,
    crudo_o_cotto VARCHAR(255)
);
ALTER TABLE antipasti ADD FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
INSERT INTO antipasti (id_menu, nome, descrizione, ingredienti, prezzo, crudo_o_cotto) VALUES
(1,"bruschette miste", "pomodorini al forno", "bruschetta, pomodoro, rosmarino", 3.50, "crudo"),
(2,"Insalata mista", "Insalata di stagione con olive e pomodoro", "insalata, olive, pomodoro", 4.50, "crudo"),
(3,"Caprese", "Mozzarella di bufala, pomodoro e basilico", "mozzarella di bufala, pomodoro, basilico", 6.00, "crudo");

CREATE TABLE dessert(
    id_dessert INT PRIMARY KEY AUTO_INCREMENT,
    id_menu INT,
    nome VARCHAR(255),
    descrizione VARCHAR(255),
    ingredienti VARCHAR(255),
    prezzo double,
    caldo_o_freddo VARCHAR(255)
);
ALTER TABLE dessert ADD FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
INSERT INTO dessert (id_menu, nome, descrizione, ingredienti, prezzo, caldo_o_freddo) VALUES
(1,"creme caramel", "crema ricoperta di caramello", "latte, uova, zucchero, caramello", 4.00, "calda"),
(2,"Torta al cioccolato vegana", "Torta senza uova e latte, solo cioccolato", "cioccolato, farina, zucchero", 5.00, "calda"),
(3,"Tiramisù", "Dolce al cucchiaio con savoiardi e crema di mascarpone", "savoiardi, mascarpone", 7.00, "freddo");

CREATE TABLE primi_piatti (
    id_primi_piatti INT PRIMARY KEY AUTO_INCREMENT,
    id_menu INT,
    nome VARCHAR(255),
    descrizione VARCHAR(255),
    ingredienti VARCHAR(255),
    prezzo double,
    cottura VARCHAR(255)
);
ALTER TABLE primi_piatti ADD FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
INSERT INTO primi_piatti (id_menu, nome, descrizione, ingredienti, prezzo, cottura) VALUES
(1,"pasta al pesto", "pasta corta con basilico pestato", "pasta e basilico",8.00, "12"),
(2,"Pasta al pesto vegano","Pasta con pesto vegano a base di basilico e noci","pasta, basilico, noci",9.00, "10"),
(3,"Risotto ai funghi","Risotto con funghi porcini e parmigiano","riso, funghi porcini, parmigiano",10.50, "20");

