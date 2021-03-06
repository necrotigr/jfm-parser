package net.jazzfestmap.app.parser.controllers;

import net.jazzfestmap.app.parser.dao.services.SaverService;
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


    @RequestMapping("parseOld")
    @ResponseBody
    String parseOld(@RequestParam Integer month, @RequestParam Integer year) {
        saverService.fetchAndSave("http://jazzfests.net/dates/?month=%d&year=%d", month, year);
        return "ok";
    }

    @RequestMapping("parse")
    @ResponseBody
    String parseNew(@RequestParam(required = false) Integer month) {
        String urlTemplate = SaverService.APASSION4JAZZ_URL;
        if (month == null)
            month = 0;
        saverService.fetchAndSave(urlTemplate, month);
        return "ok";
    }

}
