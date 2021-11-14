
import java.util.Comparator;

public class SortByLastNameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student student1 = (Student) o1;
        Student student2 = (Student) o2;
        return student1.getSurname().compareTo(student2.getSurname());
    }
}
