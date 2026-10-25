public class Calciatore {
    
    private String nome;
    private String cognome;
    private String squadra;
    private int altezza;
    private double peso;
    private Data d;
    
    //costruttore
    public Calciatore(String nome, String cognome, String squadra,
            int altezza, double peso, Data d)
    {
        
        this.nome = nome;
        this.cognome = cognome;
        this.squadra = squadra;
        this.altezza = altezza;
        this.peso = peso;
        this.d = d;
        
    }
    
    //costruttore vuoto
    public Calciatore()
    {
        
        this.nome = "";
        this.cognome = "";
        this.squadra = "";
        this.altezza = 0;
        this.peso = 0;
        this.d = new Data();
        
    }

    //costruttore alfanumerico
    public Calciatore(String nome, String cognome, String squadra)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.squadra = squadra;
    }

    //costruttore di copia
    public Calciatore (Calciatore c1)
    
    {

        this.nome = c1.nome;
        this.cognome = c1.cognome;
        this.squadra = c1.squadra;
        this.altezza = c1.altezza;
        this.peso = c1.peso;
        this.d = c1.d != null ? new Data(c1.d) : null;

    }
    
    //metodi getter
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }
    
    public String getSquadra(){
        return this.squadra;
    }
    
    public int getAltezza(){
        return this.altezza;
    }
    
    public double getPeso(){
        return this.peso;
    }

    public Data getData(){
        return this.d;
    }
    
    //metodi setter

    
    public void  setNome(String a){
        this.nome = a;
    }
    
    public void  setCognome(String b){
        this.cognome = b;
    }
    
    public void  setSquadra(String c){
        this.squadra = c;
    }
    
    public void  setAltezza(int d){
        this.altezza = d;
    }
    
    public void  setPeso(double e){
        this.peso = e;
    }

    public void setData(Data f){
        this.d = f;
    }
    
    public String CalciatoreToString(){
        
        String s = "";
        
        s += "\nNome: ";
        s += this.getNome();
        s += "\nCognome: ";
        s += this.getCognome();
        s += "\nSquadra: ";
        s += this.getSquadra();
        s += "\nAltezza: ";
        s += this.getAltezza();
        s += "\nPeso: ";
        s += this.getPeso();
        s += "\nData di nascita: " + this.d;
        s += "\n";

        return s;
    }
    
    public void StampaCalciatore()
    {
        System.out.println(this.CalciatoreToString());
    }

    public boolean equalsCalciatore(Calciatore c)
    {

        boolean tmp = false;

        if((this.getNome().equals(c.getNome())) &&
         (this.getCognome().equals(c.getCognome())) &&
         (this.getSquadra().equals(c.getSquadra())) &&
         (this.getAltezza() == c.getAltezza()) &&
         (this.getPeso() == c.getPeso()))
            tmp = true;
        
        return tmp;
    }


    public int ConfrontoPeso(Calciatore t)
    {
        int a = 0;

        if(this.peso == t.getPeso()){

            a = 1;
        }
        else
        {

         if (this.peso < t.getPeso()) {

            a = 2;
         }
        else{
            a = 3;
        }
    }
        return a;
    }


    public int ConfrontoAltezza(Calciatore t)
    {
        int b = 0;

        if(this.altezza == t.getAltezza()){

            b = 1;
        }
        else
        {
            
         if (this.altezza < t.getAltezza()) {

            b = 2;
         }
        else
        {
            b = 3;
        }
    }
        return b;
    }


}