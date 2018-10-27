package edu.utd.semweb.dreamteamproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;

@SpringBootApplication
public class DreamteamprojectApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DreamteamprojectApplication.class, args);
    }

    @Autowired
    JenaService jenaService;

    @Autowired
    Csv2RdfService csv2RdfService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.print("Test");

       //csv2RdfService.generateRdfFromCsvAirQuality();
       //csv2RdfService.generateRdfFromCsvChronicDiseases();


        jenaService.createFusekiServer();

        RestTemplate restTemplate = new RestTemplate();


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:3330/rdf")
                .queryParam("query",
                        "PREFIX ut: <http://utdallas/semclass#> select * where { ?s ut:statename \"Texas\" }");

        URI uri = builder.build().toUri();

        ResponseEntity<Object> response
                = restTemplate.getForEntity(uri  , Object.class);


        System.out.println("Test");


    }
}
