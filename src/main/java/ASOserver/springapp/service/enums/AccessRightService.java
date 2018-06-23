package ASOserver.springapp.service.enums;

import ASOserver.model.enums.AccessRight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessRightService {
    AccessRight accessRight = new AccessRight();

    public List<String> getAccessRights() {
        List<String> accessRightsList = accessRight.getAccessRights();
        return accessRightsList;
    }
}
