package com.Bank_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class fast_cash implements ActionListener {
    JFrame f;
    JButton b100,b500,b1000,b2000,b5000,b10000,back;
    String pinno;
    fast_cash(String pinno){
        this.pinno=pinno;
        f=new JFrame();
        f.setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon2/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,785,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel ima=new JLabel(i3);
        ima.setBounds(0,0,800,785);
        f.add(ima);



        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(200,260,700,35);
        text.setFont(new Font("releway",Font.BOLD,16));
        text.setForeground(Color.white);
        ima.add(text);

        b100=new JButton("Rs 100");
        b100.setBounds(145,360,130,28);
        b100.addActionListener(this);
        ima.add(b100);

        b500=new JButton("Rs 500");
        b500.setBounds(325,360,130,28);
        b500.addActionListener(this);
        ima.add(b500);

        b1000=new JButton("Rs 1000");
        b1000.setBounds(145,390,130,28);
        b1000.addActionListener(this);
        ima.add(b1000);

        b2000=new JButton("Rs 2000");
        b2000.setBounds(325,390,130,28);
        b2000.addActionListener(this);

        ima.add(b2000);

       b5000=new JButton("Rs 5000");
      b5000.setBounds(145,420,130,28);
        b5000.addActionListener(this);

        ima.add(b5000);

        b10000=new JButton("Rs 10000");
        b10000.setBounds(325,420,130,28);
        b10000.addActionListener(this);

        ima.add(b10000);

        back=new JButton("Back");
        back.setBounds(325,450,130,28);
        back.addActionListener(this);
        ima.add(back);



        f.setBounds(300,0,800,785);
        f.setUndecorated(true);
        f.setVisible(true);



    }
    public static void main(String[] args) {

        new fast_cash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==back){
    f.setVisible(false);
    new atm(pinno).f.setVisible(true);
} else  {
String am=((JButton)e.getSource()).getText().substring(3);
conn c=new conn();

    try {

        ResultSet rs=c.s.executeQuery("select * from bank where pin_no='"+pinno+"'");
int bal=0;
while (rs.next()){
    if(rs.getString("type").equals("Deposit")){
        bal+=Integer.parseInt(rs.getString("amount"));

    }else {
        bal-=Integer.parseInt(rs.getString("amount"));
    }

}

if(e.getSource()!=back && bal<Integer.parseInt(am)){
    JOptionPane.showMessageDialog(null,"Insufficient Balence");
    return;
}else {
        Date date=new Date();
    String q="insert into bank values('"+pinno+"','"+am+"','fast_withdraw','"+date+"')";
c.s.executeUpdate(q);
JOptionPane.showMessageDialog(null,"Rs "+am+" Debited Sucessfully");
f.setVisible(false);
new atm(pinno).f.setVisible(true);

}
    }catch (Exception ex){
        System.out.println(ex);
    }


}


    }
}
