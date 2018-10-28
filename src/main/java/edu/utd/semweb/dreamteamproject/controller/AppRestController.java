package edu.utd.semweb.dreamteamproject.controller;

import edu.utd.semweb.dreamteamproject.restmodel.domain.BasicStateValue;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.Column;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.Row;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.RowPart;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.TableObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @GetMapping("/data.json")
    public TableObject greeting( ) {

//        Object[] test0 = {"State", "Select"};
//        Object[] test1 = {"US-AK", 12};
//        Object[] test2 = {"US-TX", 56};
//        Object[] test3 = {"US-UT", 33};
//
//        Object[] result = {test0, test1, test2, test3};


        TableObject tableObject = new TableObject();

        Column column = new Column();
        column.setLabel("State");
        column.setType("string");

        Column column2 = new Column();
        column2.setLabel("Select");
        column2.setType("number");


        Column[] columns = new Column[2];
        columns[0] = column;
        columns[1] = column2;

        tableObject.setCols(columns);


        Row row = new Row();

        RowPart rowPart1 = new RowPart();
        rowPart1.setV("US-TX");

        RowPart rowPart2 = new RowPart();
        rowPart2.setV(56);

        RowPart[] rowParts = new RowPart[2];
        rowParts[0] = rowPart1;
        rowParts[1] = rowPart2;

        row.setC(rowParts);

        Row[] rows = new Row[1];
        rows[0] = row;

        tableObject.setRows(rows);

        return tableObject;
    }

}
