package ASOserver.model;

import ASOserver.model.enums.NotificationType;
import javax.persistence.*;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTIFICATION_ID")
    private Long notificationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private NotificationType.NotificationTypeEnum type;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;


    public Notification() {
    }

    public Notification(NotificationType.NotificationTypeEnum type, String description) {
        this.type = type;
        this.description = description;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public NotificationType.NotificationTypeEnum getType() {
        return type;
    }

    public void setType(NotificationType.NotificationTypeEnum type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}