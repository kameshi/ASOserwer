package ASOserver.springapp.mapper;

import ASOserver.model.Invoice;
import ASOserver.springapp.dto.InvoiceDTO;

public class InvoiceMapper {

    public static InvoiceDTO toInvoiceDTO(Invoice invoice){
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceId(invoice.getInvoiceId());
        invoiceDTO.setFinalPrice(invoice.getFinalPrice());
        invoiceDTO.setPaymentMethod(invoice.getPaymentMethod());
        invoiceDTO.setSpecificServiceDTO(SpecificServiceMapper.toSpecificServiceDTO(invoice.getSpecificService()));
        return invoiceDTO;
    }

    public static Invoice toInvoice(InvoiceDTO invoiceDTO){
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceDTO.getInvoiceId());
        invoice.setFinalPrice(invoiceDTO.getFinalPrice());
        invoice.setPaymentMethod(invoiceDTO.getPaymentMethod());
        invoice.setSpecificService(SpecificServiceMapper.toSpecificService(invoiceDTO.getSpecificServiceDTO()));
        return invoice;
    }
}