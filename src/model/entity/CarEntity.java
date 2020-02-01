package model.entity;

public class CarEntity {

    private String name;
    private String Plaque;
    private String Certificate;
    private String card;
    private String insurance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaque() {
        return Plaque;
    }

    public void setPlaque(String plaque) {
        this.Plaque = plaque;
    }

    public String getCertificate() {
        return Certificate;
    }

    public void setCertificate(String certificate) {

        this.Certificate = certificate;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
}
