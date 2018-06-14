package ASOserver.springapp.service;

/**
 * Created by user on 2018-06-14.
 */
import ASOserver.model.Employee;
import ASOserver.springapp.dao.EmployeeDAO;
import ASOserver.springapp.dao.PromotionDAO;
import ASOserver.springapp.dao.ServiceDAO;
import ASOserver.springapp.dto.EmployeeDTO;
import ASOserver.springapp.dto.PromotionDTO;
import ASOserver.springapp.mapper.EmployeeMapper;
import ASOserver.springapp.mapper.PromotionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    private final PromotionDAO promotionDAO;

    @Autowired
    public PromotionService(PromotionDAO promotionDAO) {
        this.promotionDAO = promotionDAO;
    }

    public void insertPromotion(PromotionDTO promotionDTO) {
        this.promotionDAO.save(PromotionMapper.toPromotion(promotionDTO));
    }
}
