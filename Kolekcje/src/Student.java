import java.io.Serializable;
import java.util.HashMap;

public class Student implements Serializable {
    String imie;
    String nazwisko;

    HashMap<String, Integer> oceny = new HashMap<String, Integer>();

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public Student(String imie, String nazwisko, int ocena1, int ocena2, int ocena3) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        oceny.put("Zestaw1",ocena1);
        oceny.put("Zestaw2",ocena2);
        oceny.put("Zestaw3",ocena3);
    }



    public float getSrednia(){
        int temp = 0;
        for (Integer i : oceny.values())
        {
         temp+=(int)i;
        }

        return (float) ((float)temp/3.0);
    }
}
