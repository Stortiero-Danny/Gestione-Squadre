import java.util.Arrays; //offre una serie di utilità per lavorare con array in Java

public class Squadra {

    final static int MAXG = 30;
    private String nome;
    private String citta;
    private int annoFondazione;
    private Calciatore[] ca;// = new Calciatore[MAXG];

    // Costruttore
    public Squadra(String nome, String citta, int annoFondazione, Calciatore[] ca) {
        this.nome = nome;
        this.citta = citta;
        this.annoFondazione = annoFondazione;
        this.ca = ca;
    }

    // Costruttore di copia
    public Squadra(Squadra s) {
        this.nome = s.nome;
        this.citta = s.citta;
        this.annoFondazione = s.annoFondazione;
        this.ca = new Calciatore[MAXG];

        for (int i = 0; i < MAXG; i++) {
    if (s.getCa()[i] != null) {
        this.ca[i] = new Calciatore(s.getCa()[i]); // Usa il costruttore di copia della classe Calciatore
    } else {
        this.ca[i] = null; // Mantieni null se non ci sono giocatori in quella posizione
    }
}
    }

    // Costruttore vuoto
    public Squadra() {
        this.nome = "";
        this.citta = "";
        this.annoFondazione = 0;
        this.ca = new Calciatore[MAXG];
    }

    // metodi Getter
    public String getNome() {
        return this.nome;
    }

    public String getCitta() {
        return this.citta;
    }

    public int getAnnoFondazione() {
        return this.annoFondazione;
    }

    public Calciatore[] getCa() {
        return ca;
    }

    // metodi Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setAnnoFondazione(int annoFondazione) {
        this.annoFondazione = annoFondazione;
    }

    public void setCa(Calciatore[] ca) {
        this.ca = ca;
    }

    // altri metodi

    public String stampaGiocatori()
{
    String risultato = ""; // Stringa vuota per iniziare
    for (int i = 0; i < ca.length; i++) { // Scorri tutti i calciatori
        if (ca[i] != null) { // Controlla che il calciatore non sia null
            risultato += "\n" + (i + 1) + ")"+ ca[i].CalciatoreToString(); // Aggiungi il calciatore alla stringa
        }
    }
    return risultato; // Restituisci la stringa completa
}
    
    public void aggiungigiocatore(Calciatore c) {
    for (int i = 0; i < MAXG; i++) {
        if (this.ca[i] == null) { // Controlla se il posto è vuoto
            this.ca[i] = c; // Aggiungi il giocatore

            return; //return per interrompere il ciclo for
        }
    }
    System.out.println("Non c'è spazio per aggiungere un nuovo giocatore.");
}

    public void rimuovigiocatore(Calciatore c)
    {
    int i = 0;
    boolean trovato = false;

    // Trova e rimuove il calciatore
    while (i < MAXG && trovato == false) {
        if (this.ca[i] == c) {
            this.ca[i] = null;
            trovato = true;  // Segna che il calciatore è stato trovato e rimosso
        } else {
            i++;
        }
    }

    if (trovato == true) 
    {
        int j;
        // Sposta tutti i giocatori dopo di lui in avanti per "riempire" lo spazio
        for (j = i; j < MAXG - 1; j++) {
            if (this.ca[j + 1] != null) {   //controlla se è presente qualcosa nella cella successiva
                this.ca[j] = this.ca[j + 1];    //la sostituisce
                this.ca[j + 1] = null;  // Pulisce l'ultima posizione
            }
        }
    } else {
        System.out.println("Giocatore non trovato nella squadra.");
    }
}


    // Metodo toString
    @Override
    public String toString() {
        return "Squadra: " + nome + "\ncitta = " + citta + "\nAnno di Fondazione = " + annoFondazione
                + "\nElenco dei Calciatori = \n" + stampaGiocatori();
    }
}