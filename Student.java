package Lesson3;

import Lesson3.Interface.CSVConverter;

public class Student extends Human implements CSVConverter {
    private Group group;
    private long recordBook = 0;

    public Student() {
    }

    public Student(String name, String surname, int age, Sex sex) {
        super(name, surname, age, sex);
    }

    public Student(String name, String surname, int age, Sex sex, long recordBook) {
        super(name, surname, age, sex);
        this.recordBook = recordBook;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public long getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(long recordBook) {
        this.recordBook = recordBook;
    }

    @Override
    public void getInformation() {
        super.getInformation();
        System.out.println("Імя: " + super.getName() +
                ", прізвище: " + super.getSurname() +
                ", вік: " + super.getAge() +
                ", sex: " + super.getSex() +
                " заліковка: " + this.getRecordBook() +
                " група: " + group.getName());
    }

    @Override
    public String toCSVString() {
        String separator = ";";
        String csvLine = super.getName() + separator + super.getSurname() + separator +
                super.getAge() + separator + super.getSex() + separator + this.getRecordBook() + separator;

        return csvLine;
    }

    @Override
    public Student fromCSVString(String str) {
        String[] strings = str.split(";");
        return new Student(strings[0], strings[1], Integer.parseInt(strings[2]), Sex.valueOf(strings[3]), Long.parseLong(strings[4]));
    }

    @Override
    public String toString() {
        String data = "Імя: " + super.getName() +
                ", прізвище: " + super.getSurname() +
                ", вік: " + super.getAge() +
                ", sex: " + super.getSex() +
                " заліковка: " + this.getRecordBook();
        if (group != null) {
            data += " група: " + group.getName();
        }
        return data;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Student student = (Student) object;

        if (recordBook != student.recordBook) return false;
        if (group != null ? !group.equals(student.group) : student.group != null) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (int) (recordBook ^ (recordBook >>> 32));
        return result;
    }
}
