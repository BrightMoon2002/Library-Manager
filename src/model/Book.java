package model;

public class Book {
    private String codeOfBook;
    private String nameOfBook;
    private String typeOfBook;
    private boolean status = true;

    public String getCodeOfBook() {
        return codeOfBook;
    }

    public void setCodeOfBook(String codeOfBook) {
        this.codeOfBook = codeOfBook;
    }

    public Book(String codeOfBook, String nameOfBook, String typeOfBook) {
        this.codeOfBook = codeOfBook;
        this.nameOfBook = nameOfBook;
        this.typeOfBook = typeOfBook;
    }

    public Book(String codeOfBook, String nameOfBook, String typeOfBook, boolean status) {
        this.codeOfBook = codeOfBook;
        this.nameOfBook = nameOfBook;
        this.typeOfBook = typeOfBook;
        this.status = status;
    }

    public Book() {
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(String typeOfBook) {
        this.typeOfBook = typeOfBook;
    }
}
