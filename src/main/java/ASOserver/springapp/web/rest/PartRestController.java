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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/aso/rest/parts")
public class PartRestController {
    private final PartService partService;

    @Autowired
    public PartRestController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping()
    private ResponseEntity<Object> getParts(){
        try {
            List<PartDTO> partDTOList = this.partService.getParts();
            return new ResponseEntity<Object>(partDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    private ResponseEntity insertPart(@RequestBody PartDTO partDTO){
        try {
            this.partService.insertPart(partDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{partId}")
    private ResponseEntity findPart(@PathVariable Long partId) {
        try {
            PartDTO PartDTO = partService.findPartById(partId);
            return new ResponseEntity(PartDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{partId}")
    private ResponseEntity updatePart(@PathVariable Long partId, @RequestBody PartDTO partDTO) {
        try {
            partService.updatePart(partId, partDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{partId}")
    private ResponseEntity deletePart(@PathVariable Long partId) {
        try {
            partService.deletePart(partId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
