package view;

import model.entity.AccidentEntity;
import model.entity.RegisertingViolationsEntity;
import model.service.AccidentServ;
import model.service.Registering_violationServ;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inquiry_Accident {

    public Inquiry_Accident (String card) throws Exception {


        JFrame f4=new JFrame();
        /////////////////////////////////////
        String[][] data=new String[100][7];//داده های ماشین مورد نظر

        ArrayList<AccidentEntity> list = AccidentServ.getInstance().Report();
        int i=0;

        for (AccidentEntity R: list) {
            if(R.getCard().equals(card)) {//فیلتر کردن// به وسیله شماره کارت
                data[i][0] = R.getOfficer_code();
                data[i][1] = R.getInsurance();
                data[i][2] = R.getPlaque();
                data[i][3] = R.getCertificate();
                data[i][4] = R.getDate();
                data[i][5] = R.getLocation();
                i += 1;
            }
        }

        String column[]={"کد افسر","شماره بیمه نامه","شماره پلاک","شماره گواهی نامه","تاریخ و ساعت","مکان"};


        JTable jt=new JTable(data,column);
        jt.setEnabled(false);
        JScrollPane sp=new JScrollPane(jt);
        f4.add(sp);

        f4.setSize(1000,500);
        f4.setVisible(true);
        f4.setLayout(null);
        ////////////


    }
}
