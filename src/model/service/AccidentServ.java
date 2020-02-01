package model.service;

import model.entity.AccidentEntity;
import model.repository.AccidentRepo;

import java.util.ArrayList;

public class AccidentServ {
    private AccidentServ() {}

    private static AccidentServ ourInstance = new AccidentServ();

    public static AccidentServ getInstance() {
        return ourInstance;
    }

    public void Save(AccidentEntity accidentEntity)throws Exception{
        try(AccidentRepo accidentRepo = new AccidentRepo()){
            accidentRepo.accident_insert(accidentEntity);
            accidentRepo.commite();
        }
    }
    public ArrayList<AccidentEntity>  Report()throws Exception{
        ArrayList<AccidentEntity> list = new ArrayList<>();
        try(AccidentRepo accidentRepo = new AccidentRepo()){
            list=accidentRepo.accident_select();
            accidentRepo.commite();
        }
        return list ;
    }

}
