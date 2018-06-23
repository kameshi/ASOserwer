package ASOserver.model.enums;

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
