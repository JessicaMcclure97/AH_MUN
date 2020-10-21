
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j.mcclure
 */
public class NumberCountries {
    //global variables for connection of database
    Connection connection;
    ResultSet rs;
    PreparedStatement ps;
    
    public int NumberCountries(int committeeID)
    { 
        //connect to database
        connectToDatabase Test = new connectToDatabase();
        Test.connectToDatabase();
        //update connection variable
        connection = Test.getConnectionVariable(connection); 
        
        int numberOfCountries = 0;
        
        try{
          
            String count = "SELECT COUNT(`delegateID`) AS count FROM `delegate` WHERE `committeeID` = " + committeeID+ ""; 
            ps = connection.prepareStatement(count);
            rs = ps.executeQuery();

            while (rs.next()) {
                numberOfCountries = rs.getInt("count");
             } 
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return numberOfCountries;
    }
}
