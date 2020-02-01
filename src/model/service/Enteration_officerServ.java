package model.service;

import model.entity.Enteration_officerEntity;
import model.repository.Enteration_officerRepo;

/**
 * Created by Asus on 1/6/2020.
 */
public class Enteration_officerServ {
    private static Enteration_officerServ ourInstance = new Enteration_officerServ();

    public static Enteration_officerServ getInstance() {
        return ourInstance;
    }

    private Enteration_officerServ() {
    }

    public  void save(Enteration_officerEntity eo)throws Exception{
        try(Enteration_officerRepo E = new Enteration_officerRepo()){
            E.insert_interationoffocer(eo);
            E.commite();
            E.close();
        }
    }
}
