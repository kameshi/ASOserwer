package ASOserver.springapp.dto;

public class PartDTO{

    private Long PratId;
    private String name;
    private double price;

    @Override
    public String toString() {
        return "PartDTO{" +
                "PratId=" + PratId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getPratId() {
        return PratId;
    }

    public void setPratId(Long pratId) {
        PratId = pratId;
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
