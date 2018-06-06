package ASOserver.springapp.dao;

import ASOserver.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends CrudRepository<Vehicle, Long> {
}
