package Lesson3;

public class StudentException extends Exception{


    @Override
    public String getMessage() {
        return "Too much students";
    }
}
