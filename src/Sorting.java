/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j.mcclure
 */
public class Sorting {
   
    
    public void bubbleSortDelegates(Delegate[] delegates, int length)
     //sorting delegates by total Score
    {
        //bubble sort from highest to lowest
       
        for(int outerloop = length ; outerloop > 0; outerloop --)
        {
            for(int counter = 0 ; counter < (outerloop - 1) ; counter ++)
            {
                if( delegates[counter].compareTo(delegates[counter + 1]) > 0) 
                {
                    //create wrapper objects of the objects in the array so that all the information in the delegaes object is swapped
                    DelegateWrapper wrapper;
                    wrapper = new DelegateWrapper(delegates[counter]);
                    DelegateWrapper wrapper2 = new DelegateWrapper(delegates[counter + 1]);
                    //swapping function
                    swap(wrapper , wrapper2);
                    
                    delegates[counter] = wrapper.d ;
                    delegates[counter + 1] = wrapper2.d ;
                    
                }
            }
        }
        
    }
 
    public void swap(DelegateWrapper dw, DelegateWrapper dw2)
    {
        Delegate temp = dw.d ; //temporarily holds the delegate values from the first parameter (a)
        dw.d = dw2.d;
        dw2.d = temp;
    }
    
        
    public void bubbleSortDelegations(Delegation[] delegations, int length)
     //sorting delegates by total Score
    {
        //bubble sort from highest to lowest
       
        for(int outerloop = length ; outerloop > 0; outerloop --)
        {
            for(int counter = 0 ; counter < (outerloop - 1) ; counter ++)
            {
                if( delegations[counter].compareTo(delegations[counter + 1]) > 0) 
                {
                    //create wrapper objects of the objects in the array so that all the information in the delegaes object is swapped
                    DelegationWrapper wrapper;
                    wrapper = new DelegationWrapper(delegations[counter]);
                    DelegationWrapper wrapper2 = new DelegationWrapper(delegations[counter + 1]);
                    //swapping function
                    swap2(wrapper , wrapper2);
                    
                    delegations[counter] = wrapper.d ;
                    delegations[counter + 1] = wrapper2.d ;
                    
                }
            }
        }
        
    }
 
    public void swap2(DelegationWrapper dw, DelegationWrapper dw2)
    {
        Delegation temp = dw.d ; //temporarily holds the delegate values from the first parameter (a)
        dw.d = dw2.d;
        dw2.d = temp;
    }   
}