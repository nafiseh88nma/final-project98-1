package model.entity;

public class RegisertingViolationsEntity {//اطلاعاتی که برای ثبت تخلف در دیتا بیس لازم است
    private String officer_name ;//اسم افسر
    private String officer_code ;//کد افسر ثبت کننده
    private String name_Infraction ;//نام تخلف
    private String Plaque ;//شماره پلاک ماشین راننده
    private String Certificate ;//شماره گواهی نامه راننده
    private String card ;//شماره کارت ماشین راننده
    private String date ;//تاریخ ثبت تخلف
    private String location ;//مکان تخلف
    private String nscore ;//نمره منفی
    private String price1 ;//جریمه مربوطه


    public String getPrice1() {
        return price1;
    }
    public void setPrice1(String price1) {
        this.price1 = price1;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getNscore() {
        return nscore;
    }
    public void setNscore(String nscore) {
        this.nscore = nscore;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getOfficer_name(){
        return officer_name;
    }
    public void setOfficer_name(String officer_name) {
        this.officer_name = officer_name;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getOfficer_code() {
        return officer_code;
    }
    public void setOfficer_code(String officer_code) {
        this.officer_code = officer_code;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getName_Infraction() {
        return name_Infraction;
    }
    public void setName_Infraction(String name_Infraction) {
        this.name_Infraction = name_Infraction;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getPlaque() {
        return Plaque;
    }
    public void setPlaque(String plaque) {
        this.Plaque = plaque;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getCertificate() {
        return Certificate;
    }
    public void setCertificate(String certificate) {
        this.Certificate = certificate;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setCard(String card) {
        this.card = card;
    }
    public String getCard() {return card;}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
