package edu.utd.semweb.dreamteamproject;


import edu.utd.semweb.dreamteamproject.restmodel.fuseki.FusekiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FusekiHttpQueryService {

    public FusekiResponse getAirQialityForYear(String year) {

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:3330/rdf")
                .queryParam("query",
                        "PREFIX ut: <http://utdallas/semclass#> select ?statename ?airvalue where { ?s ut:statename ?statename . ?s ut:Value ?airvalue .?s ut:ReportYear \""+year+"\" . }");

        URI uri = builder.build().toUri();

        ResponseEntity<FusekiResponse> response = restTemplate.getForEntity(uri  , FusekiResponse.class);

        FusekiResponse fusekiResponse = response.getBody();


        return fusekiResponse;
    }

    public FusekiResponse getDiseaseReportForYear(String disease, String year) {

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:3330/rdf")
                .queryParam("query",
                        "PREFIX ut: <http://utdallas/semclass#> select ?statename ?disease ?datavalueUnit ?datavalue where {  ?s ut:LocationDesc ?statename . ?s ut:Topic \""+disease+"\" . ?s ut:DataValueUnit ?datavalueUnit .  ?s ut:DataValue ?datavalue . ?s ut:yearstart \""+year+"\" .} ");

        URI uri = builder.build().toUri();

        ResponseEntity<FusekiResponse> response = restTemplate.getForEntity(uri  , FusekiResponse.class);

        FusekiResponse fusekiResponse = response.getBody();

        return fusekiResponse;
    }

}
