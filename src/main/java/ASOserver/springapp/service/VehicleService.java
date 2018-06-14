package ASOserver.springapp.service;
import ASOserver.model.Vehicle;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dao.VehicleDAO;
import ASOserver.springapp.dto.VehicleDTO;
import ASOserver.springapp.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by user on 2018-06-14.
 */
@Service
public class VehicleService {
    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleService(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public void insertVehicle(VehicleDTO vehicleDTO) {
        this.vehicleDAO.save(VehicleMapper.toVehicle(vehicleDTO));
    }
    public long getVehicleId(String vin) throws Exception {
        return vehicleDAO.findVehicleIdByVin(vin);
    }
}