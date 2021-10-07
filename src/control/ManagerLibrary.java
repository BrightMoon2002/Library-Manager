package control;

import model.Book;
import model.Card;
import model.Student;

import java.util.ArrayList;

public class ManagerLibrary {
    ArrayList<Card> cardArrayList = new ArrayList<>();
    ArrayList<Book> bookArrayList = new ArrayList<>();
    ArrayList<Student> studentArrayList = new ArrayList<>();


    public ManagerLibrary(ArrayList<Card> cardArrayList, ArrayList<Book> bookArrayList, ArrayList<Student> studentArrayList) {
        this.cardArrayList = cardArrayList;
        this.bookArrayList = bookArrayList;
        this.studentArrayList = studentArrayList;
    }

    public ManagerLibrary(ArrayList<Card> cardArrayList, ArrayList<Student> studentArrayList) {
        this.cardArrayList = cardArrayList;
        this.studentArrayList = studentArrayList;
    }

    public ManagerLibrary() {
    }

    public ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    public void setCardArrayList(ArrayList<Card> cardArrayList) {
        this.cardArrayList = cardArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public void addBook(Book book) {
        bookArrayList.add(book);
    }

    public void removeBook(int index) {
        bookArrayList.remove(index);
    }

    public void setBookByIndex(int index, Book newBook) {
        bookArrayList.set(index, newBook);
    }

    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    public void removeStudent(int index) {
        studentArrayList.remove(index);
    }

    public void setStudent(int index, Student student) {
        studentArrayList.set(index, student);
    }

    public void addCard(Card card) {
        cardArrayList.add(card);
    }

    public void removeCard(int index) {
        cardArrayList.remove(index);
    }

    public void setCard(int index, Card card) {
        cardArrayList.set(index, card);
    }

    public void showAllStudentList() {
        for (Student student : studentArrayList
        ) {
            System.out.println(student);
        }
    }

    public void showAllShowBookList() {
        for (Book book : bookArrayList.toArray(new Book[0])
        ) {
            System.out.println(book);
        }

    }

    public void showAllCardList() {
        for (Card card : cardArrayList
        ) {
            System.out.println(card);
        }

    }

    public Book searchTypeOfBook (String code) {
        Book book = null;
        for (int i = 0; i < bookArrayList.size(); i++) {
            if (bookArrayList.get(i).getCodeOfBook().equals(code)) {
                book = getBookArrayList().get(i);
                break;
            }
        }
        return book;
    }

    public Student searchStudentById (String codeOfStudent) {
        Student student = null;
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getCodeStudent().equals(codeOfStudent)) {
                student = studentArrayList.get(i);
                break;
            }
        }
        return  student;
    }

    public Card searchCardByCodeOfCard (String codeOfCard) {
        Card card =  null;
        for (int i = 0; i < cardArrayList.size(); i++) {
            if (cardArrayList.get(i).getCodeOfCard().equals(codeOfCard)) {
                card = cardArrayList.get(i);
                break;
            }
        }
        return  card;
    }
}
