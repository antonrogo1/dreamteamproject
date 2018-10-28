package edu.utd.semweb.dreamteamproject.controller;

import org.apache.jena.rdf.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public Object[] greeting( ) {

        Object[] test0 = {"State", "Select"};
        Object[] test1 = {"US-AK", 12};
        Object[] test2 = {"US-TX", 56};
        Object[] test3 = {"US-UT", 33};

        Object[] result = {test0, test1, test2, test3};

        return result;
    }

}
