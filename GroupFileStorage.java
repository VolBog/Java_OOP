package Lesson3;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GroupFileStorage {
    public static void saveGroupToCSV(Group gr) {
        File file = new File(gr.getName() + ".csv");
        try (PrintStream fileStream  = new PrintStream(file)) {
            for (Student s : gr.getStudents()) {
                if (s != null) {
                    fileStream.println(s.toCSVString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Group loadGroupFromCSV(File file) {
        if (!file.isFile()) {
            return null;
        }
        Group group = new Group(file.getName().replaceFirst("[.][^.]+$", ""));
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNextLine()) {
                group.addStudent(new Student().fromCSVString(scanner.nextLine()));
            }
        } catch (FileNotFoundException | StudentException e) {
            e.printStackTrace();
        }
        return group;
    }

    public static File findFileByGroupName(String groupName, File workFolder) throws IOException {
        if (!workFolder.isDirectory()) {
            throw new IOException();
        }
        File file = null;
        for (File f :
                workFolder.listFiles()) {
            if(f.isFile()) {
                System.out.println(f.getName());
                String[] names = f.getName().toString().split("\\.");
                if (names.length > 0 && names[0].equals(groupName)) {
                    file = f;
                    break;
                }
            }
        }
        return file;
    }
}
