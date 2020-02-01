package controller;

import model.entity.AccidentEntity;
import model.entity.CarEntity;
import model.entity.OfficerEntity;
import model.entity.RegisertingViolationsEntity;
import model.service.CarServ;
import model.service.OfficerServ;
import model.service.Registering_violationServ;

import java.util.ArrayList;

public class Control_Register_V_A {

    public boolean Violation(RegisertingViolationsEntity r) throws Exception {
        ArrayList<CarEntity> list = CarServ.getInstance().report();
        boolean chek = false;
        for (CarEntity c : list) {
            if (c.getPlaque().equals(r.getPlaque()) && c.getCertificate().equals(r.getCertificate()) && c.getCard().equals(r.getCard()))
            {
                chek = true;
                break;
            } else {
                chek = false;
                System.out.println("برای ثبت تخلف : پیدا نشد");
            }
        }
        return chek;
    }

    ///////////////////////////////////////////////////////////////
    public boolean Violation_empty(RegisertingViolationsEntity r) throws Exception {
        boolean chek = false;
        String D = "";
        if (r.getPlaque().equals(D) | r.getName_Infraction().equals(D) | r.getCard().equals(D) | r.getCertificate().equals(D) | r.getDate().equals(D) | r.getLocation().equals(D) ) {
            chek = true;
        }
        else {
            chek = false;
        }

        return chek;
    }
    /////////////////////////////////////////////////
    public boolean Accident(AccidentEntity a) throws Exception {
        ArrayList<CarEntity> list = CarServ.getInstance().report();
        boolean chek = false;
        for (CarEntity c : list) {
            if (c.getPlaque().equals(a.getPlaque()) && c.getCertificate().equals(a.getCertificate()) && c.getCard().equals(a.getCard()) && c.getInsurance().equals(a.getInsurance()))
            {
                chek = true;
                break;
            } else {
                chek = false;
                System.out.println("برای ثبت تصادف : پیدا نشد");
            }
        }
        return chek;
    }

    ///////////////////////////////////////////////////////////////
    public boolean Accident_empty(AccidentEntity a) throws Exception {
        boolean chek = false;
        String D = "";
        if (a.getCard().equals(D) | a.getCertificate().equals(D) | a.getPlaque().equals(D) | a.getInsurance().equals(D)) {
            chek = true;
        }
        else {
            chek = false;
        }

        return chek;
    }

}
