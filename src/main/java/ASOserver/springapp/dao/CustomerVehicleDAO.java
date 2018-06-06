package ASOserver.springapp.dao;

import ASOserver.model.CustomerVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVehicleDAO extends CrudRepository<CustomerVehicle, Long> {
}
