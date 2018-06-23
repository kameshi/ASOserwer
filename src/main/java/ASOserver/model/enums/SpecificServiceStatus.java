package ASOserver.model.enums;

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

        public String getSpecificServiceStatus() {
            return specificServiceStatus;
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
