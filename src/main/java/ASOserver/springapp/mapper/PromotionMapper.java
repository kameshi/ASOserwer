package ASOserver.springapp.mapper;

import ASOserver.model.Promotion;
import ASOserver.springapp.dto.PromotionDTO;

public class PromotionMapper {

    public static Promotion toPromotion(PromotionDTO promotionDTO){
        Promotion promotion = new Promotion();
        promotion.setPromotionId(promotionDTO.getId());
        promotion.setName(promotionDTO.getName());
        promotion.setDescription(promotionDTO.getDescription());
        promotion.setDateFrom(promotionDTO.getStartDate());
        promotion.setDateTo(promotionDTO.getEndDate());
        promotion.setPercent(promotionDTO.getPercent());
        //promotion.setService(ServiceMapper.toService(promotionDTO.getService()));
        return promotion;
    }

    public static PromotionDTO toPromotionDTO(Promotion promotion){
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setId(promotion.getPromotionId());
        promotionDTO.setName(promotion.getName());
        promotionDTO.setDescription(promotion.getDescription());
        promotionDTO.setStartDate(promotion.getDateFrom());
        promotionDTO.setEndDate(promotion.getDateTo());
        promotionDTO.setPercent(promotion.getPercent());
        //promotionDTO.setService(ServiceMapper.toServiceDTO(promotion.getService()));
        return promotionDTO;
    }
}
