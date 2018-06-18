package ASOserver.springapp.service;
import ASOserver.model.ReplacementCars;
import ASOserver.model.Cars;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dao.CarsDAO;
import ASOserver.springapp.dto.ReplacementCarsDTO;
import ASOserver.springapp.dto.CarsDTO;
import ASOserver.springapp.mapper.ReplacementCarsMapper;
import ASOserver.springapp.mapper.CarsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-06-14.
 */
@Service
public class CarsService {
    private final CarsDAO carsDAO;
    private final CustomerDAO customerDAO;
    private List<ReplacementCarsDTO> cars;

    @Autowired
    public CarsService(CarsDAO carsDAO, CustomerDAO customerDAO) {
        this.carsDAO = carsDAO;
        this.customerDAO = customerDAO;
    }

    public void insertCars(CarsDTO carsDTO) {
        this.carsDAO.save(CarsMapper.toCars(carsDTO));
    }
    public long getCarsId(String vin) throws Exception {
        return carsDAO.findCarsIdByVin(vin);
    }

    public List<CarsDTO> getCars() {
        Iterable<Cars> carsIterable = this.carsDAO.findAll();
        List<CarsDTO> carsDTOList = new ArrayList<>();
        for(Cars cars : carsIterable){
            carsDTOList.add(CarsMapper.toCarsDTO(cars));
        }

        return carsDTOList;
    }
    public List<CarsDTO> getCarsDTO() {
        Iterable<Cars> carsIterable = this.carsDAO.findAll();
        List<CarsDTO> carsDTOList = new ArrayList<>();
        for(Cars cars : carsIterable){
            carsDTOList.add(CarsMapper.toCarsDTO(cars));
        }

        return carsDTOList;
    }

}