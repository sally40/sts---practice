package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Book;
import net.skhu.mapper.BookMapper;
import net.skhu.mapper.CategoryMapper;

@Controller
public class BookController {

    @Autowired BookMapper bookMapper;
    @Autowired CategoryMapper categoryMapper;

    @RequestMapping("book/list")
    public String list(Model model) {
        List<Book> books = bookMapper.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("book/create")
    public String create(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("categorys", categoryMapper.findAll());
        return "book/edit";
    }

    @PostMapping("book/create")
    public String create(Model model, Book book) {
        bookMapper.insert(book);
        return "redirect:list";
    }

    @GetMapping("book/edit")
    public String edit(Model model, int id) {
        Book book = bookMapper.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("categorys", categoryMapper.findAll());
        return "book/edit";
    }

    @PostMapping("book/edit")
    public String edit(Model model, Book book) {
        bookMapper.update(book);
        return "redirect:list";
    }

    @RequestMapping("book/delete")
    public String delete(int id) {
        bookMapper.delete(id);
        return "redirect:list";
    }
}


