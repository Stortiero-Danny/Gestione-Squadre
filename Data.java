public class Data
{
    private int Giorno;
    private int Mese;
    private int Anno;

    //costruttore
    public Data(int t, int m, int a)
    {
        this.Giorno = t;
        this.Mese = m;
        this.Anno = a;
    }

    //costruttore vuoto
    public Data()
    {
        this.Giorno = 0;
        this.Mese = 0;
        this.Anno = 0;
    }

    //Costruttore di copia
    public Data(Data c){
        
        this.Giorno = c.Giorno;
        this.Mese = c.Mese;
        this.Anno = c.Anno;
        
    }

    
    
    //metodi getter
    public int getGiorno(){

        return this.Giorno;
    }

    public int getMese(){

        return this.Mese;
    }

    public int getAnno(){

        return this.Anno;
    }


    //metodi setter
    public void setGiorno(int a){

        this.Giorno = a;
    }

    public void setMese(int b){

        this.Mese = b;
    }

    public void setAnno(int c){

        this.Anno = c;
    }

    public void Stampa()
    {
        System.out.println(this.toString());
    }

    public String meseToString()
    {
      String nomem = "";
      
      String[] mesianno = {"Gennaio","Febbraio",
      "Marzo","Aprile","Maggio","Giugno","Luglio","Agosto",
      "Settembre","Ottobre","Novembre","Dicembre"};
      nomem = mesianno[this.Mese-1];
      
      return nomem;
    }
    
    public String toString()
    {
        String s = "";

        
        if(this.controlli() == false)
        s += "Data non accettabile :(";
        else
        {
        s += "Data accettabile :)";
        s += "\nGiorno: ";
        s += this.getGiorno();
        s += "\nMese: ";
        s += this.getMese();
        s += "\nAnno: ";
        s += this.getAnno();
        s += "\nData completa: ";
        s += this.getGiorno();
        s += " ";
        s += this.meseToString();
        s += " ";
        s += this.getAnno();
        s += "\n";
        }


        return s;
    }

    public boolean equals(Data t)
    {
        boolean tmp = false;

         if (this.Giorno == t.getGiorno() && 
        this.Mese == t.getMese() && 
        this.Anno == t.getAnno()) {

            tmp = true;
         }
        
        return tmp;
    }

    public boolean controlli()
    {
        boolean v = true;

        //controllo di una data accettabile
        if(this.Giorno < 1 || this.Giorno > 31
         || this.Mese < 1 || this.Mese > 12 
         || this.Anno > 2024 || this.Anno < 1900)
        v = false;

        //controllo degl' anni bisestili
        /* Un anno è bisestile quando è divisibile per 4 ma non per 100,
         oppure quando è divisibile per 4, per 100 e anche per 400. 
        */
        if(this.Anno % 4 == 0 && this.Anno % 100 != 0 ||
         this.Anno % 4 == 0 && this.Anno % 100 == 0 && this.Anno % 400 == 0)
        {
            if(this.Mese == 2)
            {
             if(this.Giorno > 29)   //se l'anno è bisestile e il giorno del mese di febbraio supera 29 allora è una data impossibile
                v = false;
            }
        }
        else{
        if(this.Mese == 2)
        {
            if(this.Giorno > 28)    //se l'anno non è bisestile e il giorno del mese di febbraio supera 28 allora è una  data impossibile
            v = false;
        }
    }

        if(this.Mese == 11 || this.Mese == 4 || this.Mese == 6 || this.Mese == 9)
        {
            if(this.Giorno > 30)    //se nei mesi dove massimo ci sono 30 giorni è inserito un giorno superiore a 30 la data è impossibile
            v = false;
        }

        if(this.Mese == 1 || this.Mese == 3 || this.Mese == 5 ||
         this.Mese == 7 || this.Mese == 8 || this.Mese == 10 || this.Mese == 11)
        {
            if(this.Giorno > 31)    //se nei mesi dove massimo ci sono 31 giorni è inserito un giorno superiore a 31 la data è impossibile
            v = false;
        }

        return v;
    }

    public int distanza(Data t)
    {
        int a = 0, an = 365, i = 0, Max = 0, min = 0;

        //inizio calcolo distanza degli anni


        if(this.getAnno() != t.getAnno())   //controlla se le date non hanno lo stesso anno
        {

        //verifica dell'anno con il valore più alto
        if(this.getAnno() > t.getAnno())
        {
            Max = this.getAnno();
            min = t.getAnno();
        }
        else
        {
            min = this.getAnno();
            Max = t.getAnno();
        }

        //ciclo for per contare il giorno in più degli anni bisestili
        for(i = Max; i > min; i--){
            if((i % 4 == 0 && i % 100 != 0) ||
            (i % 4 == 0 && i % 100 == 0 && i % 400 == 0))   //se l'anno è bisestile allora aggiungi un giorno
         a += 1;
        }

            a += (Max - min) * an;     //giorni totali tra i due anni
        }
        //fine calcolo distanza degli anni



        //inizio calcolo distanza dei mesi e dei giorni

        if(this.getMese() != t.getMese())   //controlla se il mese non sia uguale
        {
            if(this.getMese() > t.getMese())
        {
            Max = this.getMese();
            min = t.getMese();
        }
        else
        {
            min = this.getMese();
            Max = t.getMese();
        }

        /*il ciclo for assegna i giorni dei mesi successivi
         e si ferma prima del mese massimo per poi contare
          i giorni precisi che rimangono*/
        for(i = min + 1; i < Max; i++) 
        {
        
        if(i == 2)
            a += 28;

            if(i == 11 || i == 4 || i == 6 || i == 9)
            a += 30;

            if(i == 1 || i == 3 || i == 5 ||
         i == 7 || i == 8 || i == 10 || i == 12)
            a += 31;
        }

        //giorni del mese più piccolo (es. 4 (marzo) è più piccolo di 6 (giugno))
        if(this.getMese() < t.getMese())
        {
            i = this.getMese();
            if(i == 2)
            a += (28 - this.getGiorno());

            if(i == 11 || i == 4 || i == 6 || i == 9)
            a += (30 - this.getGiorno());

            if(i == 1 || i == 3 || i == 5 ||
         i == 7 || i == 8 || i == 10 || i == 12)
            a += (31 - this.getGiorno());

            a += t.getGiorno();//giorni esatti da contare dell'ultimo mese

        }
        else
        {
            i = t.getMese();
            if(i == 2)
            a += (28 - t.getGiorno());

            if(i == 11 || i == 4 || i == 6 || i == 9)
            a += (30 - t.getGiorno());

            if(i == 1 || i == 3 || i == 5 ||
         i == 7 || i == 8 || i == 10 || i == 12)
            a += (31 - t.getGiorno());

            a += this.getGiorno();//giorni esatti da contare dell'ultimo mese

        }

        }

        //se le date hanno lo stesso mese si fa solo la differenza tra i giorni
        else{

            if(this.getGiorno() != t.getGiorno()){  //controlla se il giorno non è lo stesso
            if(this.getGiorno() > t.getGiorno())
            a += (this.getGiorno() - t.getGiorno());
            else
            a += (t.getGiorno() - this.getGiorno());
            }
            
        }
        //fine calcolo distanza dei mesi e dei giorni

        return a;
    }    

}