package ASOserver.springapp.service;

import ASOserver.model.Customer;
import ASOserver.model.CustomerCar;
import ASOserver.model.Invoice;
import ASOserver.model.SpecificService;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dao.InvoiceDAO;
import ASOserver.springapp.dto.InvoiceDTO;
import ASOserver.springapp.dto.SpecificServiceDTO;
import ASOserver.springapp.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    private final InvoiceDAO invoiceDAO;
    private final CustomerDAO customerDAO;

    @Autowired
    public InvoiceService(InvoiceDAO invoiceDAO, CustomerDAO customerDAO) {
        this.invoiceDAO = invoiceDAO;
        this.customerDAO = customerDAO;
    }

    public void insertInvoice(InvoiceDTO invoiceDTO) {
        this.invoiceDAO.save(InvoiceMapper.toInvoice(invoiceDTO));
    }

    public List<InvoiceDTO> getInvoice() {
        Iterable<Invoice> invoiceIterable = this.invoiceDAO.findAll();
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();
        for(Invoice invoice : invoiceIterable){
            invoiceDTOList.add(InvoiceMapper.toInvoiceDTO(invoice));
        }
        return invoiceDTOList;
    }

    public InvoiceDTO findInvoice(Long invoiceID) {
        return InvoiceMapper.toInvoiceDTO(invoiceDAO.findById(invoiceID).get());
    }

    public void updateInvoice(Long invoiceID, InvoiceDTO invoiceDTO) {
        invoiceDTO.setInvoiceId(invoiceID);
        this.invoiceDAO.save(InvoiceMapper.toInvoice(invoiceDTO));
    }

    public void deleteInvoice(Long invoiceID) {
        this.invoiceDAO.deleteById(invoiceID);
    }

    public List<InvoiceDTO> getInvoiceByCustomerId(Long customerId) {
        Customer customer = customerDAO.findById(customerId).get();
        List<InvoiceDTO> invoiceDTOS = new ArrayList<>();
        for(CustomerCar customerCar : customer.getCustomerCars()) {
            for(SpecificService specificService : customerCar.getSpecificServices()) {
                for(Invoice invoice : specificService.getInvoices()) {
                    invoiceDTOS.add(InvoiceMapper.toInvoiceDTO(invoice));
                }
            }
        }
        return invoiceDTOS;
    }

    public void insertInvoice(SpecificService specificService, SpecificServiceDTO specificServiceDTO) {
        this.invoiceDAO.save(buildInvoice(specificService, specificServiceDTO));
    }

    private Invoice buildInvoice(SpecificService specificService, SpecificServiceDTO specificServiceDTO) {
        Invoice invoice = new Invoice();
        if(specificServiceDTO.getPromotion() == null)
            invoice.setFinalPrice((float)specificServiceDTO.getService().getPrice());
        else
            invoice.setFinalPrice((float)calculateFinalPrice(specificServiceDTO.getService().getPrice(), specificService.getPromotion().getPercent()));
        invoice.setPaymentMethod(specificServiceDTO.getInvoice().getPaymentMethod().getPaymentMethod());
        invoice.setSpecificService(specificService);
        return invoice;
    }

    private double calculateFinalPrice(double price, double percent) {
        return price - (price * percent / 100);
    }
}
