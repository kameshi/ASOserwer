package ASOserver.springapp.dto;


import java.io.Serializable;

public class NotificationsDTO implements Serializable {

    private Long NotificationsId;
    private String type;
    private String description;

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
