package view;

import controller.Control_payment;
import model.entity.CityServiceEntity;
import model.entity.Electronic_PaymentEntity;
import model.service.CityServiceServ;
import model.service.Electronic_paymentServ;
import model.service.Registering_violationServ;
import sun.awt.WindowClosingListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Payment extends  WindowAdapter {
    JFrame f;
    JTextField t1;
    JLabel l1;
    JTextField t2;
    JLabel l2;
    JTextField t3;
    JLabel l3;
    JTextField t4;
    JLabel l4;
    JButton button;

    public Payment(int debt , String pe ,String type){
        f=new JFrame();
        f.setBounds(500, 200, 400, 500);
        f.getContentPane().setBackground(Color.pink);
        f.addWindowListener(this);

        ////////////////
        t1=new JTextField();
        f.add(t1);
        t1.setText(String.valueOf(debt));
        t1.setEditable(false);
        t1.setBounds(50,50,100,30);
        l1= new JLabel("مبلغ");
        l1.setBounds(160,50,100,30);
        f.add(l1);
        //////////////////////////////////////////
        t2=new JTextField();
        f.add(t2);
        t2.setBounds(50,100,100,30);
        l2= new JLabel("شماره کارت");
        l2.setBounds(160,100,100,30);
        f.add(l2);
        /////////////////////  /////////////////////
        t3=new JTextField();
        f.add(t3);
        t3.setBounds(50,150,100,30);
        l3= new JLabel("رمز دوم");
        l3.setBounds(160,150,100,30);
        f.add(l3);
        /////////////////////  /////////////////////
        t4=new JTextField();
        f.add(t4);
        t4.setBounds(50,200,100,30);
        l4= new JLabel("CVV2");
        l4.setBounds(160,200,100,30);
        f.add(l4);
        /////////////////////

        button = new JButton("پرداخت");
        button.setBounds(200,250,80,30);
        button.setBackground(Color.cyan);
        f.add(button);
        //////////////////////////////////////////////////
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Electronic_PaymentEntity E = new Electronic_PaymentEntity();
                E.setNumber(t2.getText());
                E.setPassword2(t3.getText());
                E.setCvv2(t4.getText());
                E.setMojoudi(Long.valueOf(debt));
                Control_payment C =new Control_payment();

                if(C.chek_empty(E)){//کادر خالی داریم//true
                    JFrame f = new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f, "لطفا کادر های خالی را پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
                else{//کادر خالی نداریم
                    try {
                        if (C.chek_corectness(E)==true){//موجود بودن کارت
                            //////////////////////////////////////////////////////////////////////
                            if(C.chek_mojoudi(E)==false){//کارت موجودی دارد//false
                                Control_payment cp =new Control_payment();
                                Electronic_PaymentEntity ep = C.findcard(E);
                                Electronic_paymentServ.getInstance().update_mojoudi(ep.getNumber(), Long.valueOf(debt),ep.getMojoudi());
                                CityServiceEntity cityServiceEntity =new CityServiceEntity();

                                Date date =new Date();
                                SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd  HH:mm");
                                String time=sf.format(date);

                                cityServiceEntity.setDate(time);
                                cityServiceEntity.setPlaque(pe);
                                cityServiceEntity.setType(type);

                                CityServiceServ.getInstance().save(cityServiceEntity);

                                JFrame f = new JFrame();
                                Random random= new Random();
                                int ran=random.nextInt(10000000);
                                JOptionPane.showMessageDialog(f,"باموفقیت پرداخت شد\n کد پیگیری شما:\n"+ran);
                            }
                            //////////////////////
                            else if(C.chek_mojoudi(E)==true){//true//کارت موجودی ندارد
                                JFrame f = new JFrame("خطا!!!!!");
                                JOptionPane.showMessageDialog(f, " موجودی حساب شما کافی نیست!",
                                        "خطا", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        //////////////////////////////////////////////////////////////////////
                        else if(C.chek_corectness(E)==false){//کارت موجود نیست
                            JFrame f = new JFrame("خطا!!!!!");
                            JOptionPane.showMessageDialog(f, "اطلاعات کارت صحیح نمی باشد!",
                                    "خطا", JOptionPane.WARNING_MESSAGE);
                        }
                    }catch (Exception e1){
                        e1.getStackTrace();
                    }

                }
            }
        });
        //////////////////////////////////////////
        f.setLayout(null);
        //f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
    }

    ////////////////////////////////////////

    public Payment(int debt,String card) {
        f=new JFrame();
        f.setBounds(500, 200, 400, 500);
        f.getContentPane().setBackground(Color.pink);
        f.addWindowListener(this);

        ////////////////
        t1=new JTextField();
        f.add(t1);
        t1.setText(String.valueOf(debt));
        t1.setEditable(false);
        t1.setBounds(50,50,100,30);
        l1= new JLabel("مبلغ");
        l1.setBounds(160,50,100,30);
        f.add(l1);
        //////////////////////////////////////////
        t2=new JTextField();
        f.add(t2);
        t2.setBounds(50,100,100,30);
        l2= new JLabel("شماره کارت");
        l2.setBounds(160,100,100,30);
        f.add(l2);
        /////////////////////  /////////////////////
        t3=new JTextField();
        f.add(t3);
        t3.setBounds(50,150,100,30);
        l3= new JLabel("رمز دوم");
        l3.setBounds(160,150,100,30);
        f.add(l3);
        /////////////////////  /////////////////////
        t4=new JTextField();
        f.add(t4);
        t4.setBounds(50,200,100,30);
        l4= new JLabel("CVV2");
        l4.setBounds(160,200,100,30);
        f.add(l4);
        /////////////////////

        button = new JButton("پرداخت");
        button.setBounds(200,250,80,30);
        button.setBackground(Color.cyan);
        f.add(button);
        //////////////////////////////////////////////////
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Electronic_PaymentEntity E = new Electronic_PaymentEntity();
                E.setNumber(t2.getText());
                E.setPassword2(t3.getText());
                E.setCvv2(t4.getText());
                E.setMojoudi(Long.valueOf(debt));
                Control_payment C =new Control_payment();

                if(C.chek_empty(E)){//کادر خالی داریم//true
                    JFrame f = new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f, "لطفا کادر های خالی را پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
                else{ //کادر خالی نداریم

                    try {
                        if (C.chek_corectness(E)==true){ //موجود بودن کارت
                //////////////////////////////////////////////////////////////////////
                            if(C.chek_mojoudi(E)==false){ //کارت موجودی دارد//false


                                        Electronic_PaymentEntity ep = C.findcard(E);

                                        Electronic_paymentServ.getInstance().update_mojoudi(ep.getNumber(), Long.valueOf(debt),ep.getMojoudi());
                                Registering_violationServ.getInstance().remove(card);
                                JFrame f = new JFrame();
                                JOptionPane.showMessageDialog(f,"باموفقیت پرداخت شد");
                            }
                            ///////////////////////////////////////////////////////
                            else if(C.chek_mojoudi(E)==true){//true//کارت موجودی ندارد
                                        JFrame f = new JFrame("خطا!!!!!");
                                        JOptionPane.showMessageDialog(f, " موجودی حساب شما کافی نیست!",
                                                "خطا", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                //////////////////////////////////////////////////////////////////////
                        else if(C.chek_corectness(E)==false){ //کارت موجود نیست
                            JFrame f = new JFrame("خطا!!!!!");
                            JOptionPane.showMessageDialog(f, "اطلاعات کارت صحیح نمی باشد!",
                                    "خطا", JOptionPane.WARNING_MESSAGE);
                        }
                    }catch (Exception e1){
                        e1.getStackTrace();
                    }

                }
            }
        });
        //////////////////////////////////////////
        f.setLayout(null);
        //f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
    }
    public void windowClosing(WindowEvent e) {
        int a=JOptionPane.showConfirmDialog(f,"Are you sure?");
        if(a==JOptionPane.YES_OPTION){
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        else if(a==JOptionPane.NO_OPTION){
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else {
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
}



