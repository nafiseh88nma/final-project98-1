package view;

import model.entity.RegisertingViolationsEntity;
import model.service.Registering_violationServ;

import javax.swing.*;
import java.util.ArrayList;

public class Inquiry_NegativeScore {

    public Inquiry_NegativeScore(String cer) throws Exception{//عیار جست و جو برای نمره منفی ها وشماره گواهی نامه هست
        long total=0;
        ArrayList<RegisertingViolationsEntity> list = Registering_violationServ.getInstance().report();
        String violate="";
        for(RegisertingViolationsEntity R : list){

            if(R.getCertificate().equals(cer)){
                if(!R.getNscore().equals("0")){
                    violate += R.getName_Infraction();
                    violate += "\n";
                }
                total += Integer.valueOf(R.getNscore());
            }
        }
        JFrame f5=new JFrame("نمره منفی");
        JOptionPane.showMessageDialog(f5 ,"\n :نمره منفی \n " + violate  +"-------------\n" + total );

    }
}
