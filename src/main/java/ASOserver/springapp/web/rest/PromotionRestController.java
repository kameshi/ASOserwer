package ASOserver.springapp.web.rest;

/**
 * Created by user on 2018-06-14.
 */
import ASOserver.common.HashUtils;
import ASOserver.model.Employee;
import ASOserver.springapp.dto.AccountDTO;
import ASOserver.springapp.dto.CustomerDTO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.dto.PromotionDTO;
import ASOserver.springapp.mapper.EmployeeMapper;
import ASOserver.springapp.service.AccountService;
import ASOserver.springapp.service.CustomerService;
import ASOserver.springapp.service.EmployeeService;
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
@RequestMapping(value = "/ASOserver/rest/promotoion")
public class PromotionRestController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionRestController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }


    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity insertCategory(@RequestBody PromotionDTO promotionDTO){
        try {
            System.out.println();
            System.out.println(promotionDTO.toString());
            System.out.println();
            this.promotionService.insertPromotion(promotionDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
