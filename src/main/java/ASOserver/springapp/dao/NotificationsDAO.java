package ASOserver.springapp.dao;

import ASOserver.model.Notifications;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsDAO extends CrudRepository<Notifications, Long> {
}
