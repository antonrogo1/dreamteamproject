package edu.utd.semweb.dreamteamproject.restmodel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class StateDiseaseReport {

    String stateName;
    String statePostalCode;
    String illness;
    String illnessReportType;   // csv - Question column
    String datavalueUnit;
    String datavalueType;
    List<Double> stateIllnessReportValueList = new ArrayList<>();

    public double getAverageReportedIllnessCases(){

        DoubleSummaryStatistics stats = stateIllnessReportValueList.stream().mapToDouble((x) -> x).summaryStatistics();

        double averageIllnessReports = stats.getAverage();

        return averageIllnessReports;
    }

}
