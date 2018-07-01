package ASOserver.common;

import ASOserver.model.CustomerCar;
import ASOserver.model.Notification;
import ASOserver.model.enums.NotificationType;
import ASOserver.springapp.dao.CarDAO;
import ASOserver.springapp.dao.CustomerCarDAO;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dao.NotificationDAO;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class EmailSenderRunnable implements Runnable {

    @Autowired
    public CustomerCarDAO customerCarDAO;
    @Autowired
    public NotificationDAO notificationDAO;
    @Autowired
    public CustomerDAO customerDAO;
    @Autowired
    public CarDAO carDAO;

    public void run(){
        Iterable<CustomerCar> customerCarIterable = customerCarDAO.findAll();
        Date localDate = Date.valueOf(LocalDate.now());
        Notification notification = notificationDAO.findByType(NotificationType.NotificationTypeEnum.END.getNotificationType());
        for(CustomerCar customerCar : customerCarIterable){
            System.out.println(customerCar.toString());
            if(localDate.equals(customerCar.getCar().getReviewDate())){
                Sendgrid mail = new Sendgrid("","");
                String text = String.format(notification.getDescription(), customerCar.getCar().getRegistrationNumber(), customerCar.getCar().getReviewDate());
                System.out.println(customerCar.getCustomer().geteMail());
                mail.setTo(customerCar.getCustomer().geteMail())
                        .setFrom("aso@aso.com")
                        .setSubject("Powaidomienie ASO")
                        .setText(text);
                try {
                    mail.send();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
