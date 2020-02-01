package view;


import controller.Control_Register_V_A;
import controller.Control_Violation;
import model.entity.Enteration_officerEntity;
import model.entity.RegisertingViolationsEntity;
import model.service.Enteration_officerServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_violation {

    public  String name;
    public  String code;
    public Register_violation(String name , String code , String date) {

        this.name=name;
        this.code=code;


        JFrame f=new JFrame();
        f.setBounds(720,200,700,500);
        f.getContentPane().setBackground(Color.orange);
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
        //////////////////////////////////////////////
        JRadioButton r1=new JRadioButton("سرعت غیر مجاز");
        JRadioButton r2=new JRadioButton(" پارک ممنوع");
        JRadioButton r3=new JRadioButton("عبور از چراغ قرمز");
        JRadioButton r4=new JRadioButton("دور زدن ممنوع ");
        JRadioButton r5=new JRadioButton(" ورود ممنوع");
        r1.setBounds(10,90,100,30);
        r2.setBounds(110,90,100,30);
        r3.setBounds(210,90,120,30);
        r4.setBounds(330,90,100,30);
        r5.setBounds(430,90,100,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2); bg.add(r3);
        bg.add(r4);bg.add(r5);
        f.add(r1);f.add(r2);f.add(r3);
        f.add(r4);f.add(r5);
        ////////////////////////////////////////////
        /**
        JLabel l2=new JLabel("تخلف");
        l2.setBounds(10,90 , 100,30);
        JTextField t2=new JTextField();
        t2.setBounds(110,90,150,30);
        f.add(t2);
        f.add(l2);
        **/
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
        JLabel l5=new JLabel("تاریخ و ساعت ");
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
        //قیمت
        //نمره منفی
        //تو قسمت کنترل بررسی میشود
        ///////////////////////////////////////////////////////
        JButton bb =new JButton("ثبت");
        f.add(bb);
        bb.setBounds(10,340,400,30);
        bb.setBackground(Color.yellow);
        ///////////////////////////////////////
        bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String choos = "";

                if (r1.isSelected()) {
                    choos = "1";
                } else if (r2.isSelected()) {
                    choos = "2";
                } else if (r3.isSelected()) {
                    choos = "3";
                } else if (r4.isSelected()) {
                    choos = "4";
                } else if (r5.isSelected()) {
                    choos = "5";
                }
                ///////////////////////////////////////////
                RegisertingViolationsEntity r = new RegisertingViolationsEntity();
                r.setOfficer_name(t.getText());// اسم افسر
                r.setOfficer_code(t1.getText());//کدافسر
                r.setName_Infraction(choos);//اسم تخلف
                r.setPlaque(t7.getText());//شماره پلاک
                r.setCard(t3.getText());//شماره کارت ماشین
                r.setCertificate(t4.getText());//شماره گواهی نامه
                r.setDate(t5.getText());//تاریخ
                r.setLocation(t6.getText());//مکان
                //نام راننده و شماره بیمه نامه رو در جدول تخلفات ثبت نمیکنم
                //////////////////////////////////////
                Control_Register_V_A control_registerVA = new Control_Register_V_A();
                boolean chek_correct = false;
                boolean chek_empty = false;
                try {
                    chek_correct = control_registerVA.Violation(r);
                    chek_empty = control_registerVA.Violation_empty(r);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }


                if (chek_correct == true && chek_empty == false ) {
                    Control_Violation c = new Control_Violation();
                    try {
                        c.control(r);
                        JFrame f = new JFrame();
                        JOptionPane.showMessageDialog(f, "تخلف با موفقیت ثبت شد");
                        System.out.println("تخلف با موفقیت ثبت شد");
                        ///////////////////////ثبت خدمت انتخابی افسر/////////////////
                        Enteration_officerEntity EO = new Enteration_officerEntity();
                        EO.setName(name);
                        EO.setCode(code);
                        EO.setTime(date);
                        EO.setServname("RegViolation");
                        EO.setServcode("1");
                        Enteration_officerServ.getInstance().save(EO);
                       ////////////////////////////////////////////////////////////
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                } else if (chek_empty == true) {
                    JFrame f = new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f, "لطفا کادر های خالی را پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);


                } else if (chek_correct == false) {
                    JFrame f = new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f, "لطفا کادر ها را با دقت پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);

                }

            }
        });
        //////////////
        f.setLayout(null);
        f.setVisible(true);
    }


}
