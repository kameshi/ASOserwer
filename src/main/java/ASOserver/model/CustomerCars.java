package ASOserver.model;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_CARS")
public class CustomerCars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_CARS_ID")
    private Long customerCars;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "CARS_ID", referencedColumnName="CARS_ID")
    private Cars cars;

    public CustomerCars() {
    }

    public Long getCustomerCars() {
        return customerCars;
    }

    public void setCustomerCars(Long customerCars) {
        this.customerCars = customerCars;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}