package ASOserver.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class NotificationType {
    public enum NotificationTypeEnum {
        NOTIFICATION("powiadomienie"),
        REMINDER("przypomnienie"),
        DEMAND("wezwanie");

        private String NotificationType;

        private NotificationTypeEnum(String NotificationType) {
            this.NotificationType = NotificationType;
        }

        @JsonCreator
        public static NotificationTypeEnum fromValue(String value) {
            return getNotificationType(value);
        }

        @JsonValue
        public String toJson() {
            return getNotificationType();
        }

        public String getNotificationType() {
            return NotificationType;
        }
    }

    public List<String> getNotificationTypes() {
        List<String> NotificationTypeEnumList = new ArrayList<>();
        NotificationTypeEnum[] NotificationTypeEnums = NotificationTypeEnum.values();
        for (NotificationTypeEnum NotificationTypeEnum : NotificationTypeEnums) {
            NotificationTypeEnumList.add(NotificationTypeEnum.getNotificationType());
        }
        return NotificationTypeEnumList;
    }
}
