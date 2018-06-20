package ASOserver.springapp.service;

import ASOserver.model.Notifications;
import ASOserver.springapp.dao.NotificationsDAO;
import ASOserver.springapp.dto.NotificationDTO;
import ASOserver.springapp.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationsDAO notificationsDAO;

    @Autowired
    public NotificationService(NotificationsDAO notificationsDAO) {
        this.notificationsDAO = notificationsDAO;
    }

    public List<NotificationDTO> findNotifications() throws Exception {
        Iterable<Notifications> notificationsIterable = this.notificationsDAO.findAll();
        List<NotificationDTO> NotificationDTOList = new ArrayList<>();
        for(Notifications notifications : notificationsIterable){
            NotificationDTOList.add(NotificationMapper.toNotificationDTO(notifications));
        }

        return NotificationDTOList;
    }

    public void insertNotification(NotificationDTO NotificationDTO) throws Exception {
        this.notificationsDAO.save(NotificationMapper.toNotification(NotificationDTO));
    }

    public NotificationDTO findNotificationById(Long notificationId) throws Exception {
        return NotificationMapper.toNotificationDTO(notificationsDAO.findById(notificationId).get());
    }

    public void updateNotification(Long notificationId, NotificationDTO notificationDTO) throws Exception {
        notificationDTO.setId(notificationId);
        notificationsDAO.save(NotificationMapper.toNotification(notificationDTO));
    }

    public void deleteNotification(Long notificationId) throws Exception {
        notificationsDAO.deleteById(notificationId);
    }
}
