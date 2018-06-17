package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "INVOICE")
public class Invoice{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INVOICE_ID")
    private Long InvoiceId;

    @Column(name = "FINAL_PRICE", nullable = false)
    private float finalPrice;

    @Column(name = "PAYMENT_METHOD", nullable = false)
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SPECYFIC_SERVICE_ID")
    private SpecificService specificService;

    public Invoice() {
    }

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

    public SpecificService getSpecificService() {
        return specificService;
    }

    public void setSpecificService(SpecificService specificService) {
        this.specificService = specificService;
    }
}