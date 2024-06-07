/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Phong
 */
public interface I_Collection<T> {
    void add(T item);
    void update(T item);
    void delete(String id);
    T getById(String id);
    List<T> getAll();
}
