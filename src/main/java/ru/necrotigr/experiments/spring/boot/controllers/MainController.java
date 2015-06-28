package ru.necrotigr.experiments.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Сергей on 28.06.2015.
 *
 * Основная точка входа, контроллер по выдаче шаблонов страниц
 * TODO настройка шаблонов через Spring / Spring Boot с помощью аннотаций
 */
@Controller("/")
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "index";
    }

}