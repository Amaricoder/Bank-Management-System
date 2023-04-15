package com.Bank_management;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini_statement implements ActionListener {

    JFrame f;
    String pinno;
    mini_statement(String pinno){
        this.pinno=pinno;
      f=new JFrame();

      JLabel l=new JLabel("INDIAN BANK");
      l.setBounds(150,10,100,30);
      f.add(l);

      JLabel card=new JLabel();
      card.setBounds(20,70,300,20);
      f.add(card);

      JLabel mini=new JLabel("");
        mini.setBounds(20,130,300,200);

      f.add(mini);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from login where PIN='"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("card_no"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from bank where Pin_no='"+pinno+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("Amount")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"<br><br><br>"+"<html>");

            }



        }catch (Exception e){
            System.out.println(e);
        }



      f.setLayout(null);
      f.setBounds(20,80,400,500);
      f.setUndecorated(true);
      f.setVisible(true);




    }

    public static void main(String[] args) {
new mini_statement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
