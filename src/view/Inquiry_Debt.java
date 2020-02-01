package view;

import model.entity.RegisertingViolationsEntity;
import model.service.Registering_violationServ;

import javax.swing.*;
import java.util.ArrayList;

public class Inquiry_Debt {

    public String debt(String pe)throws Exception {

        long total = 0;
        ArrayList<RegisertingViolationsEntity> list = Registering_violationServ.getInstance().report();
        for (RegisertingViolationsEntity R : list) {
            if (R.getPlaque().equals(pe)) {
                total += Integer.valueOf(R.getPrice1());
            }
        }
        JFrame f5 = new JFrame("بدهی شما");
        JOptionPane.showMessageDialog(f5, total);
        return String.valueOf(total);
    }
}
