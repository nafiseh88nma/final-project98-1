package controller;


import model.entity.CarEntity;
import model.service.CarServ;

import java.util.ArrayList;

public class Control_Item {


    public boolean chek_Plaque(String Plaque)throws  Exception{
        ArrayList<CarEntity> list = CarServ.getInstance().report();
        boolean chek=false;
        for(CarEntity c : list){
            if(c.getPlaque().equals(Plaque)){
                chek=true;
                break;
            }
        }
        return chek;
    }

    public boolean chek_Certificate(String certificate)throws Exception{
        ArrayList<CarEntity> list = CarServ.getInstance().report();
        boolean chek=false;
        for(CarEntity c : list){
            if(c.getCertificate().equals(certificate)){
                chek=true;
                break;
            }
        }
        return chek;
    }

    public boolean chek_card(String card)throws Exception{
        ArrayList<CarEntity> list = CarServ.getInstance().report();
        boolean chek=false;
        for(CarEntity c : list){
            if(c.getCard().equals(card)){
                chek=true;
                break;
            }
        }
        return chek;
    }

}
