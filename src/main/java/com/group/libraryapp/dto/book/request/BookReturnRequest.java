package com.group.libraryapp.dto.book.request;

import org.jetbrains.annotations.NotNull;

public class BookReturnRequest {

    private String userName;
    private String bookName;

    public BookReturnRequest(@NotNull String userName, @NotNull String bookName) {
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
