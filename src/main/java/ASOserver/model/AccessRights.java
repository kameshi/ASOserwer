package ASOserver.model;

import java.util.ArrayList;
import java.util.List;

public class AccessRights {

    public enum AccessRightsEnum {

        CUSTOMER("klient"),
        ADMINISTRATOR("administrator"),
        MECHANIC("mechanik"),
        OFFICEWORKER("pracownik biurowy");
        private String accessRights;

        private AccessRightsEnum(String accessRights) {
            this.accessRights = accessRights;
        }

        public String getAccessRights() {
            return accessRights;
        }
    }

    public List<String> getAccessRightsList(){
        List<String> accessRightsEnumList = new ArrayList<>();
        AccessRightsEnum[] accessRightsEnums = AccessRightsEnum.values();
        for (AccessRightsEnum accessRightsEnum : accessRightsEnums) {
            accessRightsEnumList.add(accessRightsEnum.getAccessRights());
        }
        return accessRightsEnumList;
    }

}
