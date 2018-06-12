package ASOserver.springapp.dto;

import java.io.Serializable;

public class ServicePartDTO implements Serializable {

    private Long servicePart;
    private SpecificServiceDTO specificService;
    private PartDTO part;

    public Long getServicePart() {
        return servicePart;
    }

    public void setServicePart(Long servicePart) {
        this.servicePart = servicePart;
    }

    public SpecificServiceDTO getSpecificService() {
        return specificService;
    }

    public void setSpecificService(SpecificServiceDTO specificService) {
        this.specificService = specificService;
    }

    public PartDTO getPart() {
        return part;
    }

    public void setPart(PartDTO part) {
        this.part = part;
    }
}
