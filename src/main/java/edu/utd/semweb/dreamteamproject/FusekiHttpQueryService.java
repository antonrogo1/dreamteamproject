package edu.utd.semweb.dreamteamproject;


import edu.utd.semweb.dreamteamproject.restmodel.fuseki.FusekiResponse;
import org.jvnet.hk2.annotations.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class FusekiHttpQueryService {

    public void getAirQialityForYear() {


        RestTemplate restTemplate = new RestTemplate();


        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:3330/rdf")
                .queryParam("query",
                        "PREFIX ut: <http://utdallas/semclass#> select ?statename ?airvalue where { ?s ut:statename ?statename . ?s ut:Value ?airvalue .?s ut:ReportYear \"2012\" . }");

        URI uri = builder.build().toUri();

        ResponseEntity<FusekiResponse> response = restTemplate.getForEntity(uri  , FusekiResponse.class);


    }

}
