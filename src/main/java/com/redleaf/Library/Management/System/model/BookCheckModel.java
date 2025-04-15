package com.redleaf.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bookcheck")
public class BookCheckModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bookId;
    private int subgenreId;


    public BookCheckModel() {
    }

    public BookCheckModel(int bookId, int subgenreId) {
        this.bookId = bookId;
        this.subgenreId = subgenreId;
    }
}

