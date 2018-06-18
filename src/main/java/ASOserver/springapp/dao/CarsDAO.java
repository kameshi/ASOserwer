package ASOserver.springapp.dao;

import ASOserver.model.Cars;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsDAO extends CrudRepository<Cars, Long> {
    @Query("SELECT v.id FROM Cars v WHERE v.vin like ?1")
    long findCarsIdByVin(@Param("vin") String vin);
}
