package com.Bank_management;

import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;

    Statement s;
    public conn(){
        try{
             c= DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","Amar@1234");
s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    //psvm
}
