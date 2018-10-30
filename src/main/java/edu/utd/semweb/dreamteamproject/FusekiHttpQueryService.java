package edu.utd.semweb.dreamteamproject;


import edu.utd.semweb.dreamteamproject.restmodel.domain.StateAirQuality;
import edu.utd.semweb.dreamteamproject.restmodel.fuseki.FusekiResponse;

import edu.utd.semweb.dreamteamproject.restmodel.fuseki.FusekiResponseBinding;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

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

}
