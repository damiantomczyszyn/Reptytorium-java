public class Film {
    private int kod;
    private int wolneMiejsca;
    private int iloscZajetychMiejsc;
    Osoba [] miejsca;

    public Film(int kod, int wolneMiejsca) {
        this.kod = kod;
        this.wolneMiejsca = wolneMiejsca;
        this.iloscZajetychMiejsc = 0;
        this.miejsca = new Osoba[wolneMiejsca];
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public int getWolneMiejsca() {
        return wolneMiejsca;
    }

    public void setWolneMiejsca(int wolneMiejsca) {
        this.wolneMiejsca = wolneMiejsca;
    }

    public int getIloscZajetychMiejsc() {
        return iloscZajetychMiejsc;
    }

    public void setIloscZajetychMiejsc(int iloscZajetychMiejsc) {
        this.iloscZajetychMiejsc = iloscZajetychMiejsc;
    }

    public Osoba[] getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(Osoba[] miejsca) {
        this.miejsca = miejsca;
    }

    public String toString(){
       StringBuilder builder= new StringBuilder("Kod filmu "+kod+" Miejsca: ");

       for( int i =0 ; i<iloscZajetychMiejsc;i++)
       {
            builder.append("[ ");
            builder.append(miejsca[i].getImie()+" "+miejsca[i].getNazwisko());
            builder.append(" ]");
       }
        for( int i =0 ; i<wolneMiejsca;i++)
        {
            builder.append("[ ");
            builder.append("wolne");
            builder.append(" ]");
        }
       return builder.toString();
    }
    public void addOsoba(Osoba osoba) throws BrakWolnychMiejscException {
        if (wolneMiejsca==0)
            throw new BrakWolnychMiejscException(this,"Wyjatek brak miejsc");
        miejsca[iloscZajetychMiejsc]=osoba;
        iloscZajetychMiejsc++;
        wolneMiejsca--;
    }
}
