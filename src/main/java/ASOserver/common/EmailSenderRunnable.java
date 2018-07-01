package ASOserver.common;

import ASOserver.model.Car;
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
    public CarDAO carDAO;
    @Autowired
    public NotificationDAO notificationDAO;

    public void run(){
        System.out.println("Jestem");
        Iterable<Car> carsIterable = carDAO.findAll();
        Date localDate = Date.valueOf(LocalDate.now());
        Notification notification = notificationDAO.findByType(NotificationType.NotificationTypeEnum.END.getNotificationType());
        for (Car car : carsIterable) {
            System.out.println("Jestem1");
            System.out.println(localDate + " " + car.getReviewDate());
            if(localDate.equals(car.getReviewDate())){
                System.out.println("Jestem2");
                for (CustomerCar customerCar : car.getCustomerCars()){
                    System.out.println("Jestem3");
                    Sendgrid mail = new Sendgrid("Kameshi9303","333221Marekm");
                    String text = String.format(notification.getDescription(), car.getRegistrationNumber(), car.getReviewDate());
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
}
