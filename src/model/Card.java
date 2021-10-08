package model;

import java.time.LocalDate;

public class Card {
    private String codeOfCard;
    private LocalDate dayBorrow;
    private LocalDate datePay;
    private Book book;
    private Student student;

    public LocalDate getExp(){
        return dayBorrow.plusMonths(1);
    }

    public Card(String codeOfCard, LocalDate dayBorrow, LocalDate datePay, Student student) {
        this.codeOfCard = codeOfCard;
        this.dayBorrow = dayBorrow;
        this.datePay = datePay;
        this.student = student;
    }

    public Card(Student student, String codeOfCard) {
        this.student = student;
        this.codeOfCard = codeOfCard;
    }

    public Card(String codeOfCard, LocalDate dayBorrow, LocalDate datePay) {
        this.codeOfCard = codeOfCard;
        this.dayBorrow = dayBorrow;
        this.datePay = datePay;
    }

    public Card(String codeOfCard, LocalDate dayBorrow, LocalDate datePay, Book book, Student student) {
        this.codeOfCard = codeOfCard;
        this.dayBorrow = dayBorrow;
        this.datePay = datePay;
        this.book = book;
        this.student = student;
    }

    public String getCodeOfCard() {
        return codeOfCard;
    }

    public void setCodeOfCard(String codeOfCard) {
        this.codeOfCard = codeOfCard;
    }

    public LocalDate getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(LocalDate dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Card{" +
                "codeOfCard='" + codeOfCard + '\'' +
                ", dayBorrow=" + dayBorrow +
                ", datePay=" + datePay +
                ", book=" + book +
                ", student=" + student +
                '}';
    }
}
