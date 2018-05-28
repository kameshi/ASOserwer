package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_REPLACEMENT_VEHICLE")
public class CustomerReplacementVehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_VEHICLE_ID")
    private Long customerReplacementVehicle;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "REPLACMENT_VEHICLE_ID", referencedColumnName="REPLACMENT_VEHICLE_ID")
    private ReplacementVehicle replacementVehicle;

    public CustomerReplacementVehicle() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ReplacementVehicle getReplacementVehicle() {
        return replacementVehicle;
    }

    public void setReplacementVehicle(ReplacementVehicle replacementVehicle) {
        this.replacementVehicle = replacementVehicle;
    }
}
