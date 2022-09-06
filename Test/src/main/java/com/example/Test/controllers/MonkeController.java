package com.example.Test.controllers;
import com.example.Test.Repositoriy.BananasRepository;
import com.example.Test.Repositoriy.MonkeRepository;
import com.example.Test.Repositoriy.NuwesRepositoriy;
import com.example.Test.models.Bananas;
import com.example.Test.models.Monke;
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
@RequestMapping("/Monke")
public class MonkeController {

    @Autowired
    private MonkeRepository monkeRepository;

    @GetMapping("/")
    public  String Index(Model model){
        Iterable<Monke> monkes =  monkeRepository.findAll();
        model.addAttribute("monkes", monkes);
        return "Monke/index";
    }

    @GetMapping("/addView")
    public  String addView(Model model){

        return "Monke/add";
    }

    @PostMapping("/add")
    public  String add(
            @RequestParam("name") String name,
            @RequestParam("opisanie") String opisanie,
            @RequestParam("chena") String chena,
            @RequestParam("rost") int rost,
            @RequestParam("weight") int weight,

            Model model){

        Monke monke = new Monke(name,opisanie,chena,rost,weight);
        monkeRepository.save(monke);
        return "redirect:/Monke/";
    }

    @GetMapping("/search")
    public  String searchMetrhod(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Monke> monkes =  monkeRepository.findAll();
            model.addAttribute("monkes", monkes);
            return "Monke/index";
        }
        else {
            List<Monke> monkkeList = monkeRepository.findByName(name);
            model.addAttribute("monkes", monkkeList);
            return "/Monke/index"; //searchContains
        }
    }
    @GetMapping("/searchContains")
    public  String searchMetrhodContains(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Monke> monkes =  monkeRepository.findAll();
            model.addAttribute("monkes", monkes);
            return "Monke/index";
        }
        else {
            List<Monke> monkkeList = monkeRepository.findByNameContains(name);
            model.addAttribute("monkes", monkkeList);
            return "/Monke/index"; //searchContains
        }
    }
}
