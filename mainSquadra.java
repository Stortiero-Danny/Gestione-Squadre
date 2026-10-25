public class mainSquadra {

    public static void main(String args[]) {

        Data d1 = new Data(25, 11, 2024);
        Data d2 = new Data(10, 11, 2024);
        Data d3 = new Data(3, 11, 2024);
        Data d4 = new Data(25, 11, 2024);

        Calciatore c1 = new Calciatore("Mario", "Rossi", "Milan", 180, 60, d1);
        Calciatore c2 = new Calciatore("Danny", "Stortiero", "Toro", 190, 60, d2);
        Calciatore c3 = new Calciatore("Gigi", "Buffon", "Juve", 150, 60, d3);
        Calciatore c4 = new Calciatore("Cristiano", "Ronaldo", "Real Madrid", 170, 60, d4);

        Squadra s1 = new Squadra("Torino", "Torino", 1906, new Calciatore[Squadra.MAXG]);
        s1.aggiungigiocatore(c1);
        s1.aggiungigiocatore(c2);

        System.out.println(s1.toString());

        Squadra s2 = new Squadra("Juventus", "Torino", 1897, new Calciatore[Squadra.MAXG]);
        s2.aggiungigiocatore(c3);
        s2.aggiungigiocatore(c4);

        s2.aggiungigiocatore(c1);
        s2.aggiungigiocatore(c2);

        System.out.println(s2.toString());

        s1.rimuovigiocatore(c1);
        System.out.println(s1.toString());
        
        s2.rimuovigiocatore(c1);
        s2.rimuovigiocatore(c2);

        System.out.println(s2.toString());


    }
}