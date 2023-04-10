package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 돈을 보낸다.
     *
     * 101만원에서 1만원을 보낸다. -> 상대방은 1만원을 받고, 나는 1만원이 줄어든다.
     */
    @Transactional
    public void sendMoney(Money won) {
        won = 10_000
        // 1. 이민에게 1만원을 보낸다.
        // 2. 여울이에게 1만원을 빼았는다.
        // 3. 이민이에게 1만원을 넣어준다.
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        Book book = bookRepository.findByName(request.getBookName()).orElseThrow(IllegalArgumentException::new);
        if (userLoanHistoryRepository.findByBookNameAndIsReturn(request.getBookName(), false) != null) {
            throw new IllegalArgumentException("진작 대출되어 있는 책입니다");
        }

        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.loanBook(book);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        User user = userRepository.findByName(request.getUserName()).orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());
    }
}
