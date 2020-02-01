package controller;

import model.entity.AvarezgirEntity;
import model.entity.CarEntity;
import model.entity.OfficerEntity;
import model.service.AvarezgirServ;
import model.service.CarServ;
import model.service.OfficerServ;

import java.util.ArrayList;

public class Control_Interation {

    public boolean Driver(CarEntity carEntity) throws Exception {
        ArrayList<CarEntity> list = CarServ.getInstance().report();
        boolean chek = false;
        for (CarEntity c : list) {
            System.out.println(c.getName()+"---"+carEntity.getName());
            System.out.println(c.getCertificate()+"---"+carEntity.getCertificate());
            System.out.println(c.getCard()+"---"+carEntity.getCard());
            System.out.println(c.getInsurance()+"---"+carEntity.getInsurance());
            System.out.println(c.getPlaque()+"---"+carEntity.getPlaque());
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            if (    c.getName().equals(carEntity.getName()) &&
                    c.getCard().equals(carEntity.getCard()) &&
                    c.getCertificate().equals(carEntity.getCertificate()) &&
                    c.getInsurance().equals(carEntity.getInsurance()) &&
                    c.getPlaque().equals(carEntity.getPlaque())){
                    chek = true;
                    System.out.println("****************");
                    break;
            } else {
                chek = false;
            }
        }
        return chek;
    }

    ///////////////////////////////////////////////////////////////
    public boolean Driver_empty(CarEntity carEntity) throws Exception {
        boolean chek = false;
        String D = "";
        if (carEntity.getName().equals(D) | carEntity.getCard().equals(D) |
                carEntity.getCertificate().equals(D) | carEntity.getInsurance().equals(D) |
                carEntity.getPlaque().equals(D) ) {

            chek = true;
        }
        else {
            chek = false;
        }

        return chek;
    }
    /////////////////////////////////////////////////////////////////////////////
    public boolean Officer(OfficerEntity officerEntity) throws Exception {
        ArrayList<OfficerEntity> list = OfficerServ.getInstance().report();
        boolean chek = false;
        for (OfficerEntity c : list) {
            //System.out.println(c.getName()+officerEntity.getName());
            //System.out.println(c.getPassword()+officerEntity.getPassword());
            //System.out.println(c.getCode()+officerEntity.getCode());
            if (c.getName().equals(officerEntity.getName()) &&
                    c.getPassword().equals(officerEntity.getPassword()) &&
                    c.getCode().equals(officerEntity.getCode())) {
                chek = true;
                break;
            } else {
                chek = false;
                //System.out.println("dontfound it ;)");
            }
        }
        return chek;
    }

    ///////////////////////////////////////////////////////////////
    public boolean Officer_empty(OfficerEntity officerEntity) throws Exception {
        boolean chek = false;
        String D = "";
        if (officerEntity.getName().equals(D) | officerEntity.getPassword().equals(D) |
                officerEntity.getCode().equals(D)) {
            chek = true;
        }
        else {
            chek = false;
        }

        return chek;
    }
    ///////////////////////////////////////////////////////////////////////
    public boolean Avarezgir(AvarezgirEntity avarezgirEntity) throws Exception {
        ArrayList<AvarezgirEntity> list = AvarezgirServ.getInstance().report();
        boolean chek = false;
        for (AvarezgirEntity c : list) {
            System.out.println(c.getName());
            System.out.println(c.getPassword());
            if (c.getName().equals(avarezgirEntity.getName())  && c.getPassword().equals(avarezgirEntity.getPassword())) {
                chek = true;
                break;
            } else {
                chek = false;
            }
        }
        return chek;
    }

    ///////////////////////////////////////////////////////////////
    public boolean Avarezgir_empty(AvarezgirEntity avarezgirEntity) throws Exception {
        boolean chek = false;
        String D = "";
        if (avarezgirEntity.getName().equals(D) | avarezgirEntity.getPassword().equals(D)) {
            chek = true;
        }
        else {
            chek = false;
        }

        return chek;
    }
}
