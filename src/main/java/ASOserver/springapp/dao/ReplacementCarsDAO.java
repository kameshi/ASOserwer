package ASOserver.springapp.dao;

import ASOserver.model.ReplacementCars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementCarsDAO extends CrudRepository<ReplacementCars, Long> {
}
