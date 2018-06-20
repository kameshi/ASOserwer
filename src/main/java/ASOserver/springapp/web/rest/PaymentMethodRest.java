package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/ASOserver/rest/PaymentMethodRest")
public class PaymentMethodRest {

    private final PaymentMethodService paymentMethodService;

    @Autowired
    public PaymentMethodRest(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<Object> getPaymentMethod(){
        try{
            List<String> paymentMethod = this.paymentMethodService.getPaymentMethod();
            return new ResponseEntity<Object>(paymentMethod, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
