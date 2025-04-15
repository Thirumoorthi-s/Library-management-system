package com.redleaf.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subgenre")
public class SubgenreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subgenreName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int genreId;


    public String getSubgenreName() {
        return subgenreName;
    }

    public void setSubgenreName(String subgenreName) {
        this.subgenreName = subgenreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }


}
