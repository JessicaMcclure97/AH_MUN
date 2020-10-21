/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import javax.swing.JOptionPane;
/**
 *
 * @author j.mcclure
 */
public class Delegation implements Comparable<Delegation> {
   
    private String countryName;
    private int countryID;
    int totalScore; //public
    
    //constructor
    public Delegation(){
        
    }
    
    //mutators
    public void setTotalScore(int totalScore) //public access
    {
         this.totalScore = totalScore;
    }
    
    public void setCountryName(String name)
    {
        countryName = name;
    }
    
    public void setCountryID(int countryID)
    {
        this.countryID = countryID;
    }

    //accessors
    public String getcountryName()
    {
        return countryName;
    }

    public int getTotalScore()
    {
        return totalScore;
    }  
    
    //display object
    public String displayMessage()
    {
        return ""+ countryName + ": " + totalScore + "";
    }

    
    //compareTo function so as to sort the delegate array to get the total score
    public int compareTo(Delegation compareDelegation)
    {
        int compareQuantity = ((Delegation) compareDelegation).getTotalScore(); //comparing based on totalScore 
    
        //return in descending order
        return compareQuantity - this.totalScore;
    }
    
}
