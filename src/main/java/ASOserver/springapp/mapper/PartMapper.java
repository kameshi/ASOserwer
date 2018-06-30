package ASOserver.springapp.mapper;

import ASOserver.model.Part;
import ASOserver.springapp.dto.PartDTO;

public class PartMapper {

    public static PartDTO toPartDTO(Part part) {
        PartDTO partDTO = new PartDTO();
        partDTO.setId(part.getPartId());
        partDTO.setName(part.getName());
        partDTO.setQuantity(part.getQuantity());
        partDTO.setPrice(part.getPrice());
        return partDTO;
    }

    public static Part toPart(PartDTO partDTO){
        Part part = new Part();
        part.setPartId(partDTO.getId());
        part.setName(partDTO.getName());
        part.setQuantity(partDTO.getQuantity());
        part.setPrice(partDTO.getPrice());
        return part;
    }
}
