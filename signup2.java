package com.Bank_management;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup2 implements ActionListener {
    JFrame f;
    JTextField tfe,tfa,tfc,tfs,tfp;
    JRadioButton eab,eab1,scb,scb1;
    JComboBox religion,cato,income,edu,occu;
    JButton next;

    static String formno;
    signup2(String formno){
        this.formno=formno;
        f=new JFrame();


//additional details
        JLabel ad=new JLabel("Page 2 : Additional Details");
        ad.setFont(new Font("releway",Font.BOLD,22));
        ad.setBounds(290,20,400,30);
        f.add(ad);
        JLabel rel=new JLabel("Religion:");
        rel.setFont(new Font("releway",Font.BOLD,20));
        rel.setBounds(100,90,100,30);
        f.add(rel);
        //
        String vr[]={"hindu","Muslim","Shikh","Other"};
        religion=new JComboBox<>(vr);
        religion.setBounds(300,90,400,30);
        religion.setBackground(Color.white);
f.add(religion);
        //Catt
        JLabel cat=new JLabel("Category:");
        cat.setFont(new Font("releway",Font.BOLD,20));
        cat.setBounds(100,150,100,30);
        f.add(cat);

        String c[]={"Gen","OBC","sc","other"};
     cato=new JComboBox<>(c);
     cato.setBackground(Color.white);
        cato.setBounds(300,150,400,30);
        f.add(cato);


//income
        JLabel in=new JLabel("Income:");
        in.setFont(new Font("releway",Font.BOLD,20));
        in.setBounds(100,210,200,30);
        f.add(in);

        String i[]={">1,00,000",">5,00,000","upto 10,00,000"};
        income =new JComboBox<>(i);
        income.setBackground(Color.white);
        income.setBounds(300,210,400,30);
        f.add(income);

        //eq
        JLabel eq=new JLabel("Educational ");
        eq.setFont(new Font("releway",Font.BOLD,20));
        eq.setBounds(100,270,200,30);
        f.add(eq);
        JLabel q=new JLabel("Qulificatinal ");
        q.setFont(new Font("releway",Font.BOLD,20));
        q.setBounds(100,290,200,30);
        f.add(q);


        String ve[]={"Non-Graduation","Graduate","post Graduate","others"};
        edu=new JComboBox(ve);
        edu.setBounds(300,280,400,30);
        edu.setBackground(Color.white);
        f.add(edu);

        //occupation
        JLabel oc=new JLabel("Occupation:");
        oc.setFont(new Font("releway",Font.BOLD,20));
        oc.setBounds(100,330,200,30);
        f.add(oc);
        //redio button
        String vo[]={"Salaried","Self employed","Bussinessman","others"};
   occu=new JComboBox<>(vo);
        occu.setBounds(300,330,400,30);
        occu.setBackground(Color.white);
        f.add(occu);


        //pan no.
        JLabel pan=new JLabel("Pan Number:");
        pan.setFont(new Font("releway",Font.BOLD,20));
  pan.setBounds(100,390,200,30);
        f.add(pan);


        tfp=new JTextField();
        tfp.setFont(new Font("releway",Font.PLAIN,16));
        tfp.setBounds(300,390,400,30);
        f.add(tfp);


        //addhar
        JLabel adhar=new JLabel("Aadhar Number:");
        adhar.setFont(new Font("releway",Font.BOLD,20));
        adhar.setBounds(100,450,200,30);
        f.add(adhar);

        tfa=new JTextField();
        tfa.setFont(new Font("releway",Font.PLAIN,16));
        tfa.setBounds(300,450,400,30);
        f.add(tfa);



        JLabel sc=new JLabel("Senior citizen:");
        sc.setFont(new Font("releway",Font.BOLD,20));
sc.setBounds(100,510,200,30);
        f.add(sc);

      scb=new JRadioButton("Yes");
        scb.setBackground(Color.white);
        scb.setBounds(300,510,150,30);
        f.add(scb);

   scb1=new JRadioButton("No");
        scb1.setBackground(Color.white);
        scb1.setBounds(450,510,150,30);
        f.add(scb1);

ButtonGroup b1=new ButtonGroup();
b1.add(scb);
b1.add(scb1);

        JLabel ea=new JLabel("Exisiting Account:");
        ea.setFont(new Font("releway",Font.BOLD,20));
        ea.setBounds(100,570,200,30);
        f.add(ea);

         eab=new JRadioButton("Yes");
        eab.setBackground(Color.white);
        eab.setBounds(300,570,150,30);
        f.add(eab);

 eab1=new JRadioButton("No");
        eab1.setBackground(Color.white);
        eab1.setBounds(450,570,150,30);
        f.add(eab1);

ButtonGroup b2=new ButtonGroup();
b2.add(eab);
b2.add(eab1);

        //next
        next=new JButton("Next");
        next.setBounds(600,630,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        f.add(next);

        f.setLayout(null);
        f.setBounds(350,10,850,800);
        f.getContentPane().setBackground(Color.white);
        f.setVisible(true);


    }

    public static void main(String[] args) {
        new signup2(formno);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String s_rel=(String) religion.getSelectedItem();
        String s_cat=(String) cato.getSelectedItem();
        String s_inc= (String) income.getSelectedItem();
        String s_edu=(String )edu.getSelectedItem();
        String s_occu=(String) occu.getSelectedItem();
        String s_pan=tfp.getText();
        String s_addhar=tfa.getText();

        String sinior=null;
        if(scb.isSelected()){
            sinior="yes";
        } else if (scb1.isSelected()) {
            sinior="No";
        }

        String Existing_ac=null;
        if(eab.isSelected()){
            Existing_ac="yes";
        } else if (eab1.isSelected()) {
            Existing_ac="No";
        }

        try{
           conn con=new conn();
           String query="insert into signup2 values('"+formno+"','"+s_rel+"','"+s_cat+"','"+s_inc+"','"+s_edu+"','"+s_occu+"','"+s_pan+"','"+s_addhar+"','"+sinior+"','"+Existing_ac+"')";
con.s.executeUpdate(query);
f.setVisible(false);
new signup3(formno).f.setVisible(true);


        }catch (Exception ex){
            System.out.println(ex);
        }

    }
}
