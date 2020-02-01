package model.entity;

public class CardEntity {
    private String number ;
    private String cvv2 ;
    private String password2 ;
    private Long mojoudi ;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Long getMojoudi() {
        return mojoudi;
    }

    public void setMojoudi(Long mojoudi) {
        this.mojoudi = mojoudi;
    }
}
