package model.service;

import model.entity.AvarezgirEntity;
import model.repository.AvarezgirRepo;

import java.util.ArrayList;

public class AvarezgirServ {
    private AvarezgirServ() {}

    private static AvarezgirServ ourInstance = new AvarezgirServ();

    public static AvarezgirServ getInstance() {
        return ourInstance;
    }

   public ArrayList<AvarezgirEntity> report()throws Exception{
        ArrayList<AvarezgirEntity> list = new ArrayList<>();
        try(AvarezgirRepo AvarezgirRepo = new AvarezgirRepo()){
            list=AvarezgirRepo.Avarezgir_select();
            AvarezgirRepo.commite();
        }
        return list;
    }
}
