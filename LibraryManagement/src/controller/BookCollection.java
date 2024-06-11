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

    private Map<String, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        books.put(book.getBookId(), book);
    }

    @Override
    public void update(Book book) {
        books.put(book.getBookId(), book);
    }

    @Override
    public void delete(String id) {
        Book book = books.get(id);
        if (book != null) {
            book.setActiveBook(false);
        }
    }

    @Override
    public Book getById(String id) {
        return books.get(id);
    }

    @Override
    public Map<String, Book> getAll() {
        return books;
    }
}
