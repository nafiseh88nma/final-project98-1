package view;


import controller.Control_Avarezgirpage;
import controller.Control_Item;
import model.entity.AvarezgirEntity;
import model.entity.AvarezipageEntity;
import model.entity.RoadServiceEntity;
import model.service.RoadServiceServ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enteration_Avarezgir {

    public Enteration_Avarezgir(Color color) {

        JFrame f2 = new JFrame("عوارضی");
        f2.setBounds(720,200,350,350);

        JLabel l1=new JLabel("شماره پلاک");
        l1.setBounds(50,10, 80,30);
        JTextField t1=new JTextField();
        t1.setBounds(120,10,150,30);
        f2.add(t1);
        f2.add(l1);
        //////////////////////////////
        JLabel l2=new JLabel("کد اخذ عوارضی");
        l2.setBounds(50,50, 80,30);
        JTextField t2=new JTextField();
        t2.setBounds(120,50,150,30);
        f2.add(t2);
        f2.add(l2);

        /////////////////////////////////////////////////////
        JRadioButton r1=new JRadioButton("سواری");
        JRadioButton r2=new JRadioButton("کامیون ");
        JRadioButton r3=new JRadioButton("اتوبوس ");
        r1.setBounds(50,100,100,30);
        r2.setBounds(50,130,100,30);
        r3.setBounds(50,160,100,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2); bg.add(r3);
        f2.add(r1);f2.add(r2); f2.add(r3);
        ////////////////////////////////////////////////////
        JButton buttons =new  JButton("ثبت");
        buttons.setBounds(50,200,100,30);
        buttons.setBackground(color);
        f2.add(buttons);
        ///////////////////////////////
        f2.setLayout(null);
        f2.getContentPane().setBackground(Color.ORANGE);
        f2.setVisible(true);

        ///////////////دکمه ثبت عوارضی رو که زد ////////////////////////
        buttons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String car="";
                String price="";
                if(r1.isSelected()){
                    car="savari";
                    price="3000";
                }
                else if(r2.isSelected()){
                    car="kamiyon";
                    price="5000";
                }
                else if(r3.isSelected()){
                    car="otoboos";
                    price="4000";
                }
                //////////صحت همه چی و ریختن در دیتا بیس/////////////
                AvarezipageEntity a = new AvarezipageEntity();
                a.setPlaque(t1.getText());
                a.setCode(t2.getText());
                a.setChoose(car);
                ///////////////////////////////////////////////////
                boolean chek_empty=true;//true کادر خالی داریم
                boolean chek_code=false;//true کد صحیح است
                boolean chek_pelak=false;//true شماره پلاک موجود است

                Control_Avarezgirpage control_avarezgirpage = new Control_Avarezgirpage();

                Control_Item control_item = new Control_Item();

                chek_empty = control_avarezgirpage.chek_empty(a);//// چک کردن خالی نبودن کادر ها
                chek_code = control_avarezgirpage.chek_code(a);//چک کردن صحت کد عوارضی

                try {
                    chek_pelak = control_item.chek_Plaque(a.getPlaque());//چک کردن صحت پلاک
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                //////////////////////////////////////

                if(chek_empty==true){//کادر خالی داریم
                    JFrame f=new JFrame("خطا!!!!!");
                    JOptionPane.showMessageDialog(f,"لطفا کادر های خالی را پرکنید...",
                            "خطا", JOptionPane.WARNING_MESSAGE);
                }
                else{//کادر خالی نداریم

                    if(chek_pelak == false){// پلاک نادرست است
                        JFrame f=new JFrame("خطا!!!!!");
                        JOptionPane.showMessageDialog(f,"شماره پلاک وارد شده نادرست است...",
                                "خطا", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(chek_pelak==true && chek_code==false){//پلاک درسته و کد عوارضی غلط است
                        JFrame f=new JFrame("خطا!!!!!");
                        JOptionPane.showMessageDialog(f,"کد عوارضی نامعتبر است...",
                                "خطا", JOptionPane.WARNING_MESSAGE);
                    }
                    else if(chek_pelak==true && chek_code==true ){//همه چی درسته
                        RoadServiceEntity roadServiceEntity = new RoadServiceEntity();
                        roadServiceEntity.setModel(car);
                        roadServiceEntity.setPrice(price);
                        roadServiceEntity.setId(a.getCode());
                        roadServiceEntity.setPlaque(a.getPlaque());

                        try {
                            RoadServiceServ.getInstance().insert(roadServiceEntity);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        JFrame f=new JFrame(":)");
                        JOptionPane.showMessageDialog(f,"با موفقیت ثبت شد...");
                    }
                }
                ///////////////////////////////

            }
        });
    }
}
