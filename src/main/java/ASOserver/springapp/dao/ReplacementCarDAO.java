package ASOserver.springapp.dao;

import ASOserver.model.ReplacementCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementCarDAO extends CrudRepository<ReplacementCar, Long> {
}
