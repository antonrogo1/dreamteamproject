package edu.utd.semweb.dreamteamproject.restmodel.fuseki;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class FusekiResponse {

    FusekiResponseHead head;
    FusekiResponseBody results;

}
