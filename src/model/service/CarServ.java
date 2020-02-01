package model.service;

import model.entity.CarEntity;
import model.repository.CarRepo;

import java.util.ArrayList;

public class CarServ {

    private CarServ() {}

    private static CarServ ourInstance = new CarServ();

    public static CarServ getInstance() {
        return ourInstance;
    }


    public ArrayList<CarEntity> report()throws Exception{
        ArrayList<CarEntity> list = new ArrayList<>();
        try(CarRepo carRepo = new CarRepo()){
            list=carRepo.car_select();
            carRepo.commite();
        }
        return list;
    }
}
