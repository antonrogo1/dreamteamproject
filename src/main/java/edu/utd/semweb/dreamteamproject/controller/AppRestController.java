package edu.utd.semweb.dreamteamproject.controller;

import edu.utd.semweb.dreamteamproject.DataService;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.Column;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.Row;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.RowPart;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.TableObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @Autowired
    DataService dataService;

    @GetMapping("/airquality-data")
    public TableObject greeting( @RequestParam("year") int year ) {

        TableObject tableObject = dataService.getAirQualityData(year);

        return tableObject;
    }

    @GetMapping("/disease-data")
    public TableObject greeting(@RequestParam("disease") String disease, @RequestParam("year") int year ) {

        TableObject tableObject = dataService.getDiseasesData(disease, year);

        return tableObject;
    }

}
