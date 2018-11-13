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
    String disease;
    String datavalueUnit;
    List<Double> stateDiseaseReportValueList = new ArrayList<>();

    public double getAverageReportedDiseaseCases(){

        DoubleSummaryStatistics stats = stateDiseaseReportValueList.stream().mapToDouble((x) -> x).summaryStatistics();

        double averageDiseaseReports = stats.getAverage();

        return averageDiseaseReports;
    }

}
