package ASOserver.springapp.service;

import ASOserver.model.AccessRights;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessRightsService {

    AccessRights accessRights = new AccessRights();

    public List<String> getAccessRightsList() {
        List<String> accessRightsList = accessRights.getAccessRightsList();
        return accessRightsList;
    }
}
