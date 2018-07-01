package ASOserver.springapp.service;

import ASOserver.common.Sendgrid;
import ASOserver.model.*;
import ASOserver.model.enums.NotificationType;
import ASOserver.model.enums.SpecificServiceStatus;
import ASOserver.springapp.dao.AccountDAO;
import ASOserver.springapp.dao.CarDAO;
import ASOserver.springapp.dao.NotificationDAO;
import ASOserver.springapp.dao.SpecificServiceDAO;
import ASOserver.springapp.dto.SpecificServiceDTO;
import ASOserver.springapp.mapper.SpecificServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecificServiceService {
    private final SpecificServiceDAO specificServiceDAO;
    private final AccountDAO accountDAO;
    private final CarDAO carDAO;
    private final InvoiceService invoiceService;
    private final NotificationDAO notificationDAO;

    @Autowired
    public SpecificServiceService(SpecificServiceDAO specificServiceDAO, AccountDAO accountDAO, CarDAO carDAO,
                                  InvoiceService invoiceService, NotificationDAO notificationDAO) {
        this.specificServiceDAO = specificServiceDAO;
        this.accountDAO = accountDAO;
        this.carDAO = carDAO;
        this.invoiceService = invoiceService;
        this.notificationDAO = notificationDAO;
    }

    public List<SpecificServiceDTO> findSpecificServices() throws Exception {
        Iterable<SpecificService> specificServiceIterable = this.specificServiceDAO.findAll();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();
        for(SpecificService tmpSpecificService : specificServiceIterable){
            specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
        }

        return specificServiceDTOList;
    }

    public SpecificServiceDTO findSpecificServiceById(Long specificServiceId) throws Exception {
        return SpecificServiceMapper.toSpecificServiceDTO(specificServiceDAO.findById(specificServiceId).get());
    }

    public void insertSpecificService(SpecificServiceDTO specificServiceDTO) throws Exception {
        SpecificService specificService = specificServiceDAO.save(SpecificServiceMapper.toSpecificService(specificServiceDTO));
        invoiceService.insertInvoice(specificService, specificServiceDTO);
    }

    public void updateSpecificService(Long specificServiceId, SpecificServiceDTO specificServiceDTO) throws Exception {
        specificServiceDTO.setId(specificServiceId);;
        SpecificService specificService = specificServiceDAO.findById(specificServiceId).get();
        if(specificService.getStatus().equals(SpecificServiceStatus.SpecificServiceStatusEnum.DURING)){
            if(specificServiceDTO.getStatus().equals(SpecificServiceStatus.SpecificServiceStatusEnum.DURING)){
                Notification notification = notificationDAO.findByType(NotificationType.NotificationTypeEnum.END.getNotificationType());
                Sendgrid mail = new Sendgrid("Kameshi9303","333221Marekm");
                String text = String.format(notification.getDescription(), specificServiceDTO.getCar().getRegistrationNumber());
                mail.setTo(specificServiceDTO.getClient().getEmail())
                        .setFrom("aso@aso.com")
                        .setSubject("Powaidomienie ASO")
                        .setText(text);
                mail.send();
            }
        }
        specificServiceDAO.save(SpecificServiceMapper.toSpecificService(specificServiceDTO));
    }

    public void deleteSpecificService(Long specificServiceId) throws Exception {
        specificServiceDAO.deleteById(specificServiceId);
    }

    public List<SpecificServiceDTO> findSpecificServicesByEmployeeId(Long accountId) throws Exception {
        Account account = accountDAO.findById(accountId).get();

        if(account.getEmployee() == null) {
            return null;
        }

        Employee employee = account.getEmployee();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();

        if(employee.getSpecificService().size() == 0){
            return null;
        }

        for(SpecificService tmpSpecificService : employee.getSpecificService()){
            specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
        }

        return specificServiceDTOList;
    }

    public List<SpecificServiceDTO> findSpecificServicesByCustomerId(Long accountId) throws Exception {
        Account account = accountDAO.findById(accountId).get();

        if(account.getCustomer() == null) {
            return null;
        }

        Customer customer = account.getCustomer();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();

        if(customer.getCustomerCars().size() == 0) {
            return null;
        }

        for(CustomerCar tmpCustomerCar : customer.getCustomerCars()) {
            for (SpecificService tmpSpecificService : tmpCustomerCar.getSpecificServices()) {
                specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
            }
        }

        return specificServiceDTOList;
    }

    public List<SpecificServiceDTO> findSpecificServicesByCarId(Long carId) throws Exception {
        Car car = carDAO.findById(carId).get();
        List<SpecificServiceDTO> specificServiceDTOList = new ArrayList<>();

        for(CustomerCar tmpCustomerCar : car.getCustomerCars()) {
            for (SpecificService tmpSpecificService : tmpCustomerCar.getSpecificServices()) {
                specificServiceDTOList.add(SpecificServiceMapper.toSpecificServiceDTO(tmpSpecificService));
            }
        }

        return specificServiceDTOList;
    }
}
