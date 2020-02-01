package model.entity;

public class Enteration_officerEntity {
    private String name;
    private String code;
    private String time;
    private String servcode;
    private String servname;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getServcode() {
        return servcode;
    }

    public void setServcode(String servcode) {
        this.servcode = servcode;
    }

    public String getServname() {
        return servname;
    }

    public void setServname(String servname) {
        this.servname = servname;
    }
}
