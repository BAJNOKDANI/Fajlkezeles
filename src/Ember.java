import java.util.ArrayList;

public class Ember {
    private String nev;
    private int eletkor;
 //default konstruktor
    public Ember(String nev, int eletkor) {
        this.nev = nev;
        this.eletkor = eletkor;
    }
//a fájl egy sorából inicializálj az objektumot: sor a paraméter
    public Ember(String sor){
        String [] reszek = sor.split(";");
        this.nev= reszek[0];
        this.eletkor= Integer.parseInt(reszek[1]);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

    @Override
    public String toString() {
        return  nev +
                ", " + eletkor;
    }
}
