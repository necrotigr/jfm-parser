package ru.necrotigr.experiments.spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.necrotigr.experiments.spring.boot.services.SaverService;

@Controller
@RequestMapping("parser")
public class ParserController {

    @Autowired
    private SaverService saverService;

    @RequestMapping("parse")
    @ResponseBody
    String parse(@RequestParam Integer month, @RequestParam Integer year) {
        saverService.save(month, year);
        return "ok";
    }
}
