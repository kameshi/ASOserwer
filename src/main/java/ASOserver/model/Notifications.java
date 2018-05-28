package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "NOTIFICATIONS")
public class Notifications{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTIFICATIONS_ID")
    private Long NotificationsId;

    @Column(name = "TYPE", nullable = false, unique = true)
    private String type;

    @Column(name = "DESCRIPTION", nullable = false, unique = true)
    private String description;

    public Notifications() {
    }

    public Long getNotificationsId() {
        return NotificationsId;
    }

    public void setNotificationsId(Long notificationsId) {
        NotificationsId = notificationsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}