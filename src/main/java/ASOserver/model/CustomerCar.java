package ASOserver.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_CAR")
public class CustomerCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_CAR_ID")
    private Long customerCarId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "CAR_ID", referencedColumnName="CAR_ID")
    private Car car;

    @OneToMany(mappedBy = "customerCar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SpecificService> specificServices;

    public CustomerCar() {
    }

    public CustomerCar(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
    }

    public Long getCustomerCarId() {
        return customerCarId;
    }

    public void setCustomerCarId(Long customerCarId) {
        this.customerCarId = customerCarId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<SpecificService> getSpecificServices() {
        return specificServices;
    }

    public void setSpecificServices(List<SpecificService> specificServices) {
        this.specificServices = specificServices;
    }
}