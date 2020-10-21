
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j.mcclure
 */
public class connectToDatabase {
    Connection connection;
    //method
    public void connectToDatabase(){ 
        
    
     try{
            connection = null;
            //db parameters
            String url = "jdbc:mysql://localhost:3306/modelunitednations"; //last section in URL shows which table is being connected to
            String db_username = "root";
            String db_password = "";

            //create a connection
            connection = DriverManager.getConnection(url, db_username, db_password);
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if(connection == null)
                {
                    connection.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnectionVariable(Connection conncetion ){ 
        this.connection = connection;
        return connection;
    }
            
    
}
