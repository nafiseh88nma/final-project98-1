package view;


import controller.Control_Interation;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.entity.AvarezgirEntity;
import model.entity.CarEntity;
import model.entity.OfficerEntity;
import model.repository.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.applet.*;
import java.net.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class UI {

    public static Color color = Color.pink;

    public static void main(String[] args) throws Exception {
      // new AvareziRepo().create_avarezi();
      //  new RoadServiceRepo().create_roadservice();
       // new Registering_ViolationsRepo().create_registering_violations();
         //new Electronic_PaymentRepo().create_electronic_payment();
      // new Enteration_officerRepo().create_enteration_officer();
        // new CityServiceRepo().create_cityservice();
       // new CarRepo().create_car();
        //new AccidentRepo().create_accidents();


        JFrame frame=new JFrame("سیستم پیشرفته راهنمایی و رانندگی");
        /////////////////////////////////////////////////////////////////////
        JLabel jLabel =new JLabel("کلیه حقوق مادی و معنوی این برنامه متعلق است به مبینا و نفیسه ...\n هرگونه کپی برداری و سوء استفاده پیگرد قانونی دارد !");
        jLabel.setBounds(120,500,500,30);
        frame.add(jLabel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(650,600);
        frame.setDefaultLookAndFeelDecorated(true);
        /////////////////////////////////تم//////////////////////////////////////
        JButton button =new JButton("تم");
        button.setBounds(1,1,100,30);
        button.setBackground(color);
        /////////////////////////بخش ورود راننده//////////////////////////////////
        JLabel l1 =new JLabel("ورود راننده");
        l1.setForeground(Color.BLUE);
        l1.setBounds(150,1,50,100);
        ////////////////////////
        JLabel l2=new JLabel("شماره پلاک");
        l2.setBounds(30,100, 80,30);
        JTextField t2=new JTextField();
        t2.setBounds(110,100,150,30);
        /////////////////////
        JLabel l3=new JLabel("نام مالک ماشین");
        l3.setBounds(30,150, 80,30);
        JTextField t3=new JTextField();
        t3.setBounds(110,150,150,30);
        ////////////////////////
        JLabel l4=new JLabel("شماره ی بیمه نامه ");
        l4.setBounds(25,200, 80,30);
        JTextField t4=new JTextField();
        t4.setBounds(110,200,150,30);
        /////////////////////////////////////////////////////////////////////////////////
        JLabel l5=new JLabel("شماره گواهی نامه");
        l5.setBounds(30,250, 80,30);
        JTextField t5=new JTextField();
        t5.setBounds(110,250,150,30);
        ///////////////////////////////////////////////////////////////////////////////
        JLabel l6=new JLabel("شماره کارت ماشین ");
        l6.setBounds(25,300, 80,30);
        JTextField t6=new JTextField();
        t6.setBounds(110,300,150,30);
        ///////////////////////////////////////////////////////////////////////////////
        JButton b1=new JButton("ورود");
        b1.setBounds(140,360,80,30);
        b1.setBackground(color);
        ////////////////////////////////////////////////////////////////////////////
        frame.add(l1);
        frame.add(t2);
        frame.add(l2);
        frame.add(t3);
        frame.add(l3);
        frame.add(t4);
        frame.add(l4);
        frame.add(t5);
        frame.add(l5);
        frame.add(l6);
        frame.add(t6);
        frame.add(button);

        frame.add(b1);
        ////////////////////////////////////بخش ورود افسر////////////////////////////
        JLabel la =new JLabel("ورود افسر");
        la.setForeground(Color.BLUE);
        la.setBounds(410,1,50,100);
        //////////////////////
        JLabel ln=new JLabel("نام کامل افسر");
        ln.setBounds(500,100, 80,30);
        JTextField tn=new JTextField();
        tn.setBounds(320,100,150,30);
        /////////////////////
        JLabel lc=new JLabel("کد افسر");
        lc.setBounds(500,150, 80,30);
        JTextField tc=new JTextField();
        tc.setBounds(320,150,150,30);
        /////////////////////
        JPasswordField value = new JPasswordField();
        JLabel lp = new JLabel("رمز عبور");
        lp.setBackground(Color.orange);
        lp.setBounds(500, 200, 80, 30);
        value.setBounds(320, 200, 150, 30);
        /////////////////////
        JButton b2=new JButton("ورود");
        b2.setBounds(360,250,70,30);
        b2.setBackground(color);
        ///////////////
        frame.add(la);
        frame.add(value);
        frame.add(lc);
        frame.add(tc);
        frame.add(lp);
        frame.add(tn);
        frame.add(ln);
        frame.add(b2);
        ///////////////////////////ورود مامور عوارضی/////////////////////////////
        JLabel lz =new JLabel("خدمات جاده ای : ورود مامور اخذ عوارضی");
        lz.setForeground(Color.BLUE);
        lz.setBounds(380,270,200,50);
        //////////////////////
        JLabel lu=new JLabel("نام کاربری مامور اخذ ");
        lu.setBounds(500,320, 100,30);
        JTextField tu=new JTextField();
        tu.setBounds(320,320,150,30);
        //////////////////////
        JLabel lu2=new JLabel("رمز عبور");
        JPasswordField v2 = new JPasswordField();
        lu2.setBounds(500,370, 80,30);
        v2.setBounds(320,370,150,30);
        /////////////////////
        JButton b3=new JButton("ورود");
        b3.setBounds(350,430,80,30);
        b3.setBackground(color);
        ///////////////////////
        frame.add(lz);
        frame.add(tu);
        frame.add(lu);
        frame.add(v2);
        frame.add(lu2);
        frame.add(b3);
        //////////////////////
        frame.setLayout(null);
        frame.setVisible(true);
        //Color color =Color.blue;
/////////////////////////////////////////////////////////////// انتخاب تم//////////////////////////////////////////////////////////
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(frame,"Choose",Color.CYAN);
                button.setBackground(color);
                b1.setBackground(color);
                b2.setBackground(color);
                b3.setBackground(color);
            }
        });
////////////////////////////////////////////وقتی دکمه ورود راننده رو زد//////////////////////////////////////////
        b1.addActionListener(new ActionListener() {
           @Override
               public void actionPerformed(ActionEvent e) {

               CarEntity carEntity =new CarEntity();
               carEntity.setName(t3.getText());
               carEntity.setPlaque(t2.getText());
               carEntity.setInsurance(t4.getText());
               carEntity.setCertificate(t5.getText());
               carEntity.setCard(t6.getText());

               Control_Interation control_interation = new Control_Interation();

               boolean chek_correctness = false;
               boolean chek_empty = false;

               try {
                   chek_correctness = control_interation.Driver(carEntity);
                   chek_empty = control_interation.Driver_empty(carEntity);
               } catch (Exception e1) {
                   e1.printStackTrace();
               }

               if(chek_correctness==true && chek_empty!=true){
                   new Enteration_Driver(t5.getText() ,t6.getText() ,  t2.getText() ,color );
               }
               else  if(chek_empty==true){
                   JFrame f=new JFrame("خطا!!!!!");
                   JOptionPane.showMessageDialog(f,"لطفا کادر های خالی را پر کنید...",
                           "خطا", JOptionPane.WARNING_MESSAGE);
               }
               else if(chek_correctness==false && chek_empty!=true){
                   JFrame f=new JFrame("خطا!!!!!");
                   JOptionPane.showMessageDialog(f,"این اتومبیل موجود نیست\nلطفا بادقت وارد کنید...",
                           "خطا", JOptionPane.WARNING_MESSAGE);
               }


           }});
/////////////////////////////////////////اگر دکمه ورود افسر رو زد////////////////////////////////////////////////
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OfficerEntity officerEntity =new OfficerEntity();
                officerEntity.setName(tn.getText());
                officerEntity.setCode(tc.getText());
                officerEntity.setPassword(String.valueOf(value.getPassword()));
                Control_Interation control_interation = new Control_Interation();

                boolean chek_correctness = false;
                boolean chek_empty = false;

                try {
                    chek_correctness = control_interation.Officer(officerEntity);
                    chek_empty = control_interation.Officer_empty(officerEntity);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                if(chek_correctness==true && chek_empty!=true){//نه کادری خالی است و نه اطلاعاتی نادرست
                    new Enteration_Officer(officerEntity.getName(),officerEntity.getCode(),color);//اسم و کد افسر را پاس میدهیم اون ور
                }
                else  if(chek_empty==true){//کادر خالی داریم
                    JFrame f=new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f,"لطفا کادر های خالی را پر کنید ...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
                else if(chek_correctness==false && chek_empty!=true){//کادر خالی نداریم ولی اطلاعات صحت ندارند
                    JFrame f=new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f,"این اطلاعات صحیح نمی باشد\nلطفا بادقت وارد کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
////////////////////////////////////////////////////دکمه ورود مامور عوارضی//////////////////////////////////////////
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AvarezgirEntity avarezgirEntity =new AvarezgirEntity();
                avarezgirEntity.setName(tu.getText());
                System.out.println("1:"+avarezgirEntity.getName());
                avarezgirEntity.setPassword(String.valueOf(v2.getPassword()));
                System.out.println("2:"+avarezgirEntity.getPassword());

                Control_Interation control_interation =new Control_Interation();

                boolean chek_correctness = false;
                boolean chek_empty = false;

                try {
                    chek_correctness = control_interation.Avarezgir(avarezgirEntity);
                    chek_empty = control_interation.Avarezgir_empty(avarezgirEntity);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if(chek_correctness==true && chek_empty!=true){
                    new Enteration_Avarezgir(color);
                }
                else  if(chek_empty==true){
                    JFrame f=new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f,"لطفا کادر های خالی را پر کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
                else if(chek_correctness==false && chek_empty!=true){
                    JFrame f=new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f,"این اطلاعات صحیح نمی باشد\nلطفا بادقت وارد کنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}


