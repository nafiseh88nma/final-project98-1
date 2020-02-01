package model.service;


import model.entity.OfficerEntity;
import model.repository.OfficerRepo;
import java.util.ArrayList;


public class OfficerServ {
    private OfficerServ () {}

    private static OfficerServ  ourInstance = new OfficerServ ();

    public static OfficerServ  getInstance() {
        return ourInstance;
    }


    public ArrayList<OfficerEntity> report()throws Exception{
        ArrayList<OfficerEntity> list = new ArrayList<>();
        try(OfficerRepo officerRepo = new OfficerRepo()){
            list=officerRepo.Officer_select();
            officerRepo.commite();
        }
        return list;
    }
}
