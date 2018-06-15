package ASOserver.springapp.service;

import ASOserver.model.ChoiceList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ChoiceListService {

    ChoiceList choiceList = new ChoiceList();

    public List<String> getAccessRightsList() {
        List<String> accessRightsList = choiceList.getAccessRightsList();
        return accessRightsList;
    }

    public List<String> getNotyficationTypes() {
        List <String> notyficationTypes = choiceList.getNotyficationTypes();
        return notyficationTypes;
    }

    public List<String> getSpecificServicesExecutionStatus() {
        List <String> specificServicesExecutionStatus = choiceList.getSpecificServicesExecutionStatus();
        return specificServicesExecutionStatus;
    }

    public List<String> getPaymentMethod() {
        List <String> paymentMethod = choiceList.getPaymentMethod();
        return paymentMethod;
    }

    public List<String> getServiceTypes() {
        List <String> serviceTypes = choiceList.getServiceTypes();
        return serviceTypes;
    }
}
