import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Ember> lista = new ArrayList<>();
    static ArrayList<Ember> nagykoruak=new ArrayList<>();
    static ArrayList<Ember> kiskoruak=new ArrayList<>();
    public static void main(String[] args) {
        fajlBeOlvasas();
        for (Ember item : lista){
            System.out.println(item);
        }
        leghosszabbNev();
        eletkorAtlag();
        nagyKoruak();
        kiir(nagykoruak, "A nagykorú emberek: ");
        System.out.println("----------------------------------------------------");
        kiir(kiskoruak, "A kiskorúak:");

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

    public static void nagyKoruak(){

        for (Ember item : lista){
            if (item.getEletkor()>=18){
                nagykoruak.add(item);
            }
            else {
                kiskoruak.add(item);
            }
        }


    }
    public static void kiir(ArrayList<Ember> lista, String szoveg){
        System.out.println(szoveg);
        for (Ember item: lista){
            System.out.println(item);
        }
    }
}
/* *
1. feladat:
Hozz létre egy fájlt adatok.txt néven, és írj bele több sort (pl. neveket és életkorokat).
Írj egy programot, amely:

- Beolvassa az összes sort,
- Kiírja a leghosszabb nevet,
- Kiszámítja az életkorok átlagát.
- gyűjtsük ki 2 új listába, HOGY kik vásárolhatnak dohányboltban és kik nem.

FileWriter writer = new FileWriter("pelda.txt", true);
* */