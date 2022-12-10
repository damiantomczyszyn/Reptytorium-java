import java.io.*;
import java.util.LinkedHashSet;

public class ZapisOsob {
    LinkedHashSet<Student> students;

    public ZapisOsob(LinkedHashSet<Student> students) {
        this.students = students;
    }

    public void serialize() {
        try {

            FileOutputStream fos = new FileOutputStream("ListaOsob");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);

            oos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
