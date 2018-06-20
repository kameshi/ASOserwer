package ASOserver.springapp.service;

import ASOserver.model.NotyficationTypes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotyficationTypesService {

    NotyficationTypes notyficationTypes = new NotyficationTypes();

    public List<String> getNotyficationTypes() {
        List <String> notyficationTypesList = notyficationTypes.getNotyficationTypes();
        return notyficationTypesList;
    }
}
