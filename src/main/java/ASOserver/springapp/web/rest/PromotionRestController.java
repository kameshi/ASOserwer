package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.PromotionDTO;
import ASOserver.springapp.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/promotions")
public class PromotionRestController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionRestController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }


    @PostMapping()
    private ResponseEntity insertPromotion(@RequestBody PromotionDTO promotionDTO) {
        try {
            this.promotionService.insertPromotion(promotionDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping()
    private ResponseEntity findPromotions() {
        try {
            List<PromotionDTO> promotions = promotionService.findPromotions();
            return new ResponseEntity(promotions, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{promotionId}")
    private ResponseEntity findPromotion(@PathVariable Long promotionId) {
        try {
            PromotionDTO promotionDTO = promotionService.findPromotionById(promotionId);
            return new ResponseEntity(promotionDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{promotionId}")
    private ResponseEntity updatePromotion(@PathVariable Long promotionId, @RequestBody PromotionDTO promotionDTO) {
        try {
            promotionService.updatePromotion(promotionId, promotionDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{promotionId}")
    private ResponseEntity deletePromotion(@PathVariable Long promotionId) {
        try {
            promotionService.deletePromotion(promotionId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
