package view;

import controller.Control_Item;
import model.entity.Enteration_officerEntity;
import model.service.Enteration_officerServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Enteration_Officer {

    public  String name;
    public  String code;

    public Enteration_Officer(String name , String code , Color color) {

        this.name=name;
        this.code=code;
/////////////////////////////////////////////////////////////////////////////
        JFrame f2 = new JFrame();
        f2.setSize(500,500);
        f2.getContentPane().setBackground(Color.orange);
/////////////////////////////////////////////////////////////////////////////
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
/////////////////////////////////////////////////////////////////////////////
        JTabbedPane tp = new JTabbedPane();
        // تم پیش فرض
        tp.setBackground(Color.pink);
        tp.setForeground(Color.black);
/////////////////////////////////////////////////////////////////////////////
        tp.add("تخلفات و نمره منفی", p1);
        tp.add("تصادفات", p2);
/////////////////////////////////////////////////////////////////////////////
        tp.setBounds(50, 50, 400, 400);
/////////////////////////////////////////////////////////////////////////////
        JButton button1 = new JButton("ثبت تخلفات و نمره منفی");
        JButton button2 = new JButton("استعلام تخلفات");
        JButton button5 = new JButton("استعلام نمره منفی");
/////////////////////////////////////////////////////////////////////////////
        JButton button3 = new JButton("ثبت تصادفات");
        JButton button4 = new JButton("استعلام تصادفات");
//////////////////////////////////////////////////////////////////////////////
        button1.setBounds(50,50,100,30);
        button2.setBounds(50,100,100,30);
        button3.setBounds(50,150,100,30);
        button4.setBounds(50,200,100,30);
//////////////////////////////////////////////////////////////////////////////
        button1.setBackground(color);
        button2.setBackground(color);
        button3.setBackground(color);
        button4.setBackground(color);
        button5.setBackground(color);
//////////////////////////////////////////////////////////////////////////////
        p1.add(button1);
        p1.add(button2);
        p1.add(button5);
        p2.add(button3);
        p2.add(button4);
////////////////////////////////////////////////////////////////////////////
        f2.add(tp);
        f2.setLayout(null);
        f2.setVisible(true);
//////////////////////////////////////ثبت تخلف///////////////////////////////
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date =new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd  HH:mm");
                String time=sf.format(date);
                new Register_violation(name,code,time);//ثبت تخلف
            }
        });
////////////////////////////////////////////////استعلام تخلف ///////////////////////////////////////
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ////////////////ثبت خدمت افسر/////////////////////
                JFrame f=new JFrame();
                f.setDefaultCloseOperation(EXIT_ON_CLOSE);
                String pe =JOptionPane.showInputDialog(f,"شماره پلاک راننده مورد نظر");

                    Control_Item c = new Control_Item();
                    boolean chek = false;
                    try {
                        chek = c.chek_Plaque(pe);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                //////////////////////////////////////////////////////////////////////////////////////
                    if (chek) { //true
                        Date date = new Date();
                        SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd  HH:mm");
                        String time = sf.format(date);

                        Enteration_officerEntity EO = new Enteration_officerEntity();
                        EO.setName(name);
                        EO.setCode(code);
                        EO.setTime(time);
                        EO.setServname("Nscore");
                        EO.setServcode("5");

                        try {
                            new Inquiry_Violation(pe);
                            Enteration_officerServ.getInstance().save(EO);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }

                    else {
                        JFrame f1 = new JFrame("خطا!!!!!");
                        JOptionPane.showMessageDialog(f1, "این شماره پلاک موجود نمی باشد...",
                                "خطا", JOptionPane.WARNING_MESSAGE);
                    }
            }
        });
        /////////////////////////////////////////////استعلام نمره منفی/////////////////////////////////
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f=new JFrame();
                String cer =JOptionPane.showInputDialog(f,"شماره گواهی نامه راننده ");

                    Control_Item c = new Control_Item();
                    boolean chek = false;
                    try {
                        chek = c.chek_Certificate(cer);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    /////////////////////////////////////////////////////////
                    if (chek) {//true
                            ///////////////ثبت خدمت انتخابی افسر////////////
                            Date date = new Date();
                            SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd  HH:mm");
                            String time = sf.format(date);
                            Enteration_officerEntity EO = new Enteration_officerEntity();
                            EO.setName(name);
                            EO.setCode(code);
                            EO.setTime(time);
                            EO.setServname("Nscore");
                            EO.setServcode("5");
                        try {
                            new Inquiry_NegativeScore(cer);
                            Enteration_officerServ.getInstance().save(EO);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        ///////////////////////////////////////////////////
                    } else {
                        JFrame f1 = new JFrame("خطا!!!!!");
                        JOptionPane.showMessageDialog(f1, "این شماره گواهینامه موجود نمی باشد...",
                                "خطا", JOptionPane.WARNING_MESSAGE);
                    }
                }
        });
        /////////////////////////////////////////////////////////استعلام تصادف/////////////////////////////////
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f=new JFrame();
                String card =JOptionPane.showInputDialog(f,"شماره کارت ماشین راننده ");

                    Control_Item c = new Control_Item();
                    boolean chek = false;
                    try {
                        chek = c.chek_card(card);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    /////////////////////////////////////
                    if (chek) {//true
                        /////////////ثبت خدمت انتخابی افسر//////////////////////
                        Date date = new Date();
                        SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd  HH:mm");
                        String time = sf.format(date);
                        Enteration_officerEntity EO = new Enteration_officerEntity();
                        EO.setName(name);
                        EO.setCode(code);
                        EO.setTime(time);
                        EO.setServname("4");
                        EO.setServcode("InqAccident");
                        //////////////////////////////////////
                        try {
                            new Inquiry_Accident(card);
                            Enteration_officerServ.getInstance().save(EO);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        ///////////////////////////////////////////
                    } else {//false
                        JFrame f1 = new JFrame("خطا!!!!!");
                        JOptionPane.showMessageDialog(f1, "این شماره کارت ماشین موجود نمی باشد...",
                                "خطا", JOptionPane.WARNING_MESSAGE);
                    }

                }
        });
        ////////////////////////////////////////////ثبت تصادف/////////////////////////////////////////////////
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date =new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd  HH:mm");
                String time=sf.format(date);
                new Register_Accident(name, code ,time);
            }
        });
        /////////////////////////////////////////////////
    }
}
