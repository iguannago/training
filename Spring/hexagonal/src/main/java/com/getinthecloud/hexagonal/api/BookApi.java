package com.getinthecloud.hexagonal.api;

import com.getinthecloud.hexagonal.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookApi {

    @GetMapping(path = "/book/{id}")
    public Book getBook(@PathVariable String id) {
        return new Book(id, "Effective Java", "Joshua Bloch");
    }

    @GetMapping(path = "/home")
    public String getLibraryHome() {
        return "Welcome to the Library";
    }
}
