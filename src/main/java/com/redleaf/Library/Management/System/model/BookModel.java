package com.redleaf.Library.Management.System.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookTitle;
    private String authorName;
    private String isbn;
    private String publisher;
    private int publisherYear;
    private String librarySectionName;
    private String genre;
    private int numberOfCopies;
    private String bookFormat;
    private String languageName;
    private String bookAvailability;


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getLibrarySectionName() {
        return librarySectionName;
    }

    public void setLibrarySectionName(String librarySectionName) {
        this.librarySectionName = librarySectionName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }


    public String getBookAvailability() {
        return bookAvailability;
    }

    public void setBookAvailability(String bookAvailability) {
        this.bookAvailability = bookAvailability;
    }


    public String getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(String bookFormat) {
        this.bookFormat = bookFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getPublisherYear() {
        return publisherYear;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setPublisherYear(int publisherYear) {
        this.publisherYear = publisherYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }





}
