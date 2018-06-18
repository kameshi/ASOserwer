package ASOserver.springapp.dao;

import ASOserver.model.CustomerCars;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCarsDAO extends CrudRepository<CustomerCars, Long> {
}
