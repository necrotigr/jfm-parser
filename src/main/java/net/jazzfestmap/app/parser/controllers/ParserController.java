package net.jazzfestmap.app.parser.controllers;

import net.jazzfestmap.app.parser.services.SaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
