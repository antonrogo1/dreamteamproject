package edu.utd.semweb.dreamteamproject.restmodel.googlevistable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TableObject {

    Column[] cols;
    Row[] rows;

}
