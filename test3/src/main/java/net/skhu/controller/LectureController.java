package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Lecture;
import net.skhu.mapper.CourseMapper;
import net.skhu.mapper.LectureMapper;

@Controller
public class LectureController {

    @Autowired LectureMapper lectureMapper;
    @Autowired CourseMapper courseMapper;

    @RequestMapping("lecture/list")
    public String list(Model model) {
        List<Lecture> lectures = lectureMapper.findAll();
        model.addAttribute("lectures", lectures);
        return "lecture/list";
    }

    @GetMapping("lecture/create")
    public String create(Model model) {
    	Lecture lecture = new Lecture();
        model.addAttribute("lecture", lecture);
        model.addAttribute("courses", courseMapper.findAll());
        return "lecture/edit";
    }

    @PostMapping("lecture/create")
    public String create(Model model, Lecture lecture) {
    	lectureMapper.insert(lecture);
        return "redirect:list";
    }

    @GetMapping("lecture/edit")
    public String edit(Model model, int id) {
    	Lecture lecture = lectureMapper.findById(id);
        model.addAttribute("lecture", lecture);
        model.addAttribute("courses", courseMapper.findAll());
        return "lecture/edit";
    }

    @PostMapping("lecture/edit")
    public String edit(Model model, Lecture lecture) {
    	lectureMapper.update(lecture);
        return "redirect:list";
    }

    @RequestMapping("lecture/delete")
    public String delete(int id) {
        lectureMapper.delete(id);
        return "redirect:list";
    }

}

