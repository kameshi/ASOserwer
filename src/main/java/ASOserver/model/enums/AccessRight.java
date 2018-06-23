package ASOserver.model.enums;

import java.util.ArrayList;
import java.util.List;

public class AccessRight {

    public enum AccessRightEnum {
        CUSTOMER("klient"),
        ADMINISTRATOR("administrator"),
        MECHANIC("mechanik"),
        OFFICEWORKER("pracownik biurowy");

        private String accessRight;

        private AccessRightEnum(String accessRight) {
            this.accessRight = accessRight;
        }

        public String getAccessRight() {
            return accessRight;
        }
    }

    public List<String> getAccessRights(){
        List<String> accessRightEnumList = new ArrayList<>();
        AccessRightEnum[] accessRightEnums = AccessRightEnum.values();
        for (AccessRightEnum accessRightEnum : accessRightEnums) {
            accessRightEnumList.add(accessRightEnum.getAccessRight());
        }
        return accessRightEnumList;
    }

}
