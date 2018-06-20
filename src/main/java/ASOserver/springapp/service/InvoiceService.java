package ASOserver.springapp.service;

import ASOserver.model.Invoice;
import ASOserver.springapp.dao.InvoiceDAO;
import ASOserver.springapp.dto.InvoiceDTO;
import ASOserver.springapp.mapper.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceDAO invoiceDAO;

    @Autowired
    public InvoiceService(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;
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
}
