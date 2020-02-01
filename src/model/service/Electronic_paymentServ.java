package model.service;

import model.entity.Electronic_PaymentEntity;
import model.repository.Electronic_PaymentRepo;

import java.util.ArrayList;

public class Electronic_paymentServ {
    private Electronic_paymentServ() {}

    private static Electronic_paymentServ ourInstance = new Electronic_paymentServ();

    public static Electronic_paymentServ getInstance() {
        return ourInstance;
    }

    public ArrayList<Electronic_PaymentEntity> report_all()throws Exception{
        ArrayList<Electronic_PaymentEntity> list = new ArrayList<>();
        try(Electronic_PaymentRepo e = new Electronic_PaymentRepo()){
           list=e.select_all();
           e.commite();
           e.close();
        }
        return list;
    }

    public Long report_mojoudi(String number)throws Exception{
        Long mojoudi;
        try (Electronic_PaymentRepo electronic_paymentRepo = new Electronic_PaymentRepo()){
            mojoudi=electronic_paymentRepo.card_mojoudi_select(number);
            electronic_paymentRepo.commite();
        }
        return mojoudi;
    }

    public void update_mojoudi(String number , Long pardakhti , Long mojoudi)throws Exception{
        try(Electronic_PaymentRepo electronic_paymentRepo =new Electronic_PaymentRepo()){
            electronic_paymentRepo.electronic_payment_update_mojoudi(number,pardakhti,mojoudi);
            electronic_paymentRepo.commite();
        }

    }
}
