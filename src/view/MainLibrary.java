package view;

import control.ManagerLibrary;
import model.Book;
import model.Card;
import model.Student;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class MainLibrary {

    public static void main(String[] args) {
        System.out.println("LibraryManager, Author is Nguyễn Hoàng Duy - C0821H1");

        ArrayList<Book> bookArrayList = new ArrayList<>();
        ArrayList<Card> cardArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        ManagerLibrary managerLibrary = new ManagerLibrary(cardArrayList, bookArrayList, studentArrayList);

        menuManager(managerLibrary);

    }

    public static void menuManager(ManagerLibrary managerLibrary) {
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
            System.out.println("10. show book list");
            System.out.println("11. show student list");
            System.out.println("12. show card list");
            System.out.println("13. Student find and borrow any books");
            System.out.println("14. List of date book need to pay in end of the month:");
            System.out.println("0. Exit");

            Scanner inputChoice = new Scanner(System.in);
            int choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    managerLibrary.addStudent(creatStudent());
                    managerLibrary.showAllStudentList();
                    break;
                case 2:
                    addCard(managerLibrary);
                    managerLibrary.showAllCardList();
                    break;
                case 3:
                    managerLibrary.addBook(creatNewBook());
                    managerLibrary.showAllShowBookList();
                    break;

                case 4:
                    managerLibrary.getStudentArrayList().set(managerLibrary.getStudentArrayList().indexOf(managerLibrary.searchStudentById(inputCodeOfStudent())), creatStudent());
                    break;
                case 5:
                    setCard(managerLibrary);
                    break;
                case 6:
                    managerLibrary.getBookArrayList().set(managerLibrary.getBookArrayList().indexOf(managerLibrary.searchBook(inputCodeOfBook())), creatNewBook());
                    break;
                case 7:
                    managerLibrary.getStudentArrayList().remove(managerLibrary.searchStudentById(inputCodeOfStudent()));
                    break;
                case 8:
                    managerLibrary.getCardArrayList().remove(managerLibrary.searchCardByCodeOfCard(inputCodeOfCard()));
                    break;
                case 9:
                    managerLibrary.getBookArrayList().remove(managerLibrary.searchBook(inputCodeOfBook()));
                    break;
                case 10:
                   managerLibrary.showAllShowBookList();
                    break;
                case 11:
                    managerLibrary.showAllStudentList();
                    break;
                case 12:
                    managerLibrary.showAllCardList();
                    break;
                case 13:
                    BorrowBook(managerLibrary);
                    break;
                case 14:
                    showALlBookPayAtEndOfMonth(managerLibrary);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void showALlBookPayAtEndOfMonth(ManagerLibrary managerLibrary) {
        for (Card card: managerLibrary.getCardArrayList()
             ) {
            YearMonth yearMonth = YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonth());
            if (DAYS.between(card.getDatePay(), yearMonth.atEndOfMonth()) >= 0) {
                System.out.println(card);
            }
        }
    }

    private static void addCard(ManagerLibrary managerLibrary) {
        System.out.println("enter the code of Student:");
        Scanner codeOfStudent = new Scanner(System.in);
        String codeS = codeOfStudent.nextLine();
        Student studentCheck = managerLibrary.searchStudentById(codeS);
        if (studentCheck != null) {
            Card cardNew = CreatNewCard(studentCheck);
            managerLibrary.getCardArrayList().add(cardNew);
        } else {
            System.out.println("Cant find student");
        }
    }

    private static void setCard(ManagerLibrary managerLibrary) {
        String codeOfCard = inputCodeOfCard();
        Student studentC = managerLibrary.searchStudentById(codeOfCard);
        if (studentC != null) {
            Card cardNew = CreatNewCard(studentC);
            managerLibrary.getCardArrayList().set(managerLibrary.getCardArrayList().indexOf(managerLibrary.searchCardByCodeOfCard(codeOfCard)), cardNew);
        } else {
            System.out.println("Cant set card");
        }
    }

    private static void BorrowBook(ManagerLibrary managerLibrary) {
        Card card = managerLibrary.searchCardByCodeOfCard(inputCodeOfCard());
        if (card != null) {
            Book book = managerLibrary.searchBook(inputCodeOfBook());
            if (book != null) {
                if (book.isStatus()) {
                    addBookToCard(managerLibrary, card, book);
                } else {
                    System.out.println("someone take it before");
                }
            } else {
                System.out.println("No book has this code in library");
            }
        } else {
            System.out.println("Cant find the Code of card");
        }
    }

    private static void addBookToCard(ManagerLibrary managerLibrary, Card card, Book book) {
        managerLibrary.getCardArrayList().indexOf(card);
        book.setStatus(false);
        card.setBook(book);

        System.out.println("Enter the day borrow");
        LocalDate dayBorrow = fillDayBorrowAndPay();
        card.setDayBorrow(dayBorrow);
        card.setDatePay(managerLibrary.checkDateOfBook(managerLibrary.getBookArrayList().indexOf(book), managerLibrary.getCardArrayList().indexOf(card)));
        managerLibrary.getCardArrayList().set(managerLibrary.getCardArrayList().indexOf(card), card);
    }

    private static LocalDate fillDayBorrowAndPay() {
        System.out.println("Enter the year:");
        Scanner number = new Scanner(System.in);
        int year = number.nextInt();
        System.out.println("Enter the month");
        int month = number.nextInt();
        System.out.println("Enter the day");
        int day = number.nextInt();
        return LocalDate.of(year, month, day);
    }


    private static Card CreatNewCard(Student studentCheck) {
        String codeOfCard = inputCodeOfCard();
        return new Card(studentCheck, codeOfCard);

    }

    private static String inputCodeOfCard() {
        System.out.println("Enter the code of card");
        Scanner inputCard = new Scanner(System.in);
        return inputCard.nextLine();
    }

    private static String inputCodeOfBook() {
        System.out.println("Enter the code of book");
        Scanner inputCodeOfBook = new Scanner(System.in);
       return inputCodeOfBook.nextLine();

    }

    private static String inputCodeOfStudent() {
        System.out.println("Enter the code of Student you want to change:");
        Scanner inputCodeOfStudent = new Scanner(System.in);
        return inputCodeOfStudent.nextLine();
    }

    private static Book creatNewBook() {
        System.out.println("Enter the Name of Book:");
        Scanner inputNameOfBook = new Scanner(System.in);
        String nameB = inputNameOfBook.nextLine();
        System.out.println("Enter the Code of Book");
        Scanner inputCodeOfBook = new Scanner(System.in);
        String codeB = inputCodeOfBook.nextLine();
        System.out.println("Enter the Type of Book");
        Scanner inputKindOfBook = new Scanner(System.in);
        String kindB = inputKindOfBook.nextLine();
        return new Book(codeB, nameB, kindB);
    }

    private static Student creatStudent() {
        System.out.println("Enter the Student Name:");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Enter the Student code " + name);
        Scanner inputCode = new Scanner(System.in);
        String code = inputCode.nextLine();
        System.out.println("Enter the DoB of Student " + name);
        Scanner inputDoB = new Scanner(System.in);
        String dOB = inputDoB.nextLine();
        System.out.println("Enter the CLass of Student" + name);
        Scanner inputClass = new Scanner(System.in);
        String classOfStudent = inputClass.nextLine();
        return new Student(name, code, dOB, classOfStudent);
    }
}

