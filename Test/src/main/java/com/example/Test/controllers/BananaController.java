package com.example.Test.controllers;

import com.example.Test.Repositoriy.BananasRepository;
import com.example.Test.Repositoriy.NuwesRepositoriy;
import com.example.Test.models.Bananas;
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
@RequestMapping("/Bananas")
public class BananaController {

    @Autowired
    private BananasRepository bananasRepository;

    @GetMapping("/")
    public  String Index(Model model){
        Iterable<Bananas> bananas =  bananasRepository.findAll();
        model.addAttribute("bananas", bananas);
        return "Bananas/index";
    }

    @GetMapping("/addView")
    public  String addView(Model model){

        return "Bananas/add";
    }

    @PostMapping("/add")
    public  String add(
            @RequestParam("name") String name,
            @RequestParam("opisanie") String opisanie,
            @RequestParam("companiyaPostavki") String companiyaPostavki,
            @RequestParam("Cost") int Cost,
            @RequestParam("colZakazov") int colZakazov,

            Model model){

        Bananas bananas = new Bananas(name,opisanie,companiyaPostavki,Cost,colZakazov);
        bananasRepository.save(bananas);
        return "redirect:/Bananas/";
    }

    @GetMapping("/search")
    public  String searchMetrhod(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Bananas> bananas =  bananasRepository.findAll();
            model.addAttribute("bananas", bananas);
            return "Bananas/index";
        }
        else {
            List<Bananas> bananasList = bananasRepository.findByName(name);
            model.addAttribute("bananas", bananasList);
            return "/Bananas/index";
        }
    }
    @GetMapping("/searchContaints")
    public  String searchMetrhodContains(
            @RequestParam("name") String name,
            Model model)
    {
        if(name.isEmpty())
        {
            Iterable<Bananas> bananas =  bananasRepository.findAll();
            model.addAttribute("bananas", bananas);
            return "Bananas/index";
        }
        else {
            List<Bananas> bananasList = bananasRepository.findByNameContains(name);
            model.addAttribute("bananas", bananasList);
            return "/Bananas/index";
        }
    }
}
