package src;

import java.util.*;

public class Ristorante {
    private Integer id;
    private String nomeRistorante;
    private Set<Menu> menuSet;
    private List<Portata> portate;
    private Map<String, Cliente> prenotazioni;
    private Integer copertiRistorante;
    private Integer postiOccupati;

    public Ristorante(Integer id, String nomeRistorante, Integer copertiRistorante) {
        this.id = id;
        this.nomeRistorante = nomeRistorante;
        this.copertiRistorante = copertiRistorante;
        this.menuSet = new HashSet<>();
        this.prenotazioni = new HashMap<>();
        this.portate = new ArrayList<>();
        this.postiOccupati = 0;
    }
    // metodi getter e setter
    public String getNomeRistorante() {
        return nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    public Integer getCopertiRistorante() {
        return copertiRistorante;
    }

    public void setCopertiRistorante(Integer copertiRistorante) {
        this.copertiRistorante = copertiRistorante;
    }

    public Integer getPostiOccupati() {
        return postiOccupati;
    }

    public void setPostiOccupati(Integer postiOccupati) {
        this.postiOccupati = postiOccupati;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    public List<Portata> getPortate() {
        return portate;
    }

    public void setPortate(List<Portata> portate) {
        this.portate = portate;
    }

    public Map<String, Cliente> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(Map<String, Cliente> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public Cliente getPrenotazione(String data) {
        return prenotazioni.get(data);
    }
    // metodo per aggiungere le prenotazioni
    private void aggiungiPrenotazionePrivata(String data, Cliente cliente) {
        if (prenotazioni.size() < copertiRistorante) {
            prenotazioni.put(data, cliente);
            //aggiunto le stampe
            System.out.println("Prenotazione effettuata per " + cliente.getNome() + " " + cliente.getCognome());
        } else {
            System.out.println("Prenotazione non disponibile, il ristorante è pieno.");
        }
    }



    // metodo per stampare le prenotazioni
    public void stampaPrenotazioni() {
        System.out.println("Prenotazioni del ristorante:");
        for (Map.Entry<String, Cliente> entry : prenotazioni.entrySet()) {
            String data = entry.getKey();
            Cliente nome = entry.getValue();
            System.out.println("Data: " + data + ", Nome: " + nome);
        }
    }

    // metodo per aggiungere un menù
    public void aggiungiMenu(Menu menuAggiunto) {
        if (menuAggiunto != null) {
            menuSet.add(menuAggiunto);
        } else {
            System.out.println("Impossibile aggiungere al menù");
        }
    }
    //metodo per rimuovere un menù
    public void rimuoviMenu(Menu menuRimosso) {
        if (menuSet.contains(menuRimosso)) {
            menuSet.remove(menuRimosso);
        } else {
            System.out.println("Impossibile rimuovere dal menù");
        }
    }
    //    metodo per visualizzare il menù
    public void visualizzaMenuAndOrdina(Cliente cliente) {
        System.out.println("Menu " + cliente.getTipo());
        Menu menu = null;
        for (Menu menuVar : menuSet) {
            if (menuVar.getTipologiaMenu() == cliente.getTipo()) {

                menu = menuVar;
                menuVar.stampaMenu();
                break;
            }
        }

        if (menu != null) {
            cliente.setMenuScelto(menu);
        } else {
            System.out.println("Menu non disponibile per il tipo di cliente");
        }
    }
    //    metodo per pagare il conto
    public void pagaConto(Cliente cliente) {
        double spesaTotale = 0.0;
        Menu menu = cliente.getMenuScelto();
        ArrayList<Portata> portateScelte = new ArrayList<>(menu.getPortate());
        for (Portata portata : portateScelte) {
            spesaTotale += portata.getPrezzo();
        }
        System.out.println("Il conto del cliente " + cliente.getNome() + " " + cliente.getCognome() + " è di : " + spesaTotale);
        prenotazioni.remove(cliente);
        cliente.aggiungiPuntiClienti(10);
    }


    // METODO PER VERIFICARE LA CAPIENZA MASSIMA E AGGIUNTA DI 10 PUNTI PER OGNI PRENOTAZIONE
    public void aggiungiPrenotazione(int copertiRichiesti, String data, Cliente cliente) {
        int postiDisponibili = copertiRistorante - postiOccupati;
        if (copertiRichiesti <= postiDisponibili) {
            aggiungiPrenotazionePrivata(data, cliente);
            System.out.println("Prenotazione effettuata");
            cliente.aggiungiPuntiClienti(10);

        } else {
            System.out.println("Impossibile aggiungere prenotazione,siamo pieni!");
        }

    }


    @Override
    public String toString() {
        return "Ristorante{" +
                "nomeRistorante='" + nomeRistorante + '\'' +
                ", menu=" + menuSet +
                ", portate=" + portate +
                ", prenotazioni=" + prenotazioni +
                ", copertiRistorante=" + copertiRistorante +
                ", postiOccupati=" + postiOccupati +
                '}';
    }
}

