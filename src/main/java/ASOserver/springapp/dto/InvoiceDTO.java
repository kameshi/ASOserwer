package ASOserver.springapp.dto;

import java.io.Serializable;

public class InvoiceDTO implements Serializable {

    private Long InvoiceId;
    private float finalPrice;
    private String paymentMethod;
    private SpecificServiceDTO specificService;

    public Long getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        InvoiceId = invoiceId;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SpecificServiceDTO getSpecificService() {
        return specificService;
    }

    public void setSpecificService(SpecificServiceDTO specificService) {
        this.specificService = specificService;
    }
}
