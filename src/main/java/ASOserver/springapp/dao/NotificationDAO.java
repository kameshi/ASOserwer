package ASOserver.springapp.dao;

import ASOserver.model.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDAO extends CrudRepository<Notification, Long> {
}
