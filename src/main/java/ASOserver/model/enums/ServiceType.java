package ASOserver.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

        @JsonCreator
        public static ServiceTypeEnum fromValue(String value) {
            return getServiceType(value);
        }

        @JsonValue
        public String toJson() {
            return getServiceType();
        }

        public String getServiceType() {
            return serviceType;
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
