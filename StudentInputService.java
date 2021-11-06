package Lesson3;

import java.util.Scanner;

public class StudentInputService {
    public static Student inputStudent() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть імя");
        student.setName(sc.next());
        System.out.println("Введіть прізвище");
        student.setSurname(sc.next());
        System.out.println("Введіть вік");
        boolean isCorrect = false;
        int age = 0;
        while (!isCorrect) {
            try {
                age = Integer.parseInt(sc.next());
                isCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Ви ввели не число");
            }
        }
        student.setAge(age);

        System.out.println("Введіть стать (для MALE введіть M для FEMALE введіть F)");
        String sex = "";
        while (isCorrect) {
            sex = sc.next();
            if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F")) {
                isCorrect = false;
            } else {
                System.out.println("Введіть для хлопця M");
                System.out.println("Введіть для дівчини F");
            }
        }
        student.setSex(Sex.get(sex));
        return student;
    }
}
