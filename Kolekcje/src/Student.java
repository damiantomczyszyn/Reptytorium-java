public class Student {
    String imie;
    String nazwisko;
    int ocena1;
    int ocena2;
    int ocena3;

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

    public int getOcena1() {
        return ocena1;
    }

    public void setOcena1(int ocena1) {
        this.ocena1 = ocena1;
    }

    public int getOcena2() {
        return ocena2;
    }

    public void setOcena2(int ocena2) {
        this.ocena2 = ocena2;
    }

    public Student(String imie, String nazwisko, int ocena1, int ocena2, int ocena3) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena1 = ocena1;
        this.ocena2 = ocena2;
        this.ocena3 = ocena3;
    }

    public int getOcena3() {
        return ocena3;
    }

    public void setOcena3(int ocena3) {
        this.ocena3 = ocena3;
    }
    public float getSrednia(){
        int temp = ocena1+ocena2+ocena3;
        return (float) ((float)temp/3.0);
    }
}
