package ASOserver.springapp.dto;

public class PartDTO{

    private Long PartId;
    private String name;
    private double price;

    @Override
    public String toString() {
        return "PartDTO{" +
                "PratId=" + PartId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getPartId() {
        return PartId;
    }

    public void setPartId(Long partId) {
        PartId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
