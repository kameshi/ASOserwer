package ASOserver.springapp.dao;

import ASOserver.model.CustomerCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCarDAO extends CrudRepository<CustomerCar, Long> {
}
