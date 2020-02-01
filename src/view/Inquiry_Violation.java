package view;

import model.entity.RegisertingViolationsEntity;
import model.repository.Registering_ViolationsRepo;
import model.service.Registering_violationServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Inquiry_Violation {

    public Inquiry_Violation(String pe) throws Exception {


            JFrame f4=new JFrame();

            f4.getContentPane().setBackground(Color.pink);
            ///////////////////////////////////////////////////////////////////
            String[][] data=new String[100][6];//داده های ماشین مورد نظر

            ArrayList<RegisertingViolationsEntity> list = new Registering_violationServ().report();
            int i=0;
            System.out.println("2:" + pe);
            for (RegisertingViolationsEntity R: list) {
                    System.out.println(R.getPlaque());
                    if(R.getPlaque().equals(pe)) {//فیلتر کردن// به وسیله شماره پلاک
                            data[i][0] = R.getOfficer_code();
                            data[i][1] = R.getName_Infraction();
                            data[i][2] = String.valueOf(R.getNscore());
                            data[i][3] = String.valueOf(R.getPrice1());
                            data[i][4] = R.getDate();
                            data[i][5] = R.getLocation();
                            i += 1;
                    }
            }

            String column[]={"کد افسر","تخلف","نمره منفی","قیمت","تاریخ و ساعت ","مکان"};

            JTable jt=new JTable(data,column);
            jt.setEnabled(false);

            JScrollPane sp=new JScrollPane(jt);

            f4.setSize(1000,500);
            f4.setVisible(true);
            f4.add(sp);

    }
}
