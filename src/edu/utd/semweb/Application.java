package edu.utd.semweb;

import java.io.IOException;

public class Application {

    public static void main(String[] args){
        JenaService jenaService = new JenaService();
        try {
            jenaService.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
