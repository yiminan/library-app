package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    public BookService(
            BookRepository bookRepository,
            UserRepository userRepository,
            UserLoanHistoryRepository userLoanHistoryRepository
    ) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
        if (userLoanHistoryRepository.findByBookNameAndIsReturn(request.getBookName(), false) != null) {
            throw new IllegalArgumentException(String.format("%s는 이미 대출되어 있는 책입니다", request.getBookName()));
        }

        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.loanBook(book);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());
    }

    @Transactional
    public void saveBook(@NotNull BookRequest request) {
        Optional<Book> findBook = bookRepository.findByName(request.getName());
        if (findBook.isEmpty()) {
            bookRepository.save(new Book(request.getName()));
        }
    }
}
