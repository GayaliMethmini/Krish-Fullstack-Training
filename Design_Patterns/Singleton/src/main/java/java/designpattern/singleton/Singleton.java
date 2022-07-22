package java.designpattern.singleton;

import java.sql.Connection;

public class Singleton {
     public static void main(String[] args) {
        // TODO code application logic here
        long start;
        long end;
        
        DBManager dbManager = DBManager.getDBmanager();
        System.out.println(dbManager);
        
        start=System.currentTimeMillis();
        Connection connection = dbManager.getConnection();
        end=System.currentTimeMillis();
        
        System.out.println(end-start);
        
        DBManager dbManager1= DBManager.getDBmanager();
        System.out.println(dbManager1);
        start=System.currentTimeMillis();
        Connection connection1 = dbManager1.getConnection();
        end=System.currentTimeMillis();
        System.out.println(end-start);
       
    }
    
}
