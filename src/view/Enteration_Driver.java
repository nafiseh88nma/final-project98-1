package view;

import model.entity.RegisertingViolationsEntity;
import model.service.Registering_violationServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Enteration_Driver {

    public String cer;
    public String card;
    public String pe;
    public Enteration_Driver(String cer , String card , String pe , Color color ) {
        this.cer=cer;//(شماره گواهی نامه)برای استعلام نمره منفی
        this.card=card;//(شماره کارت ماشین)برای استعلام تصادفات
        this.pe=pe;//برای لیست تخلفات راننده (شماره پلاک)

        JFrame f1 = new JFrame();
        f1.setSize(500, 500);
        f1.getContentPane().setBackground(Color.orange);
        /////////////////////
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JTabbedPane tp = new JTabbedPane();
        // تم پیش فرض
        tp.setBackground(Color.pink);
        tp.setForeground(Color.black);

        tp.add("تخلفات", p1);
        tp.add("خدمات شهری(خرید طرح تزافیک)", p2);
        tp.setBounds(50, 50, 400, 400);
        //////////////////////////////p1 تخلفات////////////////////////////////
        JButton button1 = new JButton("لیست تخلفات راننده");
        JButton button2 = new JButton("استعلام نمره منفی راننده");
        JButton button3 = new JButton("مبلغ پرداختی جرایم رانندگی");
        JButton button4 = new JButton("پرداخت الکترونیکی");

        button1.setBounds(50, 50, 100, 30);
        button2.setBounds(50, 100, 100, 30);
        button3.setBounds(50, 150, 100, 30);
        button4.setBounds(50, 200, 100, 30);

        button1.setBackground(color);
        button2.setBackground(color);
        button3.setBackground(color);
        button4.setBackground(color);

        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        f1.add(tp);
        f1.setLayout(null);
        f1.setVisible(true);
/////////////////////وقتی راننده دکمه استعلام تخلفات رو زد /////////////////////////
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Inquiry_Violation(pe);//معیار استعلام تخلفات هم شماره پلاک و شماره کارت ماشین است
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
///////////////////وقتی راننده دکمه استعلام نمره منفی رو زد////////////////////
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Inquiry_NegativeScore(cer);//برای استعلام نمره منفی معیار جست و جو یما شماره کارت ماشین و شماره گواهی نامه است/که از صفحه اول ورود راننده این اطلاعات برداشته میشود
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        ////////////////اگر جمع جرایم رو زد////////////////////////////
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    new Inquiry_Debt().debt(pe);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        /////////////////////////////////////اگر پرداخت رو زد///////// /
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total=0;
                try {
                    ArrayList<RegisertingViolationsEntity> list = Registering_violationServ.getInstance().report();
                    for (RegisertingViolationsEntity R : list) {
                        if (R.getPlaque().equals(pe)) {
                            total += Integer.valueOf(R.getPrice1());
                        }
                    }

                    new Payment(total,card);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
        ////////////////////////////////خدمات شهری p2/////////////////////////////

        JButton b1= new JButton("روزانه ( 100,000 ریال )");
        JButton b2= new JButton("ماهانه( 2,500,000 ریال )");
        JButton b3= new JButton("سالانه( 20,000,000 ریال )");


        b1.setBounds(50,50 ,250,30);
        b2.setBounds(50,100,250,30);
        b3.setBounds(50,150,250,30);

        b1.setBackground(color);
        b2.setBackground(color);
        b3.setBackground(color);


        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        ////////////////////////////////////////////////
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment payment03= new Payment(10000,pe,"روزانه");
            }
        });
        /////////////////////////////////////////////////
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment payment01= new Payment(250000,pe,"ماهانه");
            }
        });
        ///////////////////////////////////////////////////
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Payment payment02= new Payment(2000000,pe,"سالانه");
            }
        });
    }
}

