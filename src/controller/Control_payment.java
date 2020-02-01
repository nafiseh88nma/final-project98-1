package controller;


import model.entity.Electronic_PaymentEntity;
import model.service.Electronic_paymentServ;

import java.util.ArrayList;

public class Control_payment {
    public boolean chek_corectness(Electronic_PaymentEntity E)throws Exception{
        ArrayList<Electronic_PaymentEntity> list = Electronic_paymentServ.getInstance().report_all();
        boolean chek=false;
        for(Electronic_PaymentEntity p : list){
            if(p.getNumber().equals(E.getNumber()) && p.getCvv2().equals(E.getCvv2()) && p.getPassword2().equals(E.getPassword2())){
                chek=true;
                break;
            }
        }
        return chek;
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public boolean chek_mojoudi(Electronic_PaymentEntity E)throws Exception{
        ArrayList<Electronic_PaymentEntity> list = Electronic_paymentServ.getInstance().report_all();
        boolean chek=false;
        Electronic_PaymentEntity R =null;
        for( Electronic_PaymentEntity p : list ){
            if(p.getNumber().equals(E.getNumber()) && p.getCvv2().equals(E.getCvv2()) && p.getPassword2().equals(E.getPassword2())){
                R=p;
                break;
            }
        }//کارت رو پیدا میکنه
        if(R.getMojoudi()<E.getMojoudi()){//اگر کوجودی کارت کمتر از بدهی بود
            chek=true;
        }
        return chek;
    }
    /////////////////////////////////////////////////////////////////////////////
    public boolean chek_empty(Electronic_PaymentEntity p){
        String D="";
        boolean chek=false;
            if(p.getNumber().equals(D) | p.getCvv2().equals(D) | p.getPassword2().equals(D) ){
                chek=true;
            }

        return chek;
    }
    ///////////////////////////////////////////////////////////////////////
    public Electronic_PaymentEntity findcard(Electronic_PaymentEntity E)throws Exception {
        ArrayList<Electronic_PaymentEntity> list = Electronic_paymentServ.getInstance().report_all();
        Electronic_PaymentEntity R=null;
        for (Electronic_PaymentEntity p : list) {
            if (p.getNumber().equals(E.getNumber()) && p.getCvv2().equals(E.getCvv2()) && p.getPassword2().equals(E.getPassword2())) {
                R=p;
                break;
            }
        }
        return R;
    }
}
