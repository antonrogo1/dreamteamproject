package edu.utd.semweb;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.*;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.vocabulary.VCARD;

import java.io.*;
import java.util.Date;
import java.util.UUID;

public class JenaService {

    public void loadData() throws IOException {
        InputStream inputStreamAirQuality = new FileInputStream(new File("./rdfdata/air-quality.rdf"));
        InputStream inputStreamChronicDiseases = new FileInputStream(new File("./rdfdata/chronic-diseases.rdf"));
        InputStream inputStreamLifeExpectancy = new FileInputStream(new File("./rdfdata/life-expectancy.rdf"));


        inputStreamAirQuality.close();
        inputStreamChronicDiseases.close();
        inputStreamLifeExpectancy.close();
    }


    public void createRdfAirQuality(){
        String directory = "MyDatabases/Dataset1" ;
        String defaultNameSpace = "http://utdallas/semclass#";

        Dataset dataset = TDBFactory.createDataset(directory);
        dataset.begin(ReadWrite.WRITE);

        Model model = dataset.getNamedModel("myrdf");
        model.setNsPrefix("namespace", defaultNameSpace);


        try (BufferedReader br = new BufferedReader(new FileReader("csvdata/air-quality.csv"))) {
            String line;

            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                if(firstLine){
                    firstLine = false;
                    continue;
                }

                String[] csvTokens = line.split(",", 11);

                UUID uuid = UUID.randomUUID();

                Resource subject = model.createResource(defaultNameSpace+uuid.toString());
                Property predicate = model.createProperty(defaultNameSpace+ "statename");
                Statement stmt = model.createStatement(subject, predicate, csvTokens[4]);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "ReportYear");
                stmt = model.createStatement(subject, predicate, csvTokens[6]);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "Value");
                stmt = model.createStatement(subject, predicate, csvTokens[7]);
                model.add(stmt);


            }

            OutputStream outputStream = new FileOutputStream("rdfdata/air-quality.rdf");
            RDFDataMgr.write(outputStream, model, RDFFormat.RDFXML) ;
            model.commit();
            dataset.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createRdfChronicDiseases(){
        String directory = "MyDatabases/Dataset1" ;
        String defaultNameSpace = "http://utdallas/semclass#";

        Dataset dataset = TDBFactory.createDataset(directory);
        dataset.begin(ReadWrite.WRITE);

        Model model = dataset.getNamedModel("myrdf");
        model.setNsPrefix("namespace", defaultNameSpace);


        try (BufferedReader br = new BufferedReader(new FileReader("csvdata/chronic-diseases.csv"))) {
            String line;

            boolean firstLine = true;

            while ((line = br.readLine()) != null) {

                if(firstLine){
                    firstLine = false;
                    continue;
                }

                String[] csvTokens = line.split(",", 11);

                UUID uuid = UUID.randomUUID();

                Resource subject = model.createResource(defaultNameSpace+uuid.toString());
                Property predicate = model.createProperty(defaultNameSpace+ "yearstart");
                Statement stmt = model.createStatement(subject, predicate, csvTokens[0]);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "LocationDesc");
                stmt = model.createStatement(subject, predicate, csvTokens[3]);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "Topic");
                stmt = model.createStatement(subject, predicate, csvTokens[5]);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "Topic");
                stmt = model.createStatement(subject, predicate, csvTokens[5]);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "DataValueUnit");
                stmt = model.createStatement(subject, predicate, csvTokens[8]);
                model.add(stmt);

            }

            OutputStream outputStream = new FileOutputStream("rdfdata/chronic-diseases.rdf");
            RDFDataMgr.write(outputStream, model, RDFFormat.RDFXML) ;
            model.commit();
            dataset.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
