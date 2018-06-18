package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.ReplacementCarsDTO;
import ASOserver.springapp.service.ReplacementCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/aso/rest/replacement-cars")
public class ReplacementCarsRestController {
    private final ReplacementCarsService replacementCarsService;

    @Autowired
    public ReplacementCarsRestController(ReplacementCarsService replacementCarsService) {
        this.replacementCarsService = replacementCarsService;
    }

    @PostMapping()
    private ResponseEntity<String> insertReplacementCars(@RequestBody ReplacementCarsDTO replacementCarsDTO){
        try {
            this.replacementCarsService.insertReplacementCars(replacementCarsDTO);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    private ResponseEntity<Object> getReplacementCars(){
        try {
            List<ReplacementCarsDTO> replacementCarsDTOList = this.replacementCarsService.getReplacementCars();
            return new ResponseEntity<Object>(replacementCarsDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{replacementCarId}")
    private ResponseEntity findReplacementCar(@PathVariable Long replacementCarId) {
        try {
            ReplacementCarsDTO replacementCarsDTO = replacementCarsService.findReplacementCarById(replacementCarId);
            return new ResponseEntity(replacementCarsDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{replacementCarId}")
    private ResponseEntity updateReplacementCar(@PathVariable Long replacementCarId,
                                                @RequestBody ReplacementCarsDTO replacementCarsDTO) {
        try {
            replacementCarsService.updateReplacementCars(replacementCarId, replacementCarsDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{replacementCarId}")
    private ResponseEntity deleteReplacementCar(@PathVariable Long replacementCarId) {
        try {
            replacementCarsService.deleteReplacementCars(replacementCarId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
