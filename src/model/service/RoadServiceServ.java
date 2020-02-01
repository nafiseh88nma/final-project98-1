package model.service;


import model.entity.RoadServiceEntity;
import model.repository.RoadServiceRepo;

import java.util.ArrayList;

public class RoadServiceServ {
    private RoadServiceServ() {}

    private static RoadServiceServ ourInstance = new RoadServiceServ();

    public static RoadServiceServ getInstance() {
        return ourInstance;
    }

    public void insert(RoadServiceEntity entity)throws Exception{
        try(RoadServiceRepo roadServiceRepo =new RoadServiceRepo()){
            roadServiceRepo.insert_roadservice(entity);
            roadServiceRepo.commite();
        }
    }
}
