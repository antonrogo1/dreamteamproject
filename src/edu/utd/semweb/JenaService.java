package edu.utd.semweb;

import java.io.*;
import java.util.Date;

public class JenaService {

    public void loadData() throws IOException {
        InputStream inputStreamAirQuality = new FileInputStream(new File("./rdfdata/air-quality.rdf"));
        InputStream inputStreamChronicDiseases = new FileInputStream(new File("./rdfdata/chronic-diseases.rdf"));
        InputStream inputStreamLifeExpectancy = new FileInputStream(new File("./rdfdata/life-expectancy.rdf"));


        inputStreamAirQuality.close();
        inputStreamChronicDiseases.close();
        inputStreamLifeExpectancy.close();
    }

}
