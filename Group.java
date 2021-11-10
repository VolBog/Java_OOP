package Lesson3;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private static long maxRecordBook;
    private String name;
    private Student[] students = new Student[10];

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) throws StudentException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                if (student.getRecordBook() == 0) {
                    student.setRecordBook(++maxRecordBook);
                }
                students[i] = student;
                student.setGroup(this);
                return;
            }
        }
        throw new StudentException();
    }

    public void deleteStudent(String surname) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getSurname().equalsIgnoreCase(surname)) {
                students[i].setGroup(null);
                students[i] = null;
                break;
            }
        }
    }

    public Student find(String surname) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getSurname().equalsIgnoreCase(surname)) {
                return students[i];
            }
        }
        return null;
    }

    public Student find(int recordBook) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getRecordBook() == recordBook) {
                return students[i];
            }
        }
        return null;
    }

    public void sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsFirst(new SortByLastNameComparator()));
    }


    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Group group = (Group) object;

        if (!name.equals(group.name)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!java.util.Arrays.equals(students, group.students)) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }

    public boolean isEquals() {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if(i != j && students[i].equals(students[j])){
                    return true;
                }
            }
        }
        return false;
    }
}
