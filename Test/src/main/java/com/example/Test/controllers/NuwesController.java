package com.example.Test.controllers;

import com.example.Test.Repositoriy.NuwesRepositoriy;
import com.example.Test.models.Nuwes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/News")
public class NuwesController {

    @Autowired
    private NuwesRepositoriy newsRepository;

    @GetMapping("/")
    public  String Index(Model model){
        Iterable<Nuwes> news =  newsRepository.findAll();
        model.addAttribute("news", news);
        return "News/index";
    }

    @GetMapping("/addView")
    public  String addView(Model model){

        return "News/add";
    }

    @PostMapping("/add")
    public  String add(
            @RequestParam("title") String title,
            @RequestParam("body") String author,
            @RequestParam("text") String textNews,
            @RequestParam("vuews") int Views,
            @RequestParam("likes") int likes,

            Model model){

        Nuwes newOne = new Nuwes(title,textNews,author,Views,likes);
        newsRepository.save(newOne);
        return "redirect:/News/";
    }

    @GetMapping("/search")
    public  String searchMetrhod(
            @RequestParam("title") String title,
            Model model)
    {
        List<Nuwes> newList = newsRepository.findByTitle(title);
        model.addAttribute("news",newList);
        return "News/index";
    }
}
