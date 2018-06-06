package ASOserver.springapp.dao;

import ASOserver.model.ServicePart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePartDAO extends CrudRepository<ServicePart, Long> {
}
