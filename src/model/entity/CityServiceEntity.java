package model.entity;

public class CityServiceEntity{

    private String Plaque;
    private String type;
    private String date;


    public String getPlaque() {
        return Plaque;
    }

    public void setPlaque(String plaque) {
        Plaque = plaque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
