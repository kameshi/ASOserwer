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
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ASOserver/rest/replacement-cars")
public class ReplacementCarsRestController {

    private final ReplacementCarsService replacementCarsService;

    @Autowired
    public ReplacementCarsRestController(ReplacementCarsService replacementCarsService) {
        this.replacementCarsService = replacementCarsService;
    }


    @RequestMapping(method = RequestMethod.POST)
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

    @RequestMapping(method = RequestMethod.GET)
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

}
