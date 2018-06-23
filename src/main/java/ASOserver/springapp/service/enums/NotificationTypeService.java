package ASOserver.springapp.service.enums;

import ASOserver.model.enums.NotificationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTypeService {
    NotificationType notificationType = new NotificationType();

    public List<String> getNotificationTypes() {
        List <String> notyficationTypesList = notificationType.getNotificationTypes();
        return notyficationTypesList;
    }
}
