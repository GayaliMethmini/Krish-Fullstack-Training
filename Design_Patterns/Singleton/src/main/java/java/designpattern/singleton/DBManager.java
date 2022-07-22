package java.designpattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    
    private static volatile DBManager dbManager ;//= new DBManager();
    private static volatile Connection connection;
    
    private DBManager(){
    
        if(dbManager != null){
    
            throw new RuntimeException("please use getDBManager method");
        }
    }
    
    public static DBManager getDBmanager(){
    
        if(dbManager == null){
          synchronized(DBManager.class){
              
              if(dbManager == null){
            dbManager = new DBManager();
              }
          }
        
        }
        
        return dbManager;
    }
    
    
    public Connection getConnection(){
        
        
        if(connection == null){
        
                synchronized(DBManager.class){
                
                    if(connection == null){
                    
                        String url="jdbc:mysql://localhost/sample?" + "user=root&password=root";
                        try{
                        connection=DriverManager.getConnection(url);  
                        }catch(SQLException e){
                        
                            e.printStackTrace();
                        }
                        
                    }
                }
        
        
        }
    
        return connection;
    
    }
}
