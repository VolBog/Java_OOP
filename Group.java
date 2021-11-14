
import java.util.*;

public class Group {
    private static long maxRecordBook;
    private String name;
    private List<Student> students = new ArrayList<>();
    private int capacity = 10;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) throws StudentException {
        if (students.size() <= capacity) {
            student.setGroup(this);
            if (student.getRecordBook() == 0) {
                student.setRecordBook(++maxRecordBook);
            }
            students.add(student);
        } else {
            throw new StudentException();
        }
    }

    public void deleteStudent(String surname) {
        Student student = this.find(surname);
        if(student != null){
            students.remove(student);
            student.setGroup(null);
        }
    }

    public Student find(String surname) {
        return students.stream().filter(s -> surname.equalsIgnoreCase(s.getSurname())).findAny().orElse(null);
    }

    public Student find(int recordBook) {
       return students.stream().filter(s -> recordBook == s.getRecordBook()).findAny().orElse(null);
    }

    public void sortStudentsByLastName() {
        students.sort(new SortByLastNameComparator());
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        sortStudentsByLastName();
        String group = "Група " + this.name;
        for (Student student :
                students) {
            if (student != null) {
                group += "\n" + student.toString();
            }
        }
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (capacity != group.capacity) return false;
        if (!name.equals(group.name)) return false;
        return students.equals(group.students);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + students.hashCode();
        result = 31 * result + capacity;
        return result;
    }

    public boolean isEquals() {
        return students.stream().allMatch(new HashSet<>()::add);
    }
}
