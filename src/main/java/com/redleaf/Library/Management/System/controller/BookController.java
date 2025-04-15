package com.redleaf.Library.Management.System.controller;

import com.redleaf.Library.Management.System.model.*;
import com.redleaf.Library.Management.System.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/addBook")
    public String showBookForm(Model model){
        model.addAttribute("book", new BookModel());

        model.addAttribute("books", bookService.getAllBooks());

        List<LibrarySectionModel> librarySections = bookService.getAllLibrarySectionNames();
        model.addAttribute("librarySections", librarySections);

        List<LanguageModel> languages = bookService.getAllLanguageNames();
        model.addAttribute("languages" , languages);

        return "addbook";
    }


    @GetMapping("/viewBook")
    public String showBooksForm(Model model){
        model.addAttribute("book", new BookModel());

        model.addAttribute("books", bookService.getAllBooks());

        List<LibrarySectionModel> librarySections = bookService.getAllLibrarySectionNames();
        model.addAttribute("librarySections", librarySections);

        List<LanguageModel> languages = bookService.getAllLanguageNames();
        model.addAttribute("languages" , languages);

        return "viewbook";
    }




    @PostMapping("/addBook")
    private String saveBook(@ModelAttribute BookModel bookModel,
                            @RequestParam("subgenreIds") List<Long> subgenresIds, Model model){


        model.addAttribute("book", new BookModel());

        model.addAttribute("books", bookService.getAllBooks());

        List<LibrarySectionModel> librarySections = bookService.getAllLibrarySectionNames();
        model.addAttribute("librarySections", librarySections);

        List<LanguageModel> languages = bookService.getAllLanguageNames();
        model.addAttribute("languages" , languages);

        BookModel savedBook = bookService.saveBook(bookModel);
        bookService.saveSubgenres((int) savedBook.getId(), subgenresIds);

        return "redirect:/viewBook";
    }



    @GetMapping("/editBook/{id}")
    public String showEditBookForm(@PathVariable("id") int id, Model model){
        BookModel bookModel = bookService.getBookById(id);
        model.addAttribute("book",bookModel);

        List<LibrarySectionModel> librarySections = bookService.getAllLibrarySectionNames();
        model.addAttribute("librarySections", librarySections);
        model.addAttribute("genres", bookService.findGenreByLibrarySectionId(Integer.parseInt(bookModel.getLibrarySectionName())));

        List<LanguageModel> languages = bookService.getAllLanguageNames();
        model.addAttribute("languages" , languages);

        List<SubgenreModel> subgenreModels = bookService.getSubgenreByGenreId(Integer.parseInt(bookModel.getGenre()));
        model.addAttribute("subgenres",subgenreModels);

        List<Integer> selectedIds = bookService.getSubgenres(id);
        model.addAttribute("selectedSubgenreIds", selectedIds);

        return "addbook";
    }



    @PostMapping("/editBook/{id}")
    public String updateBook(@PathVariable("id") int id,
                             @ModelAttribute BookModel bookModel,
                             @RequestParam("subgenreIds") List<Long> subgenreIds) throws IOException {
        BookModel savedBook = bookService.saveBook(bookModel);
        bookService.deleteSubgenres((int) savedBook.getId());
        bookService.saveSubgenres((int) savedBook.getId(), subgenreIds);

        return "redirect:/viewBook";
    }



    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/viewBook";
    }


    @GetMapping("/genres/{librarySectionId}")
    @ResponseBody
    public  List<GenreModel>findGenreByLibrarySectionId(@PathVariable("librarySectionId")int librarySectionId){
        return bookService.findGenreByLibrarySectionId(librarySectionId);
    }


    @GetMapping("/subgenres/{genreId}")
    @ResponseBody
    public List<SubgenreModel> getSubgenresByGenreId(@PathVariable("genreId") int genreId) {
        return bookService.getSubgenreByGenreId(genreId);
    }














    @GetMapping("message-expression")
    public String messageExpression(){
        return "message-expression";
    }


    @GetMapping("link-expression")
    public String linkExpression(){
        return "link-expression";
    }


    @GetMapping("fragment-expression")
    public String fragmentExpression(){
        return "fragment-expression";
    }


    @GetMapping("home")
    private String homePage(){
        return "home";
    }

    @GetMapping("layout")
    private String layoutForm(){
        return "layout";
    }


}


