package edu.utd.semweb.dreamteamproject;

import edu.utd.semweb.dreamteamproject.restmodel.domain.StateAirQuality;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.Column;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.Row;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.RowPart;
import edu.utd.semweb.dreamteamproject.restmodel.domaintest.TableObject;
import edu.utd.semweb.dreamteamproject.restmodel.fuseki.FusekiResponse;
import edu.utd.semweb.dreamteamproject.restmodel.fuseki.FusekiResponseBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DataService {

    @Autowired
    FusekiHttpQueryService fusekiHttpQueryService;

    public TableObject getAirQualityData(int year) {

        year = 2012;

        FusekiResponse fusekiResponse = fusekiHttpQueryService.getAirQialityForYear(Integer.toString(year));

        List<FusekiResponseBinding> fusekiResponseBindings = fusekiResponse.getResults().getBindings();

        HashMap<String, StateAirQuality> stateAirQualityHashMap = new HashMap<>();

        for(FusekiResponseBinding fusekiResponseBinding : fusekiResponseBindings ){
            String stateName = fusekiResponseBinding.getStatename().getValue();
            String airQuality = fusekiResponseBinding.getAirvalue().getValue();

            if(stateAirQualityHashMap.containsKey("stateName")){
                StateAirQuality stateAirQuality =  stateAirQualityHashMap.get(stateName);
                stateAirQuality.getStateAirQualityList().add(Double.parseDouble(airQuality));
            } else {
                StateAirQuality stateAirQuality =new StateAirQuality();
                stateAirQuality.setStateName(stateName);
                stateAirQuality.setStatePostalCode(this.getStatePostalCode(stateName));
                stateAirQuality.getStateAirQualityList().add(Double.parseDouble(airQuality));
                stateAirQualityHashMap.put(stateName, stateAirQuality);
            }

        }

        TableObject tableObject = this.generateAirQualityTableObject(new ArrayList<>(stateAirQualityHashMap.values()));

        System.out.println("String");

        return tableObject;
    }


    private TableObject generateAirQualityTableObject(List<StateAirQuality> stateAirQualityList){

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


        Row[] rows = new Row[stateAirQualityList.size()];

        int rowCount = 0;
        for(StateAirQuality stateAirQuality : stateAirQualityList) {

            Row row = new Row();

            RowPart rowPart1 = new RowPart();
            rowPart1.setV(stateAirQuality.getStatePostalCode());

            RowPart rowPart2 = new RowPart();
            rowPart2.setV(stateAirQuality.getAverageAirQuality());

            RowPart[] rowParts = new RowPart[2];
            rowParts[0] = rowPart1;
            rowParts[1] = rowPart2;

            row.setC(rowParts);

            rows[rowCount] = row;
            rowCount++;
        }

        tableObject.setRows(rows);

        return tableObject;
    }



    private String getStatePostalCode(String stateName){

        String postalCode="";

        switch(stateName){
            case "Alabama": postalCode = "US-AL"; break;
            case "Alaska": postalCode = "US-AK"; break;
            case "Arizona": postalCode = "US-AZ"; break;
            case "Arkansas": postalCode = "US-AR"; break;
            case "California": postalCode = "US-CA"; break;
            case "Colorado": postalCode = "US-CO"; break;
            case "Connecticut": postalCode = "US-CT"; break;
            case "Delaware": postalCode = "US-DE"; break;
            case "District of Columbia": postalCode = "US-DC"; break;
            case "Florida": postalCode = "US-FL"; break;
            case "Georgia": postalCode = "US-GA"; break;
            case "Hawaii": postalCode = "US-HI"; break;
            case "Idaho": postalCode = "US-ID"; break;
            case "Illinois": postalCode = "US-IL"; break;
            case "Indiana": postalCode = "US-IN"; break;
            case "Iowa": postalCode = "US-IA"; break;
            case "Kansas": postalCode = "US-KS"; break;
            case "Kentucky": postalCode = "US-KY"; break;
            case "Louisiana": postalCode = "US-LA"; break;
            case "Maine": postalCode = "US-ME"; break;
            case "Maryland": postalCode = "US-MD"; break;
            case "Massachusetts": postalCode = "US-MA"; break;
            case "Michigan": postalCode = "US-MI"; break;
            case "Minnesota": postalCode = "US-MN"; break;
            case "Mississippi": postalCode = "US-MS"; break;
            case "Missouri": postalCode = "US-MO"; break;
            case "Montana": postalCode = "US-MT"; break;
            case "Nebraska": postalCode = "US-NE"; break;
            case "Nevada": postalCode = "US-NV"; break;
            case "New Hampshire": postalCode = "US-NH"; break;
            case "New Jersey": postalCode = "US-NJ"; break;
            case "New Mexico": postalCode = "US-NM"; break;
            case "New York": postalCode = "US-NY"; break;
            case "North Carolina": postalCode = "US-NC"; break;
            case "North Dakota": postalCode = "US-ND"; break;
            case "Ohio": postalCode = "US-OH"; break;
            case "Oklahoma": postalCode = "US-OK"; break;
            case "Oregon": postalCode = "US-OR"; break;
            case "Pennsylvania": postalCode = "US-PA"; break;
            case "Rhode Island": postalCode = "US-RI"; break;
            case "South Carolina": postalCode = "US-SC"; break;
            case "South Dakota": postalCode = "US-SD"; break;
            case "Tennessee": postalCode = "US-TN"; break;
            case "Texas": postalCode = "US-TX"; break;
            case "Utah": postalCode = "US-UT"; break;
            case "Vermont": postalCode = "US-VT"; break;
            case "Virginia": postalCode = "US-VA"; break;
            case "Washington": postalCode = "US-WA"; break;
            case "West Virginia": postalCode = "US-WV"; break;
            case "Wisconsin": postalCode = "US-WI"; break;
            case "Wyoming": postalCode = "US-WY"; break;
        }

        return postalCode;
    }
}
