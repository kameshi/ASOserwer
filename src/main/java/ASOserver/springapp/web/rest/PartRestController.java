package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.PartDTO;
import ASOserver.springapp.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ASOserver/rest/parts")
public class PartRestController {

    private final PartService partService;

    @Autowired
    public PartRestController(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getPart(){
        try {
            List<PartDTO> partDTOList = this.partService.getPart();
            return new ResponseEntity<Object>(partDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCategory(@RequestBody PartDTO partDTO){
        try {
            this.partService.insertPart(partDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
