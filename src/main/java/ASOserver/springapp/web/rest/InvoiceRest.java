package ASOserver.springapp.web.rest;

import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.dto.InvoiceDTO;
import ASOserver.springapp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("request")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/aso/rest/invoiceRest")
public class InvoiceRest {
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceRest(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    @PostMapping()
    private ResponseEntity insertInvoice(@RequestBody InvoiceDTO invoiceDTO){
        try {
            invoiceService.insertInvoice(invoiceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    private ResponseEntity<Object> getEmployees(){
        try {
            List<InvoiceDTO> invoiceDTOList = this.invoiceService.getInvoice();
            return new ResponseEntity<Object>(invoiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{invoiceID}")
    private ResponseEntity findInvoice(@PathVariable Long invoiceID) {
        try {
            InvoiceDTO invoiceDTO = invoiceService.findInvoice(invoiceID);
            return new ResponseEntity(invoiceDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{invoiceID}")
    private ResponseEntity updateInvoice(@PathVariable Long invoiceID, @RequestBody InvoiceDTO invoiceDTO) {
        try {
            invoiceService.updateInvoice(invoiceID, invoiceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{invoiceID}")
    private ResponseEntity deleteInvoice(@PathVariable Long invoiceID) {
        try {
            invoiceService.deleteInvoice(invoiceID);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
