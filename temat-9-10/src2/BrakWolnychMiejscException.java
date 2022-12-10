class BrakWolnychMiejscException extends Exception
{
    BrakWolnychMiejscException(Film f, String info)
    {
        // Wywołanie konstruktora nadklasy: Exception(String)
        super("\n"+info+f.getKod()+"\n");
    }
    BrakWolnychMiejscException(Film f)
    {
        // Wywołanie pierwszego konstruktora tej klasy
        this(f,"Brak wolnych miejsc na film :");
    }
}
