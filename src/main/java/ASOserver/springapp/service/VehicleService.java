package ASOserver.springapp.service;
import ASOserver.model.ReplacementVehicle;
import ASOserver.model.Vehicle;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dao.VehicleDAO;
import ASOserver.springapp.dto.ReplacementVehicleDTO;
import ASOserver.springapp.dto.VehicleDTO;
import ASOserver.springapp.mapper.ReplacementVehicleMapper;
import ASOserver.springapp.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-06-14.
 */
@Service
public class VehicleService {
    private final VehicleDAO vehicleDAO;
    private List<ReplacementVehicleDTO> vehicle;

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

    public List<VehicleDTO> getVehicle() {
        Iterable<Vehicle> vehicleIterable = this.vehicleDAO.findAll();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        for(Vehicle vehicle : vehicleIterable){
            vehicleDTOList.add(VehicleMapper.toVehicleDTO(vehicle));
        }

        return vehicleDTOList;
    }
}