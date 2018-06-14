package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_VEHICLE")
public class CustomerVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_VEHICLE_ID")
    private Long customerVehicle;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName="VEHICLE_ID")
    private Vehicle vehicle;

    public CustomerVehicle() {
    }

    public Long getCustomerVehicle() {
        return customerVehicle;
    }

    public void setCustomerVehicle(Long customerVehicle) {
        this.customerVehicle = customerVehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}