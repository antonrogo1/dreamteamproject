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
        System.out.println("Application Started");

//        System.out.println("Generating AirQuality dataset RDF and TTL");
//        csv2RdfService.generateRdfFromCsvAirQuality();
//        System.out.println("Finished Generating AirQuality dataset RDF and TTL");
//        System.out.println("Generating Illness dataset RDF and TTL");
//        csv2RdfService.generateRdfFromCsvChronicDiseases();
//        System.out.println("Finished Generating Illness dataset RDF and TTL");

        System.out.println("Initializing Fuseki Service");
        jenaService.createFusekiServer();
        System.out.println("Finished Initializing Fuseki Service");

        //dataService.getAirQualityData(2012);

    }
}
