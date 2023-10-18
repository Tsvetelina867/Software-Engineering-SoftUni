package IteratorsAndComparatorsLab;

import IteratorsAndComparatorsLab.Book;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }
    public Book getBookAt(int index) {
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator<Book>();
    }

    private class LibraryIterator<T> implements Iterator<Book> {
        int counter = 0;
        @Override
        public boolean hasNext() {
            return counter < books.length;
        }

        @Override
        public Book next() {
            return getBookAt(counter++);
        }
    }
}
