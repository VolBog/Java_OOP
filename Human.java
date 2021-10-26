package Lesson3;

public class Human {
    private String name;
    private String surname;
    private int age;
    private Sex sex;

    public Human() {
    }

    public Human(String name, String surname, int age, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void getInformation() {
        System.out.println("Імя: " + name +
                ", прізвище: " + surname +
                ", вік: " + age +
                ", sex: " + sex);
    }

    @Override
    public String toString() {
        return "Імя: " + name +
                ", прізвище: " + surname +
                ", вік: " + age +
                ", sex: " + sex;
    }
}
