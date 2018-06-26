package ASOserver.model.enums;

import java.util.ArrayList;
import java.util.List;

public class NotificationType {
    public enum NotificationTypeEnum {
        NOTIFICATION("powiadomienie"),
        REMINDER("przypomnienie"),
        DEMAND("wezwanie");

        private String notificationType;

        private NotificationTypeEnum(String notificationType) {
            this.notificationType = notificationType;
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
