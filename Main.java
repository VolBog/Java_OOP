package Lesson3;

public class Main {
    public static void main(String[] args) {
        Group group = new Group("А");

        for (int i = 0; i < 11; i++) {
            try {
                group.addStudent(new Student("Vasia" + i, "Ivanov" + i, i, Sex.MALE));
            } catch (StudentException e) {
                System.out.println(e.getMessage());
            }
        }
        group.deleteStudent("Ivanov5");

        try {
            group.addStudent(new Student("Ivanka", "Anina" , 16, Sex.FEMALE));
        } catch (StudentException e) {
            System.out.println(e);
        }
        System.out.println(group);
    }


}
