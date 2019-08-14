/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * modifiied by Simarjot kaur, Komalpreet Kaur, Manisha verma, Sukhjit kaur gill
 */
public  class Card{
    private int rank;
    private int suit;
    private int value;
    
    private static String[] ranks = {"Joker","Ace","Two","Three","Four","Five",
        "Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
        Card(int suit, int values)
    {
        this.rank=values;
        this.suit=suit;
    }
   
    public String toString()
    {
        return ranks[rank]+" of "+suits[suit];
    }
    
    public int getRank()
    {
        return rank;
    }
   
    public int getSuit()
    {
        return suit;
    }
    
    public int getValue()
    {
        if(rank>10)
        {
            value=10;
        }
        else if(rank==1)
        {
            value=11;
        }
        else
        {
            value=rank;
        }
        return value;
    }
    
    public void setValue(int set)
    {
        value = set;
    }
}


    