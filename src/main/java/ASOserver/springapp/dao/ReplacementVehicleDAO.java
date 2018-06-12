package ASOserver.springapp.dao;

import ASOserver.model.ReplacementVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplacementVehicleDAO extends CrudRepository<ReplacementVehicle, Long> {
}
