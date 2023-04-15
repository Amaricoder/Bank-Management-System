package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class atm implements ActionListener {
    JFrame f;
    JButton dep,with ,fc,mini,pin_change,be,exit;
    String pin;
    atm(String pin){
        this.pin=pin;
         f=new JFrame();
        f.setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,785,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,800,785);
        f.add(ima);



        JLabel text=new JLabel("Please Select Your Transation");
        text.setBounds(200,260,700,35);
        text.setFont(new Font("releway",Font.BOLD,16));
        text.setForeground(Color.white);
        ima.add(text);

        dep=new JButton("Deposit");
        dep.setBounds(145,360,130,28);
        dep.addActionListener(this);
ima.add(dep);

        with=new JButton("Cash withdrawl");
        with.setBounds(325,360,130,28);
        with.addActionListener(this);
        ima.add(with);

        fc=new JButton("Fast Cash");
        fc.setBounds(145,390,130,28);
        fc.addActionListener(this);
        ima.add(fc);

        mini=new JButton("Mini Statement");
        mini.setBounds(325,390,130,28);
        mini.addActionListener(this);
        ima.add(mini);

        pin_change=new JButton("Pin Change");
        pin_change.setBounds(145,420,130,28);
        pin_change.addActionListener(this);
        ima.add(pin_change);

        be=new JButton("Balance Enquiry");
        be.setBounds(325,420,130,28);
        be.addActionListener(this);
        ima.add(be);

        exit=new JButton("Exit");
        exit.setBounds(325,450,130,28);
        exit.addActionListener(this);
        ima.add(exit);



         f.setBounds(300,0,800,785);
f.setUndecorated(true);
f.setVisible(true);



    }
    public static void main(String[] args) {

        new atm("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        } else if (e.getSource()==dep) {
            f.setVisible(false);
            new deposit(pin).f.setVisible(true);
        } else if (e.getSource()==with) {
            f.setVisible(false);
            new withdrawl(pin).f.setVisible(true);
        } else if (e.getSource()==fc) {
            f.setVisible(false);
            new fast_cash(pin).f.setVisible(true);

        } else if (e.getSource()==pin_change) {
            f.setVisible(false);
            new pin_change(pin).f.setVisible(true);
        } else if (e.getSource()==be) {
            f.setVisible(false);
            new balance_inq(pin).f.setVisible(true);
        }else if (e.getSource()==mini) {
            f.setVisible(false);
            new mini_statement(pin).f.setVisible(true);
        }


    }
}
