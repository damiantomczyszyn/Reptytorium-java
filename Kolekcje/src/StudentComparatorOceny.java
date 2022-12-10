import java.util.Comparator;

public class StudentComparatorOceny implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        return Float.compare(student.getSrednia(), t1.getSrednia());

    }
}
