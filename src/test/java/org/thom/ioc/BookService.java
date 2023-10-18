package org.thom.ioc;

public class BookService {

    @Inject
    BookRepository bookRepository;

    public String printOther() {
        return bookRepository.name;
    }

}
