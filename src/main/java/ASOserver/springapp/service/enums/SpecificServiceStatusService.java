package ASOserver.springapp.service.enums;

import ASOserver.model.enums.SpecificServiceStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificServiceStatusService {
    SpecificServiceStatus specificServiceStatus = new SpecificServiceStatus();

    public List<String> getSpecificServiceStatuses() {
        List <String> specificServicesExecutionStatusList = specificServiceStatus.getSpecificServiceStatuses();
        return specificServicesExecutionStatusList;
    }
}
