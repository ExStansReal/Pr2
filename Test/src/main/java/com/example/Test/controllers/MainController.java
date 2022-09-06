package com.example.Test.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  //  @GetMapping("/resNew")  //ссылка на страницу
  //  public String greeting(Model model) {
   //     model.addAttribute("name","Дарова");
     //   return "home";  //в какой html он вернётся, можно там создавать папки и путь будет просто как до папки обычной
    //}

    @GetMapping("/") //а это просто открывает новую страницу, в неё вкладывать параметры так-же можно
    public String Main(Model model) {
        return "home"; //переход на страницу home
    }
    @PostMapping("/getres")  //post нужен т.к ссылка одна куда ведёт, а запросов много так что и фомра настраивается под post, как и метод!
    public String Result(@RequestParam(value = "variable", required = false, defaultValue = "0") double a,
                         @RequestParam(value = "variable2", required = false, defaultValue = "0") double b,
                         @RequestParam(value = "variable3", required = false, defaultValue = "+") String deystvie,
                         Model model)
    {
        double c = 0; //итоговая перменная

        if(deystvie.length() > 1) {
            model.addAttribute("error","Вы ввели что-то не корректно");
            return "home";
        }
        if(deystvie.contains("+") == false &&
                deystvie.contains("-") == false &&
                        deystvie.contains("*") == false &&
                                deystvie.contains("/") == false
                                )
        {
            model.addAttribute("error","Вы ввели что-то не корректно");
            return "home";
        }
        if(deystvie.contains("+")) //выборка действия (да знаю можно switch, но я его не люблю)
        {
            c = a + b;
        }
        if(deystvie.contains("-"))
        {
            c = a - b;
        }
        if(deystvie.contains("/"))
        {
            c = a / b;
        }
        if(deystvie.contains("*"))
        {
            c = a * b;
        }
        model.addAttribute("answer",a + deystvie + b + "=" + c); //финальная перемнная которая выводится
        return "result"; //переход на страницу result
    }
}
