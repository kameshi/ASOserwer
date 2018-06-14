package ASOserver.springapp.service;

/**
 * Created by user on 2018-06-14.
 */
import ASOserver.springapp.dao.CustomerVehicleDAO;
import ASOserver.springapp.dto.VehicleDTO;
import ASOserver.springapp.mapper.CustomerVehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerVehicleService {

    private final CustomerVehicleDAO customerVehicleDAO;

    @Autowired
    public CustomerVehicleService(CustomerVehicleDAO customerVehicleDAO) {
        this.customerVehicleDAO = customerVehicleDAO;
    }

    public void insertCustomerVehicle(VehicleDTO vehicleDTO) throws Exception {
        this.customerVehicleDAO.save(CustomerVehicleMapper.toCustomerVehicle(vehicleDTO));
    }
}
