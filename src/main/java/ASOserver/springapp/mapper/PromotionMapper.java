package ASOserver.springapp.mapper;

import ASOserver.model.Promotion;
import ASOserver.springapp.dto.PromotionDTO;

/**
 * Created by user on 2018-06-14.
 */
public class PromotionMapper {
    public static Promotion toPromotion(PromotionDTO promotionDTO){
        Promotion promotion = new Promotion();
        promotion.setPromotionId(promotionDTO.getPromotionId());
        promotion.setName(promotionDTO.getName());
        promotion.setDescription(promotionDTO.getDescription());
        promotion.setDateFrom(promotionDTO.getDateFrom());
        promotion.setDateTo(promotionDTO.getDateTo());
        promotion.setPercent(promotionDTO.getPercent());
        promotion.setService(ServiceMapper.toService(promotionDTO.getServiceDTO()));
        return promotion;
    }
    public static PromotionDTO toPromotionDTO(Promotion promotion){
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setPromotionId(promotion.getPromotionId());
        promotionDTO.setName(promotion.getName());
        promotionDTO.setDescription(promotion.getDescription());
        promotionDTO.setDateFrom(promotion.getDateFrom());
        promotionDTO.setDateTo(promotion.getDateTo());
        promotionDTO.setPercent(promotion.getPercent());
        promotionDTO.setServiceDTO(ServiceMapper.toServiceDTO(promotion.getService()));
        return promotionDTO;
    }
}
