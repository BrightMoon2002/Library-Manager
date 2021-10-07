package model;

public class Student {
    private String name;
    private String codeStudent;
    private String DoB;
    private String classOfStudent;


    public Student(String name, String codeStudent, String doB, String classOfStudent) {
        this.name = name;
        this.codeStudent = codeStudent;
        DoB = doB;
        this.classOfStudent = classOfStudent;
    }


    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getClassOfStudent() {
        return classOfStudent;
    }

    public void setClassOfStudent(String classOfStudent) {
        this.classOfStudent = classOfStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", codeStudent='" + codeStudent + '\'' +
                ", DoB='" + DoB + '\'' +
                ", classOfStudent='" + classOfStudent + '\'' +
                '}';
    }
}
