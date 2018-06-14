package ASOserver.springapp.dao;

import ASOserver.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends CrudRepository<Vehicle, Long> {
    @Query("SELECT v.id FROM Vehicle v WHERE v.vin like ?1")
    long findVehicleIdByVin(@Param("vin") String vin);
}
