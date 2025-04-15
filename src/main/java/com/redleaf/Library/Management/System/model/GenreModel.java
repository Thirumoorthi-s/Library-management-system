package com.redleaf.Library.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class GenreModel {
    @Id
    private int id;

    private String genreName;
    private int librarySectionId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getLibrarySectionId() {
        return librarySectionId;
    }

    public void setLibrarySectionId(int librarySectionId) {
        this.librarySectionId = librarySectionId;
    }

}
