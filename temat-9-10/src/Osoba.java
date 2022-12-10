import java.io.Serializable;

class Osoba implements Serializable {
    String nazwisko;
    String imię;
    Adres adresZameldowania;
    Osoba(String nazwisko, String imię, Adres adresZameldowania) {
        this.nazwisko = nazwisko;
        this.imię = imię;
        this.adresZameldowania = adresZameldowania;
        System.out.println("wywołanie konstruktora klasy Osoba");
    }
    public String toString() {
        String adrPamięć = super.toString();
        return adrPamięć+"(" + nazwisko + ", " +
                imię + ", " +
                adresZameldowania + ")";
    }
}