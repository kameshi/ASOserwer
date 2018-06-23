package ASOserver.model;

import ASOserver.model.enums.PaymentMethod;
import javax.persistence.*;

@Entity
@Table(name = "INVOICE")
public class Invoice{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INVOICE_ID")
    private Long invoiceId;

    @Column(name = "FINAL_PRICE", nullable = false)
    private float finalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_METHOD", nullable = false)
    private PaymentMethod.PaymentMethodEnum paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "SPECIFIC_SERVICE_ID")
    private SpecificService specificService;

    public Invoice() {
    }

    public Invoice(float finalPrice, PaymentMethod.PaymentMethodEnum paymentMethod, SpecificService specificService) {
        this.finalPrice = finalPrice;
        this.paymentMethod = paymentMethod;
        this.specificService = specificService;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        invoiceId = invoiceId;
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

    public SpecificService getSpecificService() {
        return specificService;
    }

    public void setSpecificService(SpecificService specificService) {
        this.specificService = specificService;
    }
}