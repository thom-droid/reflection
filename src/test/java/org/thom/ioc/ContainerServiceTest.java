package org.thom.ioc;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {

    @Test
    public void isBookRepositoryNotNull() {

        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);

    }

    @Test
    public void isBookServiceNotNullWhileItsFieldIsNull() {
        BookService bookService = ContainerService.getObject(BookService.class);

        assertNotNull(bookService);
        assertNull(bookService.bookRepository); // not initiated
    }

    @Test
    public void isBookRepositoryInjectedIntoBookService() {

        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);

        Class<? extends BookRepository> aClass = bookRepository.getClass();
        Inject inject = aClass.getDeclaredAnnotation(Inject.class);

        if (inject != null) {

            BookService bookService = ContainerService.getObject(BookService.class);
            Field bookRepository1 = null;

            try {
                bookRepository1 = BookService.class.getDeclaredField("bookRepository");
                bookRepository1.setAccessible(true);
                bookRepository1.set(bookService, bookRepository);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            assertNotNull(bookService.bookRepository);
            assertEquals("name", bookService.printOther());
        }
    }

    @Test
    public void containerInjects() throws ClassNotFoundException {

        BookService injectedBookService = ContainerService.getInjectedInstance(BookService.class);

        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);

        assertNotNull(injectedBookService);
        assertNotNull(injectedBookService.bookRepository);
        assertEquals(injectedBookService.bookRepository.name, bookRepository.name);
        assertNotEquals(injectedBookService.bookRepository, bookRepository);

    }



}