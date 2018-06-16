package ASOserver.springapp.mapper;

import ASOserver.model.Part;
import ASOserver.springapp.dto.PartDTO;

public class PartMapper {
    public static PartDTO toPartDTO(Part part) {
        PartDTO partDTO = new PartDTO();
        partDTO.setPratId(part.getPratId());
        partDTO.setName(part.getName());
        partDTO.setPrice(part.getPrice());
        partDTO.setQuantity(part.getQuantity());
        return partDTO;
    }
}
