package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance_inq implements ActionListener {
    JFrame f;
    JButton back;
    static  int bal;
    String pinno;
    balance_inq(String pinno){
        this.pinno=pinno;
        f=new JFrame();
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,785,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,785);
        f.add(ima);


        back=new JButton("Back");
        back.setBounds(378,450,130,28);
        back.addActionListener(this);
        ima.add(back);


        conn c=new conn();
         bal=0;
try{
        ResultSet rs=c.s.executeQuery("select * from bank where pin_no='"+pinno+"'");


    while (rs.next()){
            if(rs.getString("type").equals("Deposit")){
                bal=bal+Integer.parseInt(rs.getString("amount"));
            } else {
                bal =bal- Integer.parseInt(rs.getString("amount"));
            }

        }
}catch (Exception e){
    System.out.println(e);
        }
        JLabel l=new JLabel("Your Current Balance is Rs : " +bal);
        l.setForeground(Color.white);
        l.setBounds(170,280,400,30);
        ima.add(l);


        f.setLayout(null);
        f.setBounds(300,0,900,785);
        f.setUndecorated(true);
        f.setVisible(true);

    }
    public static void main(String[] args) {
        new balance_inq("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible(false);
        new atm(pinno).f.setVisible(true);
    }
}
