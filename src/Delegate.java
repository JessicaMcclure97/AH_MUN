
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j.mcclure
 */
public class Delegate implements Comparable<Delegate>{
    //from country table
    private String countryName;
    //from delegate table
    private int age;
    int totalScore; //public
 
    //constructor
    public Delegate(){
        
    }

    //mutators
    public void setTotalScore(int delegateID) //public access
    {
        TotalScore score = new TotalScore();
        score.calculatingTotalScore(delegateID);
        totalScore = score.getTotalScore();
    }
    
    public void setCountryName(String name)
    {
        countryName = name;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }

    //accessors
    public String getcountryName()
    {
        return countryName;
    }
    public int getAge()
    {
        return age;
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
    public int compareTo(Delegate compareDelegate)
    {
        int compareQuantity = ((Delegate) compareDelegate).getTotalScore(); //comparing based on totalScore 
    
        //return in descending order
        return compareQuantity - this.totalScore;
    }
    
}
