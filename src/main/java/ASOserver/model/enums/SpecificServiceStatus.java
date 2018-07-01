package ASOserver.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class SpecificServiceStatus {
    public enum SpecificServiceStatusEnum {
        NEW("nowa"),
        DURING("w toku"),
        FINISHED("zakończona");

        private String specificServiceStatus;

        private SpecificServiceStatusEnum(String specificServiceStatus) {
            this.specificServiceStatus = specificServiceStatus;
        }

        @JsonCreator
        public static SpecificServiceStatusEnum fromValue(String value) {
            return getSpecificServiceStatus(value);
        }

        @JsonValue
        public String toJson() {
            return getSpecificServiceStatus();
        }

        public String getSpecificServiceStatus() {
            return specificServiceStatus;
        }

        public static SpecificServiceStatusEnum getSpecificServiceStatus(String name) {
            for(SpecificServiceStatusEnum current : SpecificServiceStatusEnum.values()) {
                if(current.specificServiceStatus.equals(name)) {
                    return current;
                }
            }
            return null;
        }
    }

    public List<String> getSpecificServiceStatuses() {
        List<String> specificServiceStatusEnumList = new ArrayList<>();
        SpecificServiceStatusEnum[] specificServiceStatusEnums = SpecificServiceStatusEnum.values();
        for (SpecificServiceStatusEnum specificServiceStatusEnum : specificServiceStatusEnums) {
            specificServiceStatusEnumList.add(specificServiceStatusEnum.getSpecificServiceStatus());
        }
        return specificServiceStatusEnumList;
    }
}
