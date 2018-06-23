package ASOserver.springapp.dao;

import ASOserver.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDAO extends CrudRepository<Car, Long> {
    @Query("SELECT v.id FROM Car v WHERE v.vin like ?1")
    long findCarsIdByVin(@Param("vin") String vin);
}
