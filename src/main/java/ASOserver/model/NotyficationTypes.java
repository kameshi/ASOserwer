package ASOserver.model;

import java.util.ArrayList;
import java.util.List;

public class NotyficationTypes {
    public enum NotyficationTypesEnum {

        NOTIFICATION("powiadomienie"),
        REMINDER("przypomnienie"),
        DEMAND("wezwanie");
        private String notyficationTypes;

        private NotyficationTypesEnum(String notyficationTypes) {
            this.notyficationTypes = notyficationTypes;
        }

        public String getNotyficationTypes() {
            return notyficationTypes;
        }
    }

    public List<String> getNotyficationTypes() {
        List<String> notyficationTypesEnumList = new ArrayList<>();
        NotyficationTypesEnum[] notyficationTypesEnums = NotyficationTypesEnum.values();
        for (NotyficationTypesEnum notyficationTypesEnum : notyficationTypesEnums) {
            notyficationTypesEnumList.add(notyficationTypesEnum.getNotyficationTypes());
        }
        return notyficationTypesEnumList;
    }
}
