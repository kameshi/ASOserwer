package ASOserver.springapp.service;

import ASOserver.common.Sendgrid;
import ASOserver.model.Customer;
import ASOserver.model.Notification;
import ASOserver.model.Promotion;
import ASOserver.model.enums.NotificationType;
import ASOserver.springapp.dao.CustomerDAO;
import ASOserver.springapp.dao.NotificationDAO;
import ASOserver.springapp.dao.PromotionDAO;
import ASOserver.springapp.dto.PromotionDTO;
import ASOserver.springapp.mapper.PromotionMapper;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionService {
    private final PromotionDAO promotionDAO;
    private final NotificationDAO notificationDAO;
    private final CustomerDAO customerDAO;

    @Autowired
    public PromotionService(PromotionDAO promotionDAO, NotificationDAO notificationDAO, CustomerDAO customerDAO) {
        this.promotionDAO = promotionDAO;
        this.customerDAO = customerDAO;
        this.notificationDAO = notificationDAO;
    }

    public void insertPromotion(PromotionDTO promotionDTO) {
        this.promotionDAO.save(PromotionMapper.toPromotion(promotionDTO));
        Notification notification = notificationDAO.findByType(NotificationType.NotificationTypeEnum.PROMOTION.getNotificationType());
        Sendgrid mail = new Sendgrid("Kameshi9304","333221Marekm");
        String text = String.format(notification.getDescription(), promotionDTO.getDescription(), String.valueOf(promotionDTO.getStartDate()), String.valueOf(promotionDTO.getEndDate()));
        Iterable<Customer> customersList = customerDAO.findAll();
        for(Customer customer : customersList){
            mail.setTo(customer.geteMail())
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

    public List<PromotionDTO> findPromotions() throws Exception {
        Iterable<Promotion> promotions = promotionDAO.findAll();
        List<PromotionDTO> promotionDTOS = new ArrayList<>();

        for (Promotion tmpPromotion : promotions) {
            promotionDTOS.add(PromotionMapper.toPromotionDTO(tmpPromotion));
        }

        return promotionDTOS;
    }

    public PromotionDTO findPromotionById(Long promotionId) throws Exception {
        return PromotionMapper.toPromotionDTO(promotionDAO.findById(promotionId).get());
    }

    public void updatePromotion(Long promotionId, PromotionDTO promotionDTO) throws Exception {
        promotionDTO.setId(promotionId);
        promotionDAO.save(PromotionMapper.toPromotion(promotionDTO));
    }

    public void deletePromotion(Long promotionId) throws Exception {
        promotionDAO.deleteById(promotionId);
    }
}
