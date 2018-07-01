package ASOserver.springapp.web.rest;

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
@RequestMapping(value = "/aso/rest/invoices")
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
    private ResponseEntity<Object> getInvoices(){
        try {
            List<InvoiceDTO> invoiceDTOList = this.invoiceService.getInvoice();
            return new ResponseEntity<Object>(invoiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{invoiceId}")
    private ResponseEntity findInvoice(@PathVariable Long invoiceId) {
        try {
            InvoiceDTO invoiceDTO = invoiceService.findInvoice(invoiceId);
            return new ResponseEntity(invoiceDTO, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{invoiceId}")
    private ResponseEntity updateInvoice(@PathVariable Long invoiceId, @RequestBody InvoiceDTO invoiceDTO) {
        try {
            invoiceService.updateInvoice(invoiceId, invoiceDTO);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{invoiceId}")
    private ResponseEntity deleteInvoice(@PathVariable Long invoiceId) {
        try {
            invoiceService.deleteInvoice(invoiceId);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/customers/{accountId}")
    private ResponseEntity<Object> getInvoicesByCustomerId(@PathVariable Long accountId){
        try {
            List<InvoiceDTO> invoiceDTOList = this.invoiceService.getInvoiceByCustomerId(accountId);
            return new ResponseEntity<Object>(invoiceDTOList, HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
