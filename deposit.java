package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class deposit implements ActionListener {
    JFrame f;
    JTextField tfd;
    JButton dep,back;
    static String pinno;
    deposit(String pinno){
        this.pinno=pinno;
        f=new JFrame();

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,785,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,900,785);
        f.add(ima);

        JLabel text=new JLabel("Enter the amount you you want to deposite");
        text.setBounds(170,250,700,35);
        text.setFont(new Font("releway",Font.BOLD,16));
        text.setForeground(Color.white);
        ima.add(text);



        tfd=new JTextField();
        tfd.setBounds(165,300,330,25);
        tfd.setFont(new Font("releway",Font.BOLD,14));
        tfd.setBackground(Color.white);
        ima.add(tfd);

        dep=new JButton("Deposit");
        dep.setBounds(355,420,150,28);
        dep.addActionListener(this);
        ima.add(dep);

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

        new deposit("");


    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==back){
    f.setVisible(false);
    new atm(pinno).f.setVisible(true);

} else if (e.getSource()==dep) {
    String amount=tfd.getText();
    Date date=new Date();
    if(amount.equals("")){

        JOptionPane.showMessageDialog(null,"Please enter your amount");

    }else {
        conn c=new conn();
        String q="insert into bank values('"+pinno+"','"+amount+"','Deposit','"+date+"')";

        try{

            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Rs "+amount+" Deposit succesfully");
new atm(pinno).f.setVisible(true);

        }catch (Exception ex){
            System.out.println(ex);
        }



    }

}


    }
}
