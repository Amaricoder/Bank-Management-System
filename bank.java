package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class bank implements ActionListener {
JButton bsign,bsignup,bclear;
JTextField cardtf;
JPasswordField pintf;
JFrame f;
String pinno;
    bank(String pinno){
this.pinno=pinno;
         f=new JFrame();
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/logo.jpg"));
        Image i= i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel l=new JLabel(i2);
        l.setBounds(70,10,100,100);
        f.add(l);

//welcome to atm
        JLabel l1=new JLabel("Welcome to ATM");
        l1.setBounds(200,40,400,40);
        l1.setFont(new Font("osward",Font.BOLD,38));
        f.add(l1);
       //card no
       JLabel card=new JLabel("Card No:");
        card.setFont(new Font("releway",Font.BOLD,28));
        card.setBounds(120,150,150,30);
        f.add(card);

        //testfield
         cardtf=new JTextField();
        cardtf.setBounds(300,150,230,30);
        cardtf.setFont(new Font("areal",Font.BOLD,14));
        f.add(cardtf);

        //pin no
        JLabel pin=new JLabel("PIN:");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("releway",Font.BOLD,28));
        f.add(pin);


        //pintestfield
         pintf=new JPasswordField();
        pintf.setBounds(300,220,230,30);
        pintf.setFont(new Font("areal",Font.BOLD,14));

        f.add(pintf);
//button signin
         bsign=new JButton("SIGN IN");
bsign.setBounds(300,300,100,30);
        bsign.setBackground(Color.BLACK);
        bsign.setForeground(Color.white);
     bsign.addActionListener(this);

f.add(bsign);

//clear button
         bclear=new JButton("CLEAR");
        bclear.setBounds(430,300,100,30);
        bclear.setBackground(Color.BLACK);
        bclear.setForeground(Color.white);
        bclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardtf.setText("");
                pintf.setText("");
            }
        });
f.add(bclear);
//bsignup
         bsignup=new JButton("Sign Up");
        bsignup.setBounds(300,350,230,30);
        bsignup.setBackground(Color.BLACK);
        bsignup.setForeground(Color.white);
        bsignup.addActionListener(this);
        f.add(bsignup);



        f.setLayout(null);
f.getContentPane().setBackground(Color.white);
        f.setTitle("ATM");
        f.setBounds(350,200,800,480);
       // f.setUndecorated(true);
        f.setVisible(true);



    }
    public static void main(String[] args) {
        new bank("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==bsignup){
    f.setVisible(false);
  new signup1().f.setVisible(true);

} else if (e.getSource()==bsign) {
    conn c=new conn();
    String cardno=cardtf.getText();
    String pin= pintf.getText();
    String q="select * from login where card_no='"+cardno+"'and PIN='"+pin+"'";


    try {

       ResultSet rs= c.s.executeQuery(q);
       if(rs.next()){
           f.setVisible(false);
           new atm(pin).f.setVisible(true);

       }else {
           JOptionPane.showMessageDialog(null,"Wrong Cardno & PIN");


           cardtf.setText("");
           pintf.setText("");
       }

    }catch (Exception ex){
        System.out.println(ex);
    }




}

    }
}
