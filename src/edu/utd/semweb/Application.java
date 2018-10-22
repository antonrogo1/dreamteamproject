package edu.utd.semweb;

import java.io.IOException;

public class Application {

    public static void main(String[] args){
        JenaService jenaService = new JenaService();
        try {
            jenaService.createRdfAirQuality();
            jenaService.createRdfChronicDiseases();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
