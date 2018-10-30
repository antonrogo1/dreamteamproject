package edu.utd.semweb.dreamteamproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DreamteamprojectApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DreamteamprojectApplication.class, args);
    }

    @Autowired
    JenaService jenaService;

    @Autowired
    Csv2RdfService csv2RdfService;

    @Autowired
    DataService dataService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.print("Test");

       //csv2RdfService.generateRdfFromCsvAirQuality();
       //csv2RdfService.generateRdfFromCsvChronicDiseases();


        jenaService.createFusekiServer();

        //dataService.getAirQualityData(2012);







    }
}
