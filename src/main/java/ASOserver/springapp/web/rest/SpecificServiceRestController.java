package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.SpecificServiceDTO;
import ASOserver.springapp.service.SpecificServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/specific-services")
public class SpecificServiceRestController {
    private final SpecificServiceService specificServiceService;

    @Autowired
    public SpecificServiceRestController(SpecificServiceService specificServiceService) {
        this.specificServiceService = specificServiceService;
    }

    @GetMapping()
    private ResponseEntity findSpecificServices(){
        try {
            List<SpecificServiceDTO> specificServiceDTOList = specificServiceService.findSpecificServices();
            return new ResponseEntity(specificServiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    private ResponseEntity insertSpecificService(@RequestBody SpecificServiceDTO specificServiceDTO){
        try {
            specificServiceService.insertSpecificService(specificServiceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{specificServiceId}")
    private ResponseEntity findSpecificService(@PathVariable Long specificServiceId) {
        try {
            SpecificServiceDTO specificServiceDTO = specificServiceService.findSpecificServiceById(specificServiceId);
            return new ResponseEntity(specificServiceDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{specificServiceId}")
    private ResponseEntity updateSpecificService(@PathVariable Long specificServiceId, @RequestBody SpecificServiceDTO specificServiceDTO) {
        try {
            specificServiceService.updateSpecificService(specificServiceId, specificServiceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{specificServiceId}")
    private ResponseEntity deleteSpecificService(@PathVariable Long specificServiceId) {
        try {
            specificServiceService.deleteSpecificService(specificServiceId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/employees/{employeeId}")
    private ResponseEntity findSpecificServicesByEmployeeId(@PathVariable Long employeeId){
        try {
            List<SpecificServiceDTO> specificServiceDTOList = specificServiceService.findSpecificServicesByEmployeeId(employeeId);
            return new ResponseEntity(specificServiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customers/{customerId}")
    private ResponseEntity findSpecificServicesByCustomerId(@PathVariable Long customerId){
        try {
            List<SpecificServiceDTO> specificServiceDTOList = specificServiceService.findSpecificServicesByCustomerId(customerId);
            return new ResponseEntity(specificServiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/cars/{carId}")
    private ResponseEntity findSpecificServicesByCarId(@PathVariable Long carId){
        try {
            List<SpecificServiceDTO> specificServiceDTOList = specificServiceService.findSpecificServicesByCarId(carId);
            return new ResponseEntity(specificServiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
