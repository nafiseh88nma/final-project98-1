package model.entity;

public class RoadServiceEntity {

    private String id ;
    private  String model;
    private  String price;
    private  String Plaque;

    public String getPlaque() {
        return Plaque;
    }

    public void setPlaque(String plaque) {
        Plaque = plaque;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
