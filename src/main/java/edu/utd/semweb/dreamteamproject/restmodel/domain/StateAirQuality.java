package edu.utd.semweb.dreamteamproject.restmodel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @NoArgsConstructor
public class StateAirQuality {

    String stateName;
    String statePostalCode;
    List<Double> stateAirQualityList = new ArrayList<>();

    public double getAverageAirQuality(){

        DoubleSummaryStatistics stats = stateAirQualityList.stream().mapToDouble((x) -> x).summaryStatistics();

        double averageAirQuality = stats.getAverage();

        return averageAirQuality;
    }




}
