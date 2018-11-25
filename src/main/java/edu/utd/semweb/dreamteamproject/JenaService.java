package edu.utd.semweb.dreamteamproject;

import org.apache.jena.fuseki.main.FusekiServer;
import org.apache.jena.fuseki.server.DataService;
import org.apache.jena.query.Dataset;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.tdb.TDBFactory;
import org.springframework.stereotype.Service;

@Service
public class JenaService {

    public void createFusekiServer(){

        //Dataset ds = TDBFactory.createDataset("MyDatabases/Dataset1");

        Dataset airQualityDataset = RDFDataMgr.loadDataset("ttldata/air-quality.ttl");
        Dataset illnessDataset = RDFDataMgr.loadDataset("ttldata/chronic-diseases.ttl");

        //DataService dataService = new DataService(ds.asDatasetGraph());

        FusekiServer server = FusekiServer.create()
                .add("/rdf", airQualityDataset, false)
                .add("/rdf2", illnessDataset, false)
                .verbose(true)
                .build() ;
        server.start() ;

    }

}
