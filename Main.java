package Lesson3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Group group = new Group("А");

        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("Введіть кількість студентів");
        for(;;){

            try {
                n = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e){
                System.out.println("Введіть число");
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println("Введіть студента " + i);
            try {
                group.addStudent(StudentInputService.inputStudent());
            } catch (StudentException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        System.out.println(group);
        File f = new File(".");
        System.out.println(f.getAbsolutePath());

        File file =  GroupFileStorage.findFileByGroupName("A", f);

        Group g = GroupFileStorage.loadGroupFromCSV(file);
        System.out.println(g);
        GroupFileStorage.saveGroupToCSV(g);
    }


}
