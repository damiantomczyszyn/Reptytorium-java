public class Main {

    public void dzielenie(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Nie wolno dzielić przez zero");
        }
    }
    public void addElement(String element){
        try {
            for (int i = 0; i <= tab.length + 1; i++)
                tab[i] = "element";
            // obsługa takiego błędu jest potrzebna
            //
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("chcesz dodac zaduzo elementow");
        }
    }


    public static void main(String[] args) {

    }
    String[]tab ={"Rohit","Shikar","Virat","Dhoni"};



}



