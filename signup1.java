package com.Bank_management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup1 implements ActionListener {
    JFrame f;
    JTextField tfn,tff,tfe,tfa,tfc,tfs,tfp;
    JRadioButton male,female,married,unmarried,others;
    JButton next;
    JDateChooser dc;
    long random;
    signup1(){
     f=new JFrame();
        Random ran=new Random();
         random=( Math.abs   (ran.nextLong()%9000L)+1000L);

       JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
formno.setFont(new Font("releway",Font.BOLD,38));
formno.setBounds(140,20,600,40);
f.add(formno);

//personal details
        JLabel pd=new JLabel("Page 1 : Personal Details");
        pd.setFont(new Font("releway",Font.BOLD,22));
        pd.setBounds(290,80,400,30);
        f.add(pd);
        //name
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("releway",Font.BOLD,20));
       name.setBounds(100,140,100,30);
        f.add(name);

        //tf name
         tfn=new JTextField();
        tfn.setFont(new Font("releway",Font.PLAIN,16));
        tfn.setBounds(300,140,400,30);
        f.add(tfn);


//father name
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("releway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        f.add(fname);

        //tf father
         tff=new JTextField();
        tff.setFont(new Font("releway",Font.PLAIN,16));
        tff.setBounds(300,190,400,30);
        f.add(tff);

        //Date of birth
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("releway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        f.add(dob);
        //calender
     dc=new JDateChooser();
        dc.setBounds(300,240,400,30);
f.add(dc);


        //gender
        JLabel gen=new JLabel("Gender:");
        gen.setFont(new Font("releway",Font.BOLD,20));
        gen.setBounds(100,290,200,30);
        f.add(gen);
        //redio button
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);

        f.add(male);
        female=new JRadioButton("Female");
female.setBounds(450,290,120,30);
female.setBackground(Color.white);
f.add(female);
//button group
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);


        //email
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("releway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        f.add(email);
        //email testfield

         tfe=new JTextField();
        tfe.setFont(new Font("releway",Font.PLAIN,16));
        tfe.setBounds(300,340,400,30);
        f.add(tfe);


        //marital
        JLabel ms=new JLabel("Marital Status:");
        ms.setFont(new Font("releway",Font.BOLD,20));
        ms.setBounds(100,390,200,30);
        f.add(ms);
        //marraied
         married=new JRadioButton("married");
        married.setBackground(Color.white);
        married.setBounds(300,390,120,30);
        f.add(married);
        //unmarried
        unmarried=new JRadioButton("unmarried");
        unmarried.setBounds(450,390,120,30);
      unmarried.setBackground(Color.white);
        f.add(unmarried);
        //transgender
        others=new JRadioButton("other");
        others.setBounds(630,390,120,30);
        others.setBackground(Color.white);
        f.add(others);

        //button group
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(married);
        bg1.add(unmarried);
bg1.add(others);
        //address

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("releway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        f.add(address);
        //address testfield

       tfa=new JTextField();
        tfa.setFont(new Font("releway",Font.PLAIN,16));
        tfa.setBounds(300,440,400,30);
        f.add(tfa);



        //city
        JLabel city=new JLabel("City:");
        city.setFont(new Font("releway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        f.add(city);

        //textfield city

         tfc=new JTextField();
        tfc.setFont(new Font("releway",Font.PLAIN,16));
        tfc.setBounds(300,490,400,30);
        f.add(tfc);

//state

        JLabel state=new JLabel("State:");
        state.setFont(new Font("releway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        f.add(state);
        //tf

      tfs=new JTextField();
        tfs.setFont(new Font("releway",Font.PLAIN,16));
        tfs.setBounds(300,540,400,30);
        f.add(tfs);

        //pincode
        JLabel pincode=new JLabel("Pin code:");
        pincode.setFont(new Font("releway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        f.add(pincode);
        //tf

     tfp=new JTextField();
        tfp.setFont(new Font("releway",Font.PLAIN,16));
        tfp.setBounds(300,590,400,30);
        f.add(tfp);

        //next
      next=new JButton("Next");
        next.setBounds(600,640,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
f.add(next);

f.setLayout(null);
     f.setBounds(350,10,850,800);
     f.getContentPane().setBackground(Color.white);
     f.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
String formno=""+random;
String name= tfn.getText();
String fname=tff.getText();
String dob= ((JTextField) dc.getDateEditor().getUiComponent()).getText();
String email=tfe.getText();
String pin=tfp.getText();
String  address=tfa.getText();
String state=tfs.getText();
String city=tfc.getText();

String gender=null;
if(male.isSelected()){
    gender="male";
} else if (female.isSelected()) {
    gender="female";
}

String marital=null;

if(married.isSelected()){
     marital="married";
} else if (unmarried.isSelected()) {
 marital="unmarried";
} else if (others.isSelected()) {
     marital="others";
}
try {

       conn co=new conn();
       String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+state+"','"+city+"','"+pin+"')";
       co.s.executeUpdate(query);
f.setVisible(false);
new signup2(formno).f.setVisible(true);


} catch (Exception ex){
    System.out.println(ex);
}



    }

    public static void main(String[] args) {
        new signup1();
    }
    }

