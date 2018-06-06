package ASOserver.springapp.dao;

import ASOserver.model.CustomerReplacementVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReplacementVehicleDAO extends CrudRepository<CustomerReplacementVehicle, Long> {
}
