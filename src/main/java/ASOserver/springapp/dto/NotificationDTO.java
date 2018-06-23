package ASOserver.springapp.dto;

import ASOserver.model.enums.NotificationType;

import java.io.Serializable;

public class NotificationDTO implements Serializable {
    private Long id;
    private NotificationType.NotificationTypeEnum type;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
