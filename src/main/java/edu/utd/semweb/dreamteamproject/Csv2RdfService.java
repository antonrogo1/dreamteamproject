package edu.utd.semweb.dreamteamproject;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.tdb.TDBFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
public class Csv2RdfService {

    public void generateRdfFromCsvAirQuality()  {
        String directory = "MyDatabases/Dataset1" ;
        String defaultNameSpace = "http://utdallas/semclass#";

        Dataset dataset = TDBFactory.createDataset(directory);
        dataset.begin(ReadWrite.WRITE);

        Model model = dataset.getNamedModel("myrdf");
        model.setNsPrefix("namespace", defaultNameSpace);

        try {
        Reader in = new FileReader("csvdata/air-quality.csv");

            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(AirQualityHeaders.class).parse(in);
            for (CSVRecord record : records) {

                String stateName = record.get(AirQualityHeaders.StateName);
                String reportYear = record.get(AirQualityHeaders.ReportYear);
                String value = record.get(AirQualityHeaders.Value);

                UUID uuid = UUID.randomUUID();

                Resource subject = model.createResource(defaultNameSpace+uuid.toString());
                Property predicate = model.createProperty(defaultNameSpace+ "statename");
                Statement stmt = model.createStatement(subject, predicate, stateName);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "ReportYear");
                stmt = model.createStatement(subject, predicate, reportYear);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "Value");
                stmt = model.createStatement(subject, predicate, value);
                model.add(stmt);


            }

            OutputStream outputStream = new FileOutputStream("rdfdata/air-quality.rdf");
            RDFDataMgr.write(outputStream, model, RDFFormat.RDFXML) ;
            outputStream.close();

            outputStream = new FileOutputStream("ttldata/air-quality.ttl");
            RDFDataMgr.write(outputStream, model, RDFFormat.TURTLE) ;
            outputStream.close();

            model.commit();
            dataset.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void generateRdfFromCsvChronicDiseases()  {
        String directory = "MyDatabases/Dataset1" ;
        String defaultNameSpace = "http://utdallas/semclass#";

        Dataset dataset = TDBFactory.createDataset(directory);        dataset.begin(ReadWrite.WRITE);

        Model model = dataset.getNamedModel("myrdf");
        model.setNsPrefix("namespace", defaultNameSpace);

        try {
            Reader in = new FileReader("csvdata/chronic-diseases.csv");

            Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(ChronicDiseasesHeaders.class).parse(in);
            for (CSVRecord record : records) {

                String yearStart = record.get(ChronicDiseasesHeaders.YearStart);
                String locationDesc = record.get(ChronicDiseasesHeaders.LocationDesc);
                String topic = record.get(ChronicDiseasesHeaders.Topic);
                String dataValueUnit = record.get(ChronicDiseasesHeaders.DataValueUnit);
                String dataValue = record.get(ChronicDiseasesHeaders.DataValue);

                UUID uuid = UUID.randomUUID();

                Resource subject = model.createResource(defaultNameSpace+uuid.toString());
                Property predicate = model.createProperty(defaultNameSpace+ "yearstart");
                Statement stmt = model.createStatement(subject, predicate, yearStart);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "LocationDesc");
                stmt = model.createStatement(subject, predicate, locationDesc);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "Topic");
                stmt = model.createStatement(subject, predicate, topic);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "DataValueUnit");
                stmt = model.createStatement(subject, predicate, dataValueUnit);
                model.add(stmt);

                predicate = model.createProperty(defaultNameSpace+ "DataValue");
                stmt = model.createStatement(subject, predicate, dataValue);
                model.add(stmt);

            }

            OutputStream outputStream = new FileOutputStream("rdfdata/chronic-diseases.rdf");
            RDFDataMgr.write(outputStream, model, RDFFormat.RDFXML) ;


            outputStream = new FileOutputStream("ttldata/chronic-diseases.ttl");
            RDFDataMgr.write(outputStream, model, RDFFormat.TURTLE) ;
            outputStream.close();

            model.commit();
            dataset.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public enum AirQualityHeaders {
        MeasureId,MeasureType,StratificationLevel,StateFips,StateName,CountyName,ReportYear,Value,UnitName,DataOrigin,MonitorOnly
    }

    public enum ChronicDiseasesHeaders{
        YearStart,YearEnd,LocationAbbr,LocationDesc,DataSource,Topic,Question,Response,DataValueUnit,DataValueType,DataValue,DataValueAlt,DataValueFootnoteSymbol,DatavalueFootnote,LowConfidenceLimit,HighConfidenceLimit,StratificationCategory1,Stratification1,StratificationCategory2,Stratification2,StratificationCategory3,Stratification3,GeoLocation,ResponseID,LocationID,TopicID,QuestionID,DataValueTypeID,StratificationCategoryID1,StratificationID1,StratificationCategoryID2,StratificationID2,StratificationCategoryID3,StratificationID3
    }

}
