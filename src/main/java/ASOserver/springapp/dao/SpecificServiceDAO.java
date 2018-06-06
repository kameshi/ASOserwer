package ASOserver.springapp.dao;

import ASOserver.model.SpecificService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificServiceDAO extends CrudRepository<SpecificService, Long> {
}
