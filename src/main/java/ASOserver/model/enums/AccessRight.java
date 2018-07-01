package ASOserver.model.enums;

import java.util.ArrayList;
import java.util.List;

public class AccessRight {

    public enum AccessRightEnum {
        CUSTOMER("ROLE_klient"),
        ADMINISTRATOR("ROLE_administrator"),
        MECHANIC("ROLE_mechanik"),
        OFFICEWORKER("ROLE_biurowy");

        private String accessRight;

        private AccessRightEnum(String accessRight) {
            this.accessRight = accessRight;
        }

        public String getAccessRight() {
            return accessRight;
        }

        public static AccessRightEnum getAccessRight(String name) {
            for(AccessRightEnum current : AccessRightEnum.values()) {
                if(current.accessRight.equals(name)) {
                    return current;
                }
            }
            return null;
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
