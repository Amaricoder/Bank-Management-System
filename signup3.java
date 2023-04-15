package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 implements ActionListener {
JFrame f;
JRadioButton r1,r2,r3,r4;
JCheckBox c1,c2,c3,c4,c5,c6,c7;
JButton submit,cancel;
 String formno;
String pin;

    signup3(String formno){
            this.formno=formno;
         f=new JFrame();
        JLabel ad=new JLabel("Page 3 : Account Details");
        ad.setFont(new Font("releway",Font.BOLD,22));
        ad.setBounds(280,40,400,30);
        f.add(ad);


        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("releway",Font.BOLD,22));
        type.setBounds(100,100,200,30);
        f.add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("releway",Font.BOLD,16));
r1.setBackground(Color.white);
r1.setBounds(100,140,250,20);
f.add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("releway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,140,250,20);
        f.add(r2);
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("releway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,180,250,20);
        f.add(r3);

        r4=new JRadioButton("Recurring Account");
        r4.setFont(new Font("releway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,180,250,20);
        f.add(r4);

        ButtonGroup b=new ButtonGroup();
        b.add(r1);
        b.add(r2);
        b.add(r3);
        b.add(r4);

        JLabel cn=new JLabel("Card Number");
        cn.setFont(new Font("releway",Font.BOLD,22));
        cn.setBounds(100,240,200,30);
        f.add(cn);

        JLabel n=new JLabel("XXXX-XXXX-XXXX-4512");
        n.setFont(new Font("releway",Font.BOLD,22));
        n.setBounds(300,240,300,30);
        f.add(n);


        JLabel det=new JLabel("Your 16 Digit Card Number");
        det.setFont(new Font("releway",Font.BOLD,12));
        det.setBounds(100,270,300,20);
        f.add(det);


        JLabel pn=new JLabel("PIN Number");
        pn.setFont(new Font("releway",Font.BOLD,22));
        pn.setBounds(100,330,200,30);
        f.add(pn);

        JLabel pno=new JLabel("XXXX");
        pno.setFont(new Font("releway",Font.BOLD,22));
        pno.setBounds(300,330,300,30);
        f.add(pno);

        JLabel det1=new JLabel("Your 4 Digit PIN Number");
        det1.setFont(new Font("releway",Font.BOLD,12));
        det1.setBounds(100,360,300,20);
        f.add(det1);

        JLabel ser=new JLabel("Services Required");
        ser.setFont(new Font("releway",Font.BOLD,22));
        ser.setBounds(100,410,200,30);
        f.add(ser);


        c1=new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("releway",Font.BOLD,16));
        c1.setBounds(100,460,200,30);
f.add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("releway",Font.BOLD,16));
        c2.setBounds(350,460,200,30);
f.add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("releway",Font.BOLD,16));
        c3.setBounds(100,510,200,30);
f.add(c3);
        c4=new JCheckBox("Email & SMS Alerts ");
        c4.setBackground(Color.white);
        c4.setFont(new Font("releway",Font.BOLD,16));
        c4.setBounds(350,510,200,30);
        f.add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("releway",Font.BOLD,16));
        c5.setBounds(100,560,200,30);
        f.add(c5);

        c6=new JCheckBox("E-Statement ");
        c6.setBackground(Color.white);
        c6.setFont(new Font("releway",Font.BOLD,16));
        c6.setBounds(350,560,200,30);
        f.add(c6);
        c7=new JCheckBox("I hereby declare that the line above entered details are corect  ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("releway",Font.BOLD,12));
        c7.setBounds(100,600,800,30);
        f.add(c7);

        submit =new JButton("Submit");
        submit.setBounds(220,660,100,30);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Releway",Font.BOLD,14));
        submit.addActionListener(this);
        submit.setForeground(Color.white);
f.add(submit);

            cancel =new JButton("Cancel");
            cancel.setBounds(420,660,100,30);
            cancel.setBackground(Color.BLACK);
           cancel.setFont(new Font("Releway",Font.BOLD,14));
           cancel.addActionListener(this);
            cancel.setForeground(Color.white);
            f.add(cancel);


        f.setLayout(null);
        f.setBounds(350,0,850,800);
        f.getContentPane().setBackground(Color.white);
        f.setUndecorated(true);
        f.setVisible(true);

    }
    public static void main(String[] args) {

         new signup3("");


    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==submit) {
                    String ac_type = null;
                    if (r1.isSelected()) {
                            ac_type = "saving Account";
                    } else if (r2.isSelected()) {
                            ac_type = "Fixed deposit account";

                    } else if (r3.isSelected()) {
                            ac_type = "current Account";

                    } else if (r4.isSelected()) {

                            ac_type = "Reccuring Account";
                    }

                    ///card no generate

                    Random random = new Random();
                    String cardno = "" + Math.abs((random.nextLong() % 9000000L) + 504293600000000L);
                     pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
//sevices

                    String services = "";
                    if (c1.isSelected()) {
                            services = services + "  ATM Card";
                    } else if (c2.isSelected()) {
                            services = services + "  Internet Banking";
                    } else if (c3.isSelected()) {
                            services = services + "  Mobile Banking";

                    } else if (c4.isSelected()) {
                            services = services + "  Email & SMS Alert";

                    } else if (c5.isSelected()) {
                            services = services + "  cheque Book";

                    } else if (c6.isSelected()) {
                            services = services + "  E-Statement";
                    }


                    try {
if(ac_type.equals("")){
        JOptionPane.showMessageDialog(null,"account type is requered");

}else {
        conn c1 = new conn();
        String q = "insert into signup_three values('" + formno + "','" + ac_type + "','" + cardno + "','" + pin + "','" + services + "')";
        String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";


        c1.s.executeUpdate(q);
        c1.s.executeUpdate(q2);
        f.setVisible(false);
        JOptionPane.showMessageDialog(null, "card no: " + cardno + "\n PIN no :  " + pin);

        f.setVisible(false);
        new deposit(pin).f.setVisible(true);

}
                    } catch (Exception ex) {
                            System.out.println(ex);
                    }

            } else if (e.getSource()==cancel) {
                  f.setVisible(false);
                  new bank(pin).f.setVisible(true);
            }


        }
}
