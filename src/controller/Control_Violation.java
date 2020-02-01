package controller;


import model.entity.RegisertingViolationsEntity;
import model.service.Registering_violationServ;
//وظیفه این کلاس این هست که جزیمه و مقدار نمره منفی هر تخلف را لحاظ کرده و اطلاعات کامل را به کلاس سرویس مربوطه انتقال دهد
public class Control_Violation {

    //public Control_Violation() {}
    public  void control(RegisertingViolationsEntity R ) throws Exception {
        String v1="Unauthorized speed";
        String v2="Forbidden Park";
        String v3="running a red light.";
        String v4="Forbidden bypass";
        String v5="prohibited entry";

        if(R.getName_Infraction().equals("1")){
            R.setName_Infraction(v1);
            R.setPrice1("100000");
            R.setNscore("10");
            Registering_violationServ.getInstance().Save(R);
        }
        else if(R.getName_Infraction().equals("2")){
            R.setName_Infraction(v2);
            R.setPrice1("20000");
            R.setNscore("0");
            Registering_violationServ.getInstance().Save(R);
        }
        else if(R.getName_Infraction().equals("3")){
            R.setName_Infraction(v3);
            R.setPrice1("30000");
            R.setNscore("5");
            Registering_violationServ.getInstance().Save(R);
        }
        else if(R.getName_Infraction().equals("4")){
            R.setName_Infraction(v4);
            R.setPrice1("50000");
            R.setNscore("3");
            Registering_violationServ.getInstance().Save(R);
        }
        else if(R.getName_Infraction().equals("5")){
            R.setName_Infraction(v5);
            R.setPrice1("40000");
            R.setNscore("5");
            Registering_violationServ.getInstance().Save(R);
        }
    }
}
