package ASOserver.springapp.dto;

import ASOserver.model.enums.PaymentMethod;

public class InvoiceDTO {

    private Long invoiceId;
    private float finalPrice;
    private PaymentMethod.PaymentMethodEnum paymentMethod;
    private SpecificServiceDTO specificServiceDTO;

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "invoiceId=" + invoiceId +
                ", finalPrice=" + finalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", specificServiceDTO=" + specificServiceDTO +
                '}';
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public PaymentMethod.PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod.PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public SpecificServiceDTO getSpecificServiceDTO() {
        return specificServiceDTO;
    }

    public void setSpecificServiceDTO(SpecificServiceDTO specificServiceDTO) {
        this.specificServiceDTO = specificServiceDTO;
    }
}
