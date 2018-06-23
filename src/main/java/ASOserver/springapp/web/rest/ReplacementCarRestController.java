package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.ReplacementCarDTO;
import ASOserver.springapp.service.ReplacementCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/replacement-cars")
public class ReplacementCarRestController {
    private final ReplacementCarService replacementCarService;

    @Autowired
    public ReplacementCarRestController(ReplacementCarService replacementCarService) {
        this.replacementCarService = replacementCarService;
    }

    @PostMapping()
    private ResponseEntity<String> insertReplacementCars(@RequestBody ReplacementCarDTO replacementCarDTO){
        try {
            this.replacementCarService.insertReplacementCars(replacementCarDTO);
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
            List<ReplacementCarDTO> replacementCarDTOList = this.replacementCarService.getReplacementCars();
            return new ResponseEntity<Object>(replacementCarDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{replacementCarId}")
    private ResponseEntity findReplacementCar(@PathVariable Long replacementCarId) {
        try {
            ReplacementCarDTO replacementCarDTO = replacementCarService.findReplacementCarById(replacementCarId);
            return new ResponseEntity(replacementCarDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{replacementCarId}")
    private ResponseEntity updateReplacementCar(@PathVariable Long replacementCarId,
                                                @RequestBody ReplacementCarDTO replacementCarDTO) {
        try {
            replacementCarService.updateReplacementCars(replacementCarId, replacementCarDTO);
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
            replacementCarService.deleteReplacementCars(replacementCarId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
