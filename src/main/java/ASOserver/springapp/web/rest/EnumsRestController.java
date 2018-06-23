package ASOserver.springapp.web.rest;

import ASOserver.springapp.service.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/")
public class EnumsRestController {
    private final AccessRightService accessRightService;
    private final PaymentMethodService paymentMethodService;
    private final ServiceTypesService serviceTypesService;
    private final SpecificServiceStatusService specificServiceStatusService;
    private final NotificationTypeService notificationTypeService;


    @Autowired
    public EnumsRestController(AccessRightService accessRightService, PaymentMethodService paymentMethodService,
                               ServiceTypesService serviceTypesService, SpecificServiceStatusService specificServiceStatusService,
                               NotificationTypeService notificationTypeService) {
        this.accessRightService = accessRightService;
        this.paymentMethodService = paymentMethodService;
        this.serviceTypesService = serviceTypesService;
        this.specificServiceStatusService = specificServiceStatusService;
        this.notificationTypeService = notificationTypeService;
    }

    @GetMapping(value="access-rights")
    private ResponseEntity getAccessRights(){
        try {
            List<String> accessRightsList = this.accessRightService.getAccessRights();
            return new ResponseEntity(accessRightsList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="notification-types")
    private ResponseEntity getNotyficationTypes(){
        try{
            List<String> notyficationTypesList = this.notificationTypeService.getNotificationTypes();
            return new ResponseEntity(notyficationTypesList, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="payment-methods")
    private ResponseEntity getPaymentMethods(){
        try{
            List<String> paymentMethod = this.paymentMethodService.getPaymentMethods();
            return new ResponseEntity(paymentMethod, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="service-types")
    private ResponseEntity getServiceTypes(){
        try{
            List<String> serviceTypes = this.serviceTypesService.getServiceTypes();
            return new ResponseEntity(serviceTypes, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="specific-services-statuses")
    private ResponseEntity getSpecificServiceStatuses(){
        try{
            List<String> specificServicesExecutionStatus = this.specificServiceStatusService.getSpecificServiceStatuses();
            return new ResponseEntity(specificServicesExecutionStatus, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
