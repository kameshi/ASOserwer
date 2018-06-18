package ASOserver.model;

import java.util.ArrayList;
import java.util.List;

public class SpecificServicesExecutionStatus {
    public enum SpecificServicesExecutionStatusEnum {

        NEW("nowa"),
        DURING("w toku"),
        FINISHED("zakończona");

        private String specificServicesExecutionStatus;

        private SpecificServicesExecutionStatusEnum(String specificServicesExecutionStatus) {
            this.specificServicesExecutionStatus = specificServicesExecutionStatus;
        }

        public String getSpecificServicesExecutionStatus() {
            return specificServicesExecutionStatus;
        }
    }

    public List<String> getSpecificServicesExecutionStatus() {
        List<String> specificServicesExecutionStatusEnumList = new ArrayList<>();
        SpecificServicesExecutionStatusEnum[] specificServicesExecutionStatusEnums = SpecificServicesExecutionStatusEnum.values();
        for (SpecificServicesExecutionStatusEnum specificServicesExecutionStatusEnum : specificServicesExecutionStatusEnums) {
            specificServicesExecutionStatusEnumList.add(specificServicesExecutionStatusEnum.getSpecificServicesExecutionStatus());
        }
        return specificServicesExecutionStatusEnumList;
    }
}
