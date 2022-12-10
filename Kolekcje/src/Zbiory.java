import java.util.*;

import static java.lang.System.exit;

public class Zbiory {
    Scanner scan = new Scanner(System.in);
    private Set<Integer> setA = new HashSet<Integer>(Arrays.asList(1,2,3,4));
    private Set<Integer> setB = new HashSet<Integer>(Arrays.asList(1,2,6,8));



    private void AddElement(int zbior){
        System.out.println("Podaj liczbe ktore ma byc dodane do zbioru");
        int temp = scan.nextInt();
        if (zbior==0){
            setA.add(temp);
        }
        if (zbior==1){
            setB.add(temp);
        }

    }
    private void RemoveElement(int zbior){
        System.out.println("Podaj imie ktore ma byc usuniete ze zbioru");
        int temp=scan.nextInt();
        if (zbior==0){
            setA.remove(temp);
        }
        if (zbior==1){
            setB.remove(temp);
        }
    }
    private void Operacje(){
        System.out.println("Wyliczenie sumy");
        Set<Integer> temp = new HashSet<>(setA);
        temp.addAll(setB);
        for ( Integer x:temp) {
            System.out.println((int)x);
        }
        System.out.println("Wyliczenie różnicy");
        Set<Integer> temp2 = new HashSet<>(setA);
        temp.removeAll(setB);
        for ( Integer x:temp2) {
            System.out.println((int)x);
        }
        System.out.println("Wyliczenie iloczynu");
        Set<Integer> temp3 = new HashSet<>(setA);
        temp.retainAll(setB);
        for ( Integer x:temp3) {
            System.out.println((int)x);
        }
    }
    public void Menu(){
        int opcja=0;
        System.out.println("1- dodanie nowego elementu, 2-usuwanie elementu, 3- wyliczanie sumy, różnicy, iloczynu danych zbiorow ,4- wyjscie");
        while (true){
        System.out.println("Podaaj numer odpowiadajacy wybranej opcji");
        opcja = scan.nextInt();
        switch (opcja){
            case 1:
                System.out.println("Podaj numer zbioru do którego chcesz dodać element 1/2");
                AddElement(scan.nextInt());
                break;
            case 2:
                System.out.println("Podaj numer zbioru z którego chcesz usunąć element 1/2");
                RemoveElement(scan.nextInt());
                break;
            case 3:
                Operacje();

            default:
                System.out.println("Niepoprawna opcja - wyjscie");
                exit(0);
                break;
        }}
    }

}
