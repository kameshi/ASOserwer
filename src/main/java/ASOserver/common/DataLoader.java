package ASOserver.common;

import ASOserver.configuration.SecurityConfiguration;
import ASOserver.model.*;
import ASOserver.model.enums.*;
import ASOserver.springapp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Component
public class DataLoader implements ApplicationRunner {
    private final AccountDAO accountDAO;
    private final CarDAO carDAO;
    private final CustomerCarDAO customerCarDAO;
    private final CustomerDAO customerDAO;
    private final EmployeeDAO employeeDAO;
    private final InvoiceDAO invoiceDAO;
    private final NotificationDAO notificationDAO;
    private final PartDAO partDAO;
    private final PromotionDAO promotionDAO;
    private final ReplacementCarDAO replacementCarDAO;
    private final ServiceDAO serviceDAO;
    private final ServicePartDAO servicePartDAO;
    private final SpecificServiceDAO specificServiceDAO;

    @Autowired
    public DataLoader(AccountDAO accountDAO, CarDAO carDAO, CustomerCarDAO customerCarDAO, CustomerDAO customerDAO,
                      EmployeeDAO employeeDAO, InvoiceDAO invoiceDAO, NotificationDAO notificationDAO, PartDAO partDAO,
                      PromotionDAO promotionDAO, ReplacementCarDAO replacementCarDAO, ServiceDAO serviceDAO,
                      ServicePartDAO servicePartDAO, SpecificServiceDAO specificServiceDAO) {
        this.accountDAO = accountDAO;
        this.carDAO = carDAO;
        this.customerCarDAO = customerCarDAO;
        this.customerDAO = customerDAO;
        this.employeeDAO = employeeDAO;
        this.invoiceDAO = invoiceDAO;
        this.notificationDAO = notificationDAO;
        this.partDAO = partDAO;
        this.promotionDAO = promotionDAO;
        this.replacementCarDAO = replacementCarDAO;
        this.serviceDAO = serviceDAO;
        this.servicePartDAO = servicePartDAO;
        this.specificServiceDAO = specificServiceDAO;
    }

    public void run(ApplicationArguments args) {
        try {
            List<Account> accounts = loadAccounts();
            List<Car> cars = loadCars();
            List<Customer> customers = loadCustomers(accounts);
            List<CustomerCar> customerCars = loadCustomerCars(customers, cars);
            List<Employee> employees = loadEmployees(accounts);
            List<Notification> notifications = loadNotifications();
            List<Part> parts = loadParts();
            List<ReplacementCar> replacementCars = loadReplacementCars();
            List<Service> services = loadServices();
            List<Promotion> promotions = loadPromotions(services);
            List<SpecificService> specificServices = loadSpecificServices(employees, promotions, customerCars, replacementCars, services);
            List<ServicePart> serviceParts = loadServiceParts(specificServices, parts);
            List<Invoice> invoices = loadInvoices(specificServices);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Account> loadAccounts() throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        List<Account> accounts = new ArrayList<>();
        accounts.add(accountDAO.save(new Account("admin", encoder.encode("admin"), AccessRight.AccessRightEnum.ADMINISTRATOR.getAccessRight(), true)));
        accounts.add(accountDAO.save(new Account("karolm", encoder.encode("karolm"), AccessRight.AccessRightEnum.CUSTOMER.getAccessRight(), true)));
        accounts.add(accountDAO.save(new Account("marekm", encoder.encode("marekm"), AccessRight.AccessRightEnum.CUSTOMER.getAccessRight(), true)));
        accounts.add(accountDAO.save(new Account("mateuszm", encoder.encode("mateuszm"), AccessRight.AccessRightEnum.CUSTOMER.getAccessRight(), true)));
        accounts.add(accountDAO.save(new Account("damianl", encoder.encode("damianl"), AccessRight.AccessRightEnum.CUSTOMER.getAccessRight(), true)));
        accounts.add(accountDAO.save(new Account("pracownik1", encoder.encode("pracownik1"), AccessRight.AccessRightEnum.MECHANIC.getAccessRight(), true)));
        accounts.add(accountDAO.save(new Account("pracownik2", encoder.encode("pracownik2"), AccessRight.AccessRightEnum.OFFICEWORKER.getAccessRight(), true)));
        return accounts;
    }

    private List<Car> loadCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(carDAO.save(new Car("Seat", "Leon", "TSA AU74", "JTJHW31U560039130", (float) 1.6, 102, Date.valueOf("2018-07-02"))));
        cars.add(carDAO.save(new Car("Renault", "Megan", "TST HF43G", "WF0AXXWPMAGR69936", (float) 1.9, 101, Date.valueOf("2018-07-02"))));
        cars.add(carDAO.save(new Car("Volkswagen", "Polo", "TK GF53G", "WAUZZZ8E86A040764", (float) 1.2, 75, Date.valueOf("2019-07-02"))));
        cars.add(carDAO.save(new Car("Citroen", "Saxo", "TK G45SH", "WF0AXXWPMAFY46539", (float) 1.1, 55, Date.valueOf("2018-07-02"))));
        return cars;
    }

    private List<Customer> loadCustomers(List<Account> accounts) {
        List<Customer> customers = new ArrayList<>();
        customers.add(customerDAO.save(new Customer("Marek", "Madeła", "93121244674", "marek.madela@onet.pl", "666710482", accounts.get(2))));
        customers.add(customerDAO.save(new Customer("Mateusz", "Maciąg", "93121245739", "marek.madela@onet.pl", "534565452", accounts.get(3))));
        customers.add(customerDAO.save(new Customer("Damian", "Łyżwa", "95121275636", "marek.madela@onet.pl", "666710482", accounts.get(4))));
        customers.add(customerDAO.save(new Customer("Karol", "Marchewka", "93121278979", "marek.madela@onet.pl", "654656325", accounts.get(1))));
        return customers;
    }

    private List<CustomerCar> loadCustomerCars(List<Customer> customers, List<Car> cars) {
        List<CustomerCar> customerCars = new ArrayList<>();
        customerCars.add(customerCarDAO.save(new CustomerCar(customers.get(0), cars.get(0))));
        customerCars.add(customerCarDAO.save(new CustomerCar(customers.get(1), cars.get(1))));
        customerCars.add(customerCarDAO.save(new CustomerCar(customers.get(2), cars.get(2))));
        customerCars.add(customerCarDAO.save(new CustomerCar(customers.get(3), cars.get(3))));
        return customerCars;
    }

    private List<Employee> loadEmployees(List<Account> accounts) {
        List<Employee> employees = new ArrayList<>();
        employees.add(employeeDAO.save(new Employee("Andrzej", "Kowalski", "pracownik1@aso.pl", "83121244364", "83121244364", accounts.get(5))));
        employees.add(employeeDAO.save(new Employee("Janusz", "Stefańczyk", "pracownik2@aso.pl", "73121277539", "865346856", accounts.get(6))));
        employees.add(employeeDAO.save(new Employee("Rafał", "Nowak", "admin@aso.pl", "64120187555", "789246872", accounts.get(0))));
        return employees;
    }

    private List<Notification> loadNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(notificationDAO.save(new Notification(NotificationType.NotificationTypeEnum.END.getNotificationType(), "Zakończyliśmy pracę na samochodem o numerze rejestracyjnym %s. Zapraszamy po odbiór")));
        notifications.add(notificationDAO.save(new Notification(NotificationType.NotificationTypeEnum.PROMOTION.getNotificationType(), "Nowa promocja \"%s\" od %s do %s. Po więcej informacji zapraszamy do warsztatu.")));
        notifications.add(notificationDAO.save(new Notification(NotificationType.NotificationTypeEnum.OVERVIEW.getNotificationType(), "Dla samochodu %s w dniu %s kończy się ważność przeglądu")));
        return notifications;
    }

    private List<Part> loadParts() {
        List<Part> parts = new ArrayList<>();
        parts.add(partDAO.save(new Part("klocki hamulcowe seat leon przód", 25, 250.34)));
        parts.add(partDAO.save(new Part("wkład lusterka volkswagen polo prawe", 2, 25)));
        parts.add(partDAO.save(new Part("świece zapłonowe citroen saxo", 30, 50.4)));
        parts.add(partDAO.save(new Part("chłodnica renault megan", 1, 124.99)));
        return parts;
    }

    private List<ReplacementCar> loadReplacementCars() {
        List<ReplacementCar> replacementCars = new ArrayList<>();
        replacementCars.add(replacementCarDAO.save(new ReplacementCar("Ford", "Mustang", "TK HR54U", "WF0GXXPSWGXS40039")));
        replacementCars.add(replacementCarDAO.save(new ReplacementCar("Mazda", "Rx8", "TK DVR53", "WF0GXXPSWGXS40039")));
        replacementCars.add(replacementCarDAO.save(new ReplacementCar("Suzuki", "Vitara", "TK SMG2A", "WBAAL71010KE15545")));
        replacementCars.add(replacementCarDAO.save(new ReplacementCar("Lexus", "LC 500h", "TK X353V", "W0L0ZCF6861011982")));
        return replacementCars;
    }

    private List<Service> loadServices() {
        List<Service> services = new ArrayList<>();
        services.add(serviceDAO.save(new Service("wymiana klocków", ServiceType.ServiceTypeEnum.EXCHANGE.getServiceType(), (double) 100)));
        services.add(serviceDAO.save(new Service("przegląd samochodu z gazem", ServiceType.ServiceTypeEnum.OVERVIEW.getServiceType(), (double) 120)));
        services.add(serviceDAO.save(new Service("przegląd samochodu", ServiceType.ServiceTypeEnum.OVERVIEW.getServiceType(), (double) 80)));
        services.add(serviceDAO.save(new Service("analia samochodu przed zakupem", ServiceType.ServiceTypeEnum.ANALYSIS.getServiceType(), (double) 150)));
        services.add(serviceDAO.save(new Service("naprawa układu zapłonowego", ServiceType.ServiceTypeEnum.REPAIR.getServiceType(), (double) 50)));
        services.add(serviceDAO.save(new Service("wymiana wkład lusterka", ServiceType.ServiceTypeEnum.EXCHANGE.getServiceType(), (double) 300)));
        services.add(serviceDAO.save(new Service("wymiana chłodnicy", ServiceType.ServiceTypeEnum.EXCHANGE.getServiceType(), (double) 130)));
        return services;
    }

    private List<Promotion> loadPromotions(List<Service> services) {
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(promotionDAO.save(new Promotion("przeglad kwiecień 2018", "promocja na przeglad samochodu z instalacją gazową w kwietniu 2018 -20%", Date.valueOf("2018-4-1"), Date.valueOf("2018-4-30"), 20, services.get(1))));
        promotions.add(promotionDAO.save(new Promotion("przeglad maj 2018", "promocja na przeglad samochodu bez instalacji gazowej w maju 2018 -20%", Date.valueOf("2018-5-1"), Date.valueOf("2018-5-31"), 20, services.get(2))));
        return promotions;
    }

    private List<SpecificService> loadSpecificServices(List<Employee> employees, List<Promotion> promotions, List<CustomerCar> customerCars,
                                                       List<ReplacementCar> replacementCars, List<Service> services) {
        List<SpecificService> specificServices = new ArrayList<>();
        specificServices.add(specificServiceDAO.save(new SpecificService(
                Date.valueOf("2018-4-20"),
                Date.valueOf("2018-4-20"),
                Date.valueOf("2018-4-20"),
                SpecificServiceStatus.SpecificServiceStatusEnum.DURING.getSpecificServiceStatus(),
                "przegląd samochodu seat leon 2 b+g",
                employees.get(0), promotions.get(0), customerCars.get(0), replacementCars.get(0), services.get(1)
        )));
        specificServices.add(specificServiceDAO.save(new SpecificService(
                Date.valueOf("2018-5-20"),
                Date.valueOf("2018-5-20"),
                Date.valueOf("2018-5-20"),
                SpecificServiceStatus.SpecificServiceStatusEnum.DURING.getSpecificServiceStatus(),
                "przegląd samochodu renault megan diesel",
                employees.get(1), promotions.get(1), customerCars.get(1), replacementCars.get(1), services.get(2)
        )));
        specificServices.add(specificServiceDAO.save(new SpecificService(
                Date.valueOf("2018-5-20"),
                Date.valueOf("2018-5-20"),
                Date.valueOf("2018-5-20"),
                SpecificServiceStatus.SpecificServiceStatusEnum.DURING.getSpecificServiceStatus(),
                "przegląd samochodu seat leon 2 b+g",
                employees.get(1), promotions.get(1), customerCars.get(1), replacementCars.get(1), services.get(2)
        )));
        return specificServices;
    }

    private List<ServicePart> loadServiceParts(List<SpecificService> specificServices, List<Part> parts) {
        List<ServicePart> serviceParts = new ArrayList<>();
        serviceParts.add(servicePartDAO.save(new ServicePart(1, specificServices.get(2), parts.get(3))));
        return serviceParts;
    }

    private List<Invoice> loadInvoices(List<SpecificService> specificServices) {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoiceDAO.save(new Invoice(96, PaymentMethod.PaymentMethodEnum.CASH.getPaymentMethod(), specificServices.get(0))));
        invoices.add(invoiceDAO.save(new Invoice(80, PaymentMethod.PaymentMethodEnum.CASH.getPaymentMethod(), specificServices.get(1))));
        invoices.add(invoiceDAO.save(new Invoice((float) 254.99, PaymentMethod.PaymentMethodEnum.CARD.getPaymentMethod(), specificServices.get(2))));
        return invoices;
    }
}
