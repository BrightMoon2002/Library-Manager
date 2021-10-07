package model;

public class Book {
    private String codeOfBook;
    private String nameOfBook;
    private String typeOfBook;
    private boolean status;

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
        this.status = true;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "codeOfBook='" + codeOfBook + '\'' +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", typeOfBook='" + typeOfBook + '\'' +
                ", status=" + status +
                '}';
    }
}
