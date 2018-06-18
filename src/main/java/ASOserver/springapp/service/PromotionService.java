package ASOserver.springapp.service;

import ASOserver.model.Promotion;
import ASOserver.springapp.dao.PromotionDAO;
import ASOserver.springapp.dto.PromotionDTO;
import ASOserver.springapp.mapper.PromotionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        promotionDTO.setPromotionId(promotionId);
        promotionDAO.save(PromotionMapper.toPromotion(promotionDTO));
    }

    public void deletePromotion(Long promotionId) throws Exception {
        promotionDAO.deleteById(promotionId);
    }
}
