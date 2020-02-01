package controller;


import model.entity.AvarezipageEntity;

public class Control_Avarezgirpage {

    public  boolean chek_empty(AvarezipageEntity a ){
        boolean chek=false;
        if(a.getPlaque().equals("") | a.getCode().equals("") | a.getChoose().equals("")){
            chek=true;
        }
        return chek;//true یعنی خالی بودن
  }

    public  boolean chek_code(AvarezipageEntity a ){
        boolean chek=false;
        if(a.getCode().equals("111") | a.getCode().equals("121") | a.getCode().equals("413") | a.getCode().equals("981")){
            chek=true;
        }
        return  chek;//true یعنی صحیح
    }

}
