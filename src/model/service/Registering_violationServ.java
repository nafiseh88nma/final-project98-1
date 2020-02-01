package model.service;


import model.entity.RegisertingViolationsEntity;
import model.repository.Registering_ViolationsRepo;

import java.util.ArrayList;

public class Registering_violationServ {

    public Registering_violationServ() {}

    private static Registering_violationServ ourInstance = new Registering_violationServ();

    public static Registering_violationServ getInstance() {
        return ourInstance;
    }

    public void Save(RegisertingViolationsEntity regisertingViolationsEntity)throws Exception{
        try(Registering_ViolationsRepo registering_violationsRepo = new Registering_ViolationsRepo()){
            registering_violationsRepo.registering_violations_insert(regisertingViolationsEntity);
            registering_violationsRepo.commite();

        }
    }

    public ArrayList<RegisertingViolationsEntity> report()throws Exception{
        ArrayList<RegisertingViolationsEntity> list  = new ArrayList<>();
        try(Registering_ViolationsRepo registering_violationsRepo = new Registering_ViolationsRepo()){
            list=registering_violationsRepo.registering_violations_select();
            registering_violationsRepo.commite();
        }
        return  list;
    }

    public void remove(String card )throws Exception{
        try(Registering_ViolationsRepo registering_violationsRepo = new Registering_ViolationsRepo()){
            registering_violationsRepo.registering_violations_delete(card);
            registering_violationsRepo.commite();
        }
    }
}
