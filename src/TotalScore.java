
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class TotalScore {
    Connection connection;
    Statement state; //insert 
    
    ResultSet rs_votingForm = null; //select
    PreparedStatement ps_votingForm = null; //select
    
    ResultSet rs_timer = null; //select
    PreparedStatement ps_timer = null; //select
    
    ResultSet rs_humour = null; //select
    PreparedStatement ps_humour = null; //select
     
    int totalScore;
    int humour;
    
    public TotalScore()
    {
        //connect to database
        connectToDatabase Test = new connectToDatabase();
        Test.connectToDatabase();
        //update connection variable
        connection = Test.getConnectionVariable(connection);
    }
    
    public void calculatingTotalScore(int delegateID)
    {
        //querey statements held in variables
        String querey_votingForm = "SELECT `quailityScore`,`humourScore`,`abilityPOIScore`,`instagateDebate` FROM `voting` WHERE `delegateID` = " +delegateID + "";
        String querey_timer = "SELECT `delegateID`, SUM(`timeSpoken`) As totalTime FROM `timer`  WHERE `delegateID` = " +delegateID+ " GROUP BY `delegateID`"; 
        
        //local variables 
        int quailityScore = 0, humourScore = 0, abilityPOIScore = 0, instagateDebate = 0, timer = 0;
        
        //retrieving data from database
        try{
            ps_votingForm = connection.prepareStatement(querey_votingForm);
            rs_votingForm = ps_votingForm.executeQuery();
            
            ps_timer = connection.prepareStatement(querey_timer);
            rs_timer = ps_timer.executeQuery();

            while (rs_votingForm.next()) {
                //running total used so no group by statement required in SQL statement
                quailityScore = rs_votingForm.getInt("quailityScore") + quailityScore;
                humourScore = rs_votingForm.getInt("humourScore") + humourScore;
                abilityPOIScore = rs_votingForm.getInt("abilityPOIScore") + abilityPOIScore;
                instagateDebate = rs_votingForm.getInt("instagateDebate") + instagateDebate;
            }
            
            while (rs_timer.next()) {
                // group by statement so no running total required in SQL statement
                timer = rs_timer.getInt("totalTime");
            }
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        totalScore = (2*quailityScore) + humourScore + (2*abilityPOIScore) + instagateDebate + timer ; //the quality and ablitiyPOI scores are 
        //multiplied since they are more desirable qualities and therefore should hold more weight in the total score calcuated
        
        //update totalScore into the database delegate table
         try{
            Statement state=(Statement)connection.createStatement();
            String sql_totalScore = "UPDATE `delegate` SET `totalScore`= "+ totalScore +" WHERE `delegateID`="+ delegateID+"";
            state.executeUpdate(sql_totalScore);
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    //getter since totalScore variable is private
    public int getTotalScore()
    {
        return this.totalScore;
    }

}
