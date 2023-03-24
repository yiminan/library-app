package com.group.libraryapp.dto.book.request;

import org.jetbrains.annotations.NotNull;

public class BookLoanRequest {

    private String userName;
    private String bookName;

    public BookLoanRequest(@NotNull String userName, @NotNull String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookName() {
        return bookName;
    }

}
