package ASOserver.springapp.service;

import ASOserver.model.SpecificServicesExecutionStatus;

import java.util.List;

public class SpecificServicesExecutionStatusService {

    SpecificServicesExecutionStatus specificServicesExecutionStatus = new SpecificServicesExecutionStatus();

    public List<String> getSpecificServicesExecutionStatus() {
        List <String> specificServicesExecutionStatusList = specificServicesExecutionStatus.getSpecificServicesExecutionStatus();
        return specificServicesExecutionStatusList;
    }
}
