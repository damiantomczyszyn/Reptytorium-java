import java.util.Comparator;

public class StudentComparatorNazwisko implements Comparator<Student> {

    @Override
    public int compare(Student student, Student t1) {
        if (student.getNazwisko().compareTo(t1.getNazwisko())!=0)
        return student.getNazwisko().compareTo(t1.getNazwisko());
        else return student.getImie().compareTo(t1.getImie());
    }
}
