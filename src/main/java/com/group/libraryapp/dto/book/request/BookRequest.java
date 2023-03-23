package com.group.libraryapp.dto.book.request;

import org.jetbrains.annotations.NotNull;

public class BookRequest {

    private String name;

    public BookRequest(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
