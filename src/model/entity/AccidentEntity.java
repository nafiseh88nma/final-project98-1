package model.entity;

public class AccidentEntity {

    private String officer_name ;
    private String officer_code ;
    private String Plaque ;
    private String Certificate ;
    private String card ;
    private String date ;//1398/11/13
    private String location ;
    private String insurance;

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }


    public String getOfficer_name() {
        return officer_name;
    }

    public void setOfficer_name(String officer_name) {
        this.officer_name = officer_name;
    }

    public String getOfficer_code() {
        return officer_code;
    }

    public void setOfficer_code(String officer_code) {
        this.officer_code = officer_code;
    }

    public String getPlaque() {
        return Plaque;
    }

    public void setPlaque(String plaque) {
        Plaque = plaque;
    }

    public String getCertificate() {
        return Certificate;
    }

    public void setCertificate(String certificate) {
        Certificate = certificate;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
