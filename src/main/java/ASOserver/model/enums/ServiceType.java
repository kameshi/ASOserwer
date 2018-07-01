package ASOserver.model.enums;

import java.util.ArrayList;
import java.util.List;

public class ServiceType {
    public enum ServiceTypeEnum {
        EXCHANGE("wymiana"),
        OVERVIEW("przegląd"),
        ANALYSIS("analiza"),
        REPAIR("naprawa");

        private String serviceType;

        private ServiceTypeEnum(String serviceType) {
            this.serviceType = serviceType;
        }

        public String getServiceType() {
            return serviceType;
        }

        public static ServiceTypeEnum getServiceType(String name) {
            for(ServiceTypeEnum current : ServiceTypeEnum.values()) {
                if(current.serviceType.equals(name)) {
                    return current;
                }
            }
            return null;
        }
    }

    public List<String> getServiceTypes() {
        List<String> serviceTypeEnumList = new ArrayList<>();
        ServiceTypeEnum[] serviceTypeEnums = ServiceTypeEnum.values();
        for (ServiceTypeEnum serviceTypeEnum : serviceTypeEnums) {
            serviceTypeEnumList.add(serviceTypeEnum.getServiceType());
        }
        return serviceTypeEnumList;
    }
}
