/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Book;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Phong
 */
public class BookCollection implements I_Collection<Book> {
    private Map<String, Book> books;

    public BookCollection() {
        books = new HashMap<>();
    }

    @Override
    public void add(Book book) {
        books.put(book.getBookId(), book);
    }

    @Override
    public void update(Book book) {
        if (books.containsKey(book.getBookId())) {
            books.put(book.getBookId(), book);
        }
    }

    @Override
    public void delete(String id) {
        if (books.containsKey(id)) {
            Book book = books.get(id);
            book.setActiveBook(false);
            books.put(id, book);
        }
    }

    @Override
    public Book getById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> getAll() {
        List<Book> activeBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isActiveBook()) {
                activeBooks.add(book);
            }
        }
        return activeBooks;
    }
}
