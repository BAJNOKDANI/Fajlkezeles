import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Ember> lista = new ArrayList<>();
    public static void main(String[] args) {
        fajlBeOlvasas();
        for (Ember item : lista){
            System.out.println(item);
        }
        leghosszabbNev();
        eletkorAtlag();
    }
    public static void fajlBeOlvasas(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("adatok.txt"));
            String sor = bufferedReader.readLine();
            while (sor != null){
                lista.add(new Ember(sor));
                sor=bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leghosszabbNev(){
        Ember leghosszabb = lista.get(0);
        for (Ember item : lista){
            if (item.getNev().length()>leghosszabb.getNev().length()){
                leghosszabb=item;
            }
        }
        System.out.printf("A leghosszabb névvel rendelkező ember: %s, életkora: %d\n", leghosszabb.getNev(), leghosszabb.getEletkor());

    }

    public static void eletkorAtlag(){
        double kor = 0;
        for (Ember item : lista){
            kor += item.getEletkor();
        }
        System.out.println("Átlagéletkor: " + (kor/lista.size()));
    }
}
/* *
1. feladat:
Hozz létre egy fájlt adatok.txt néven, és írj bele több sort (pl. neveket és életkorokat).
Írj egy programot, amely:

- Beolvassa az összes sort,
- Kiírja a leghosszabb nevet,
- Kiszámítja az életkorok átlagát.

FileWriter writer = new FileWriter("pelda.txt", true);
* */