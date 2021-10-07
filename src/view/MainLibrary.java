package view;

import control.ManagerLibrary;
import model.Book;
import model.Card;
import model.Student;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLibrary {

    public static void main(String[] args) {
        System.out.println("LibraryManager, Author is Nguyễn Hoàng Duy - C0821H1");

        ArrayList<Book> bookArrayList = new ArrayList<>();
        ArrayList<Card> cardArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        ManagerLibrary managerLibrary = new ManagerLibrary(cardArrayList, bookArrayList, studentArrayList);


    }

    public void MenuManager(ManagerLibrary managerLibrary) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add student");
            System.out.println("2. Add card");
            System.out.println("3. Add book");
            System.out.println("4. Set student");
            System.out.println("5. Set card");
            System.out.println("6. Set Book");
            System.out.println("7. Remove Student");
            System.out.println("8. Remove card");
            System.out.println("9. remove Book");
            System.out.println("10. Search student by code");
            System.out.println("11. Search card by code");
            System.out.println("12. Search book by code");
            System.out.println("13. show student list");
            System.out.println("14. show card list");
            System.out.println("15. List of date book need to pay in end of the month:");
            System.out.println("0. Exit");

            Scanner inputChoice = new Scanner(System.in);
            int choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Student Name:");
                    Scanner inputName = new Scanner(System.in);
                    String name = inputName.nextLine();
                    System.out.println("Enter the Student code " + name);
                    Scanner inputCode =  new Scanner(System.in);
                    String code = inputCode.nextLine();
                    System.out.println("Enter the DoB of Student " + name);
                    Scanner inputDoB = new Scanner(System.in);
                    String dOB = inputDoB.nextLine();
                    System.out.println("Enter the CLass of Student" + name);
                    Scanner inputClass = new Scanner(System.in);
                    String classOfStudent = inputClass.nextLine();
                    Student student = new Student(name, code, dOB, classOfStudent);
                    managerLibrary.addStudent(student);
                    break;
                case 2:
                    System.out.println("enter the code of Student:");
                    Scanner codeOfStudent = new Scanner(System.in);
                    String codeS = codeOfStudent.nextLine();
                    Student studentCheck = managerLibrary.searchStudentById(codeS);
                    if (studentCheck != null) {
                        System.out.println("Enter the card");
                        Scanner inputCard =  new Scanner(System.in);
                        String card = inputCard.nextLine();
                        System.out.println("Enter the day borrow");
                        System.out.println("Enter the year:");
                        Scanner number = new Scanner(System.in);
                        int year = number.nextInt();
                        System.out.println("Enter the month");
                        int month = number.nextInt();
                        System.out.println("Enter the day");
                        int day = number.nextInt();
                        LocalDate dayBorrow = LocalDate.of(year, month, day);
                        Card cardNew = new Card(studentCheck);
                        managerLibrary.getCardArrayList().add(cardNew);
                    }
                    managerLibrary.searchStudentById(codeS);

            }
        }
    }
}
}
