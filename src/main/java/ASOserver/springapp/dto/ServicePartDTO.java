package ASOserver.springapp.dto;

import ASOserver.model.Part;
import ASOserver.model.SpecificService;

import java.io.Serializable;

/**
 * Created by user on 2018-06-17.
 */
public class ServicePartDTO implements Serializable{
    private Long servicePart;
    private int quantity;
    private SpecificServiceDTO specificServiceDTO;
    private PartDTO partDTO;

    public Long getServicePart() {
        return servicePart;
    }

    public void setServicePart(Long servicePart) {
        this.servicePart = servicePart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SpecificServiceDTO getSpecificServiceDTO() {
        return specificServiceDTO;
    }

    public void setSpecificServiceDTO(SpecificServiceDTO specificServiceDTO) {
        this.specificServiceDTO = specificServiceDTO;
    }

    public PartDTO getPartDTO() {
        return partDTO;
    }

    public void setPartDTO(PartDTO partDTO) {
        this.partDTO = partDTO;
    }
}
