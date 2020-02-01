package model.service;


import model.entity.CityServiceEntity;
import model.repository.CityServiceRepo;

public class CityServiceServ {
    private static CityServiceServ ourInstance = new CityServiceServ();

    public static CityServiceServ getInstance() {
        return ourInstance;
    }

    private CityServiceServ() {
    }
    public void save(CityServiceEntity entity)throws Exception{
        try(CityServiceRepo cityServiceRepo =new CityServiceRepo()){
            cityServiceRepo.insert_cityservice(entity);
            cityServiceRepo.commite();
        }
    }
}
