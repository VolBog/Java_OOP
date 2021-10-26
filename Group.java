package Lesson3;

import java.util.Arrays;

public class Group {
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

    @Override
    public String toString() {
        Arrays.sort(students);
        String group = "Група " + this.name;
        for (Student student :
                students) {
            group += "\n" + student.toString();
        }
        return group;
    }
}
