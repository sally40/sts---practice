package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Movie;
import net.skhu.mapper.GenreMapper;
import net.skhu.mapper.MovieMapper;

@Controller
public class MovieController {

    @Autowired MovieMapper movieMapper;
    @Autowired GenreMapper genreMapper;

    @RequestMapping("movie/list")
    public String list(Model model) {
        List<Movie> movies = movieMapper.findAll();
        model.addAttribute("movies", movies);
        return "movie/list";
    }

    @GetMapping("movie/create")
    public String create(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        model.addAttribute("genres", genreMapper.findAll());
        return "movie/edit";
    }

    @PostMapping("movie/create")
    public String create(Model model, Movie movie) {
    	movieMapper.insert(movie);
        return "redirect:list";
    }

    @GetMapping("movie/edit")
    public String edit(Model model, int id) {
        Movie movie = movieMapper.findById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("genres", genreMapper.findAll());
        return "movie/edit";
    }

    @PostMapping("movie/edit")
    public String edit(Model model, Movie movie) {
    	movieMapper.update(movie);
        return "redirect:list";
    }

    @RequestMapping("movie/delete")
    public String delete(int id) {
        movieMapper.delete(id);
        return "redirect:list";
    }

}

