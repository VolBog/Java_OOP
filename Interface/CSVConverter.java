package Lesson3.Interface;

import Lesson3.Student;

public interface CSVConverter {

    public String toCSVString();

    public Student fromCSVString(String str);
}
