import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
//https://www.geeksforgeeks.org/how-to-sort-arraylist-using-comparator/

public class Main {
    public static void main(String[] args) {
        HashSet<Student> students= new HashSet<Student>();
        students.add(new Student("Karol","Warol",4,4,4));
        students.add(new Student("Parot","Parol",5,4,5));
        students.add(new Student("Kuba","Garol",4,5,4));
        students.add(new Student("Marcin","Larol",4,2,2));
        students.add(new Student("Maciek","Marol",2,4,4));

        Iterator<Student> it = students.iterator();
        //////
        LinkedHashSet<Student> students2= new LinkedHashSet<>();
        students2.add(new Student("Karol","Warol",4,4,4));
        students2.add(new Student("Parot","Parol",5,4,5));
        students2.add(new Student("Kuba","Garol",4,5,4));
        students2.add(new Student("Marcin","Larol",4,2,2));
        students2.add(new Student("Maciek","Marol",2,4,4));

        Iterator<Student> it2 = students2.iterator();
        //////
        ArrayList<Student> students3= new ArrayList<>();
        students3.add(new Student("Karol","Warol",4,4,4));
        students3.add(new Student("Parot","Parol",5,4,5));
        students3.add(new Student("Kuba","Garol",4,5,4));
        students3.add(new Student("Marcin","Larol",4,2,2));
        students3.add(new Student("Maciek","Marol",2,4,4));

        Iterator<Student> it3 = students2.iterator();
///
        /*
        ArrayList internally uses a dynamic array to store the elements.
        An ArrayList class can act as a list only because it implements List only.
        ArrayList is better for storing and accessing data.


        HashSet uses a mechanism called "Hashing" to store the elements
        It contains unique elements.

LinkedHashSet
It uses a hashtable & a doubly-linked list to store & maintain the elements.
It contains unique elements.

         */

        System.out.println("Sortowania");
        StudentComparatorNazwisko studentComparatorNazwisko = new StudentComparatorNazwisko();
        StudentComparatorOceny studentComparatorOceny = new StudentComparatorOceny();

        System.out.println("przed sortowaniem  nazwiskami");
        for (Student x : students3)
        {
            System.out.println(x.nazwisko+" "+x.imie);
        }
        students3.sort(studentComparatorNazwisko);
        System.out.println("po sortowaniu nazwiskami");
        for (Student x : students3)
        {
            System.out.println(x.nazwisko+" "+x.imie);
        }
        students3.sort(studentComparatorOceny.reversed());// aby najwyzsza srednia byla jako pierwsza a nie ostatania
        System.out.println("po sortowaniu ocenami");
        for (Student x : students3)
        {
            System.out.println(x.nazwisko+" "+x.imie);
        }

    }




}