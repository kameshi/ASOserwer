package ASOserver.springapp.service;

import ASOserver.model.Notification;
import ASOserver.springapp.dao.NotificationDAO;
import ASOserver.springapp.dto.NotificationDTO;
import ASOserver.springapp.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationDAO notificationDAO;

    @Autowired
    public NotificationService(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    public List<NotificationDTO> findNotifications() throws Exception {
        Iterable<Notification> notificationsIterable = this.notificationDAO.findAll();
        List<NotificationDTO> NotificationDTOList = new ArrayList<>();
        for(Notification notification : notificationsIterable){
            NotificationDTOList.add(NotificationMapper.toNotificationDTO(notification));
        }

        return NotificationDTOList;
    }

    public void insertNotification(NotificationDTO NotificationDTO) throws Exception {
        this.notificationDAO.save(NotificationMapper.toNotification(NotificationDTO));
    }

    public NotificationDTO findNotificationById(Long notificationId) throws Exception {
        return NotificationMapper.toNotificationDTO(notificationDAO.findById(notificationId).get());
    }

    public void updateNotification(Long notificationId, NotificationDTO notificationDTO) throws Exception {
        notificationDTO.setId(notificationId);
        notificationDAO.save(NotificationMapper.toNotification(notificationDTO));
    }

    public void deleteNotification(Long notificationId) throws Exception {
        notificationDAO.deleteById(notificationId);
    }
}
