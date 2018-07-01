package ASOserver.springapp.dao;

import ASOserver.model.Notification;
import ASOserver.model.enums.NotificationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDAO extends CrudRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.type like ?1")
    Notification findByType(@Param("type") String type);
}
