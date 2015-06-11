package com.xyzcorp;

import java.time.LocalDate;

public class Checkout {
    private final LocalDate checkoutDate;
    private Member member;
    private Book book;

    public Checkout(Member member, Book book, LocalDate checkoutDate) {
        this.member = member;
        this.book = book;
        this.checkoutDate = checkoutDate;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }
}
