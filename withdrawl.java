package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawl implements ActionListener {
    JFrame f;
    JTextField tfw;
    JButton withdraw,back;
    String pin_num;
    withdrawl(String pin_num){
        this.pin_num=pin_num;
        f=new JFrame();

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,785,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,785);
        f.add(ima);

        JLabel text=new JLabel("Enter Your amount ");
        text.setBounds(250,250,700,35);
        text.setFont(new Font("releway",Font.BOLD,16));
        text.setForeground(Color.white);
        ima.add(text);



        tfw=new JTextField();
        tfw.setBounds(165,300,330,25);
        tfw.setFont(new Font("releway",Font.BOLD,14));
        tfw.setBackground(Color.white);
        ima.add(tfw);

        withdraw=new JButton("withdraw");
        withdraw.setBounds(355,420,150,28);
        withdraw.addActionListener(this);
        ima.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,450,150,28);
        back.addActionListener(this);
        ima.add(back);

        f.setLayout(null);
        f.setBounds(300,0,900,785);
        f.setUndecorated(true);
        f.setVisible(true);

    }

    public static void main(String[] args) {

        new withdrawl("");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            f.setVisible(false);
            new atm(pin_num).f.setVisible(true);

        } else if (e.getSource()==withdraw) {
            String amount=tfw.getText();
            Date date=new Date();
            if(amount.equals("")){

                JOptionPane.showMessageDialog(null,"Please enter your amount");

            }else {
                conn c=new conn();
                String q="insert into bank values('"+pin_num+"','"+amount+"','withdraw','"+date+"')";

                try{
                    //


                    c.s.executeUpdate(q);
                   JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdraw successfully");
                   new atm(pin_num).f.setVisible(true);

                }catch (Exception ex){
                    System.out.println(ex);
                }



            }

        }


    }
}
