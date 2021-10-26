package Lesson3;

public class Student extends Human implements Comparable<Student> {
    private Group group;

    public Student() {
    }

    public Student(String name, String surname, int age, Sex sex) {
        super(name, surname, age, sex);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void getInformation() {
        super.getInformation();
    }

    @Override
    public int compareTo(Student student) {
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
        return getSurname().compareTo(student.getSurname());
    }
}
