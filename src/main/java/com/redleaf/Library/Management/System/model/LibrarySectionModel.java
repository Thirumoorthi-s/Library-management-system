package com.redleaf.Library.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "librarySection")
public class LibrarySectionModel {
    @Id
    private int id;
    private String librarySectionName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibrarySectionName() {
        return librarySectionName;
    }

    public void setLibrarySectionName(String librarySectionName) {
        this.librarySectionName = librarySectionName;
    }
}
