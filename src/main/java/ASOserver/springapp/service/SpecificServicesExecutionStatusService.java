package ASOserver.springapp.service;

import ASOserver.model.SpecificServicesExecutionStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificServicesExecutionStatusService {

    SpecificServicesExecutionStatus specificServicesExecutionStatus = new SpecificServicesExecutionStatus();

    public List<String> getSpecificServicesExecutionStatus() {
        List <String> specificServicesExecutionStatusList = specificServicesExecutionStatus.getSpecificServicesExecutionStatus();
        return specificServicesExecutionStatusList;
    }
}
