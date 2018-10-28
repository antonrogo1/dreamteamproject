package edu.utd.semweb.dreamteamproject.restmodel.fuseki;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class FusekiResponseBody {

    List<FusekiResponseBinding> bindings;

}
