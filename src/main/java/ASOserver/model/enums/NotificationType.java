package ASOserver.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

public class NotificationType {
    public enum NotificationTypeEnum {
        OVERVIEW("przeglad"),
        PROMOTION("promocja"),
        END("zakończenie");

        private String notificationType;

        private NotificationTypeEnum(String notificationType) {
            this.notificationType = notificationType;
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
            return notificationType;
        }

        public static NotificationTypeEnum getNotificationType(String type) {
            for(NotificationTypeEnum current : NotificationTypeEnum.values()) {
                if(current.notificationType.equals(type)) {
                    return current;
                }
            }
            return null;
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