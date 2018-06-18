package ASOserver.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceTypes {
    public enum ServiceTypesEnum {

        EXCHANGE("wymiana"),
        OVERVIEW("przegląd"),
        ANALYSIS("analiza"),
        REPAIR("naprawa");

        private String serviceTypes;

        private ServiceTypesEnum(String serviceTypes) {
            this.serviceTypes = serviceTypes;
        }

        public String getServiceTypes() {
            return serviceTypes;
        }
    }

    public List<String> getServiceTypes() {
        List<String> serviceTypesEnumList = new ArrayList<>();
        ServiceTypesEnum[] serviceTypesEnums = ServiceTypesEnum.values();
        for (ServiceTypesEnum serviceTypeEnum : serviceTypesEnums) {
            serviceTypesEnumList.add(serviceTypeEnum.getServiceTypes());
        }
        return serviceTypesEnumList;
    }
}
