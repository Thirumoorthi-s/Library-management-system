package com.redleaf.Library.Management.System.service;

import com.redleaf.Library.Management.System.model.*;
import com.redleaf.Library.Management.System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private LibrarySectionRepository librarySectionRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private SubgenreRepository subgenreRepository;

    @Autowired
    private BookCheckRepository bookCheckRepository;



    //get the books in table
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }



    //save the bookform
    public BookModel saveBook(BookModel bookModel) {
        bookRepository.save(bookModel);
        return bookModel;
    }



    //delete the values based on bookid
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }



    //show the form for edit
    public BookModel getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }



    public List<LanguageModel> getAllLanguageNames() {
        return languageRepository.findAllLanguageNames();
    }



    public List<LibrarySectionModel> getAllLibrarySectionNames() {
        return librarySectionRepository.findAllLibrarySectionNames();
    }



//    public List<GenreModel> getAllGenre(){
//        return genreRepository.findAllGenres();
//    }



    public List<GenreModel> findGenreByLibrarySectionId(int librarySectionId) {
        return genreRepository.findGenreByLibrarySectionId(librarySectionId);
    }



    public List<SubgenreModel> getSubgenreByGenreId(int genreId) {
        return subgenreRepository.findAllSubgenres(genreId);
    }



    public void saveSubgenres(int bookId, List<Long> subgenreIds){
        for (Long subgenreId : subgenreIds){
           subgenreRepository.save(new BookCheckModel(bookId,subgenreId.intValue()));
        }
    }


    public List<Integer> getSubgenres(int bookId){
        return bookCheckRepository.findSubgenresByGenreId(bookId);
    }


    @Transactional
    public void deleteSubgenres(int bookId){
        bookCheckRepository.deleteBookById(bookId);
    }


}
