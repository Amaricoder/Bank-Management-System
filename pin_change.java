package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class pin_change implements ActionListener {
    JFrame f;
    JButton change,back;
    JPasswordField tfn,tfr;
String pinno;
    pin_change( String pinno){
        this.pinno=pinno;
       f=new JFrame();

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,785,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,785);
        f.add(ima);

        JLabel text=new JLabel("CHANGE YOUR PIN ");
        text.setBounds(250,250,700,35);
        text.setFont(new Font("releway",Font.BOLD,18));
        text.setForeground(Color.white);
        ima.add(text);

        JLabel npin=new JLabel("New PIN:");
       npin.setBounds(160,300,200,30);
       npin.setFont(new Font("releway",Font.BOLD,16));
        npin.setForeground(Color.white);
        ima.add(npin);

        tfn=new JPasswordField();
        tfn.setBounds(320,300,190,30);
        tfn.setBackground(Color.white);
              ima.add(tfn);

        JLabel rpin=new JLabel(" Re-Enter New PIN:");
        rpin.setBounds(160,350,200,30);
        rpin.setFont(new Font("releway",Font.BOLD,16));
        rpin.setForeground(Color.white);
        ima.add(rpin);

        tfr=new JPasswordField();
        tfr.setBounds(320,350,190,30);
        tfr.setBackground(Color.white);
        ima.add(tfr);

        change=new JButton("Change");
        change.setBounds(378,420,130,28);
        change.addActionListener(this);

        ima.add(change);

       back=new JButton("Back");
        back.setBounds(378,450,130,28);
        back.addActionListener(this);
        ima.add(back);

        f.setLayout(null);
        f.setBounds(300,0,900,785);
        f.setUndecorated(true);
        f.setVisible(true);



    }
    public static void main(String[] args) {
new pin_change("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            f.setVisible(false);
            new atm(pinno).f.setVisible(true);
        }else {
           String new_pin=tfn.getText();
            String r_pin=tfr.getText();

            if(!new_pin.equals(r_pin)){
                JOptionPane.showMessageDialog(null,"Please re-Enter PIN");

            }else {

try{
                conn c=new conn();
String q1="update bank set pin_no='"+r_pin+"'where pin_no='"+pinno+"'";
    String q2="update login set PIN='"+r_pin+"'where PIN='"+pinno+"'";
    String q3="update signup_three set PIN_No ='"+r_pin+"'where PIN_No='"+pinno+"'";

    c.s.executeUpdate(q1);
    c.s.executeUpdate(q2);
    c.s.executeUpdate(q3);

    f.setVisible(false);
    new atm(r_pin).f.setVisible(true);

    JOptionPane.showMessageDialog(null,"Your PIN Succesfully Change");
                }catch (Exception ex){
                    System.out.println(ex);
                }

            }

        }




    }
}
