package ASOserver.springapp.mapper;

import ASOserver.model.Notification;
import ASOserver.springapp.dto.NotificationDTO;

public class NotificationMapper {

    public static NotificationDTO toNotificationDTO(Notification notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notification.getNotificationId());
        notificationDTO.setType(notification.getType());
        notificationDTO.setDescription(notification.getDescription());
        return notificationDTO;
    }

    public static Notification toNotification(NotificationDTO notificationDTO) {
        Notification notification = new Notification();
        notification.setNotificationId(notificationDTO.getId());
        notification.setType(notificationDTO.getType());
        notification.setDescription(notificationDTO.getDescription());
        return notification;
    }
}
