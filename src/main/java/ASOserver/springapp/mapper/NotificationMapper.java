package ASOserver.springapp.mapper;

import ASOserver.model.Notifications;
import ASOserver.springapp.dto.NotificationDTO;

public class NotificationMapper {
    public static NotificationDTO toNotificationDTO(Notifications notifications) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notifications.getNotificationsId());
        notificationDTO.setTape(notifications.getType());
        notificationDTO.setDescription(notifications.getDescription());
        return notificationDTO;
    }

    public static Notifications toNotification(NotificationDTO notificationDTO) {
        Notifications notifications = new Notifications();
        notifications.setNotificationsId(notificationDTO.getId());
        notifications.setType(notificationDTO.getTape());
        notifications.setDescription(notificationDTO.getDescription());
        return notifications;
    }
}
