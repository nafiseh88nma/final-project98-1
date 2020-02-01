package view;

import controller.Control_Register_V_A;
import model.entity.AccidentEntity;
import model.entity.Enteration_officerEntity;
import model.service.AccidentServ;
import model.service.Enteration_officerServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register_Accident {

        public  String name;
        public  String code;

public Register_Accident(String name, String code, String date) {

         this.name=name;
         this.code=code;

        JFrame f=new JFrame();
        f.setBounds(720,200,700,500);
        f.getContentPane().setBackground(Color.orange);
        f.setVisible(true);
        //////////////////////////////
        JTextField t=new JTextField();
        t.setBounds(110,10,150,30);
        f.add(t);
        JLabel l=new JLabel("نام افسر");
        l.setBounds(10,10, 100,30);
        t.setText(name);
        t.setEditable(false);
        f.add(l);
        ///////////////////////////////////////////
        JLabel l1=new JLabel("کد افسر");
        l1.setBounds(10,50, 100,30);
        JTextField t1=new JTextField();
        t1.setBounds(110,50,150,30);
        t1.setText(code);
        t1.setEditable(false);
        f.add(t1);
        f.add(l1);
        ////////////////////////////////////////////
         JLabel l2=new JLabel("شماره بیمه نامه");
         l2.setBounds(10,90 , 100,30);
         JTextField t2=new JTextField();
         t2.setBounds(110,90,150,30);
         f.add(t2);
         f.add(l2);
        ///////////////////////////////////////////////
        JLabel l7=new JLabel("شماره پلاک ماشین");
        l7.setBounds(10,130, 100,30);
        JTextField t7=new JTextField();
        t7.setBounds(110,130,150,30);
        f.add(t7);
        f.add(l7);
        ////////////////////////////////////////////////
        JLabel l3=new JLabel("شماره کارت ماشین");
        l3.setBounds(10,170, 100,30);
        JTextField t3=new JTextField();
        t3.setBounds(110,170,150,30);
        f.add(t3);
        f.add(l3);
        ////////////////////////////////////////////////
        JLabel l4=new JLabel("شماره گواهی نامه ");
        l4.setBounds(10,210, 100,30);
        JTextField t4=new JTextField();
        t4.setBounds(110,210,150,30);
        f.add(t4);
        f.add(l4);
        ////////////////////////////////////////////////

        ////////////////////////////////////////////////
        JLabel l5=new JLabel("تاریخ و ساعت");
        l5.setBounds(10,250, 100,30);
        JTextField t5=new JTextField();
        t5.setBounds(110,250,150,30);
        t5.setText(date);
        t5.setEditable(false);
        f.add(t5);
        f.add(l5);
        /////////////////////////////////////////////////
        JLabel l6=new JLabel("مکان");
        l6.setBounds(10,290, 100,30);
        JTextField t6=new JTextField();
        t6.setBounds(110,290,150,30);
        f.add(t6);
        f.add(l6);
        /////////////////////////////////////////////////////
        JButton bb =new JButton("ثبت");
        f.add(bb);
        bb.setBounds(10,340,400,30);
        bb.setBackground(Color.yellow);
        ///////////////////////////////////////////////////
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccidentEntity a =new AccidentEntity();
                a.setOfficer_name(t.getText());//اسم افسر
                a.setOfficer_code(t1.getText());//کد افسر
                a.setInsurance(t2.getText());//شماره بیمه نامه
                a.setPlaque(t7.getText());//شماره پلاک
                a.setCard(t3.getText());//شماره کارت ماشین
                a.setCertificate(t4.getText());//شماره گواهی نامه
                a.setDate(t5.getText());//تاریخ
                a.setLocation(t6.getText());//مکان
                ////////////////////////////
                Control_Register_V_A control_registerVA = new Control_Register_V_A();
                boolean chek_correct = false;
                boolean chek_empty = false;
                try {
                    chek_correct = control_registerVA.Accident(a);
                    chek_empty = control_registerVA.Accident_empty(a);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }


                if (chek_correct == true && chek_empty == false) {
                    try {
                        AccidentServ.getInstance().Save(a);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f,"تصادف با موفقیت گزارش شد");
                        /////////////////ثبت خدمت انتخابی افسر//////////////
                        Enteration_officerEntity EO = new Enteration_officerEntity();
                        EO.setName(name);
                        EO.setCode(code);
                        EO.setTime(date);
                        EO.setServname("RegAccident");
                        EO.setServcode("2");
                        Enteration_officerServ.getInstance().save(EO);
                        //////////////////////////////////////////////////
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
                else if (chek_empty == true) {
                    JFrame f = new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f, "لطفا کادر های خالی را پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);


                } else if (chek_correct == false) {
                    JFrame f = new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f, "لطفا کادر ها را با دقت پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);

                }
            //////////////////////////////////////////////////////

            }
        });

        f.setLayout(null);
    }
}
