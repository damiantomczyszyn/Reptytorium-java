import java.io.Serializable;

class Adres implements Serializable {
    String miasto;
    String ulica;
    String nrDomu;
    String nrLokalu;
    Adres(String miasto, String ulica, String nrDomu, String nrLokalu) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        System.out.println("wywołanie konstruktora klasy Adres");
    }
    public String toString() {
        String adrPamięć = super.toString();
        return adrPamięć + "(" + miasto + ", " +
                ulica + ", " +
                nrDomu + ", " +
                nrLokalu + ")";
    }
}