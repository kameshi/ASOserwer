package ASOserver.springapp.service;

import ASOserver.model.NotyficationTypes;

import java.util.List;

public class NotyficationTypesService {

    NotyficationTypes notyficationTypes = new NotyficationTypes();

    public List<String> getNotyficationTypes() {
        List <String> notyficationTypesList = notyficationTypes.getNotyficationTypes();
        return notyficationTypesList;
    }
}
