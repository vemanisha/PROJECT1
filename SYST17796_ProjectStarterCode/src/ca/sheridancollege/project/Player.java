/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, 
 * which should be unique.
 * @author dancye, 2018
 * modifiied by Simarjot kaur, Komalpreet Kaur, Manisha verma, Sukhjit kaur gill
 */
import java.util.*;
public class Player 
{
    
 private static int cash;//cash the user bets with
    private static int bet;//how much the user wants to bet
    private static int AceCounter;//how many aces are in the user's hand
    private static ArrayList<Card> hand;//represents the user's hand
    private static int handvalue;//the value of the user's hand
    private static String name;//name of the user
    public static void main(String[] args){
        System.out.println("Hi! What is your name?");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        System.out.println("Hello, "+name+"How much cash do you want to start "
                + "with?");
       
        Scanner money = new Scanner(System.in);
        cash = money.nextInt();
        System.out.println("You start with cash: "+cash);
        while(cash>0){
            Game deck = new Game();
            deck.shuffle();
            AceCounter=0;
            GroupOfCards dealer = new GroupOfCards(deck);
            List<Card> hand = new ArrayList<>();
            hand.add(deck.drawCard());
            hand.add(deck.drawCard());
            System.out.println("How much would you like to bet?");
            bet=Bet(cash);
            System.out.println("Cash:"+(cash-bet));
            System.out.println("Money on the table:"+bet);
            System.out.println("Here is your hand: ");
            System.out.println(hand);
            int handvalue = calcHandValue(hand);
            System.out.println("The dealer is showing: ");
            dealer.showFirstCard();
            if(hasBlackJack(handvalue) && dealer.hasBlackJack())
            {
                Push();
            }
            else if(hasBlackJack(handvalue))
            {
                System.out.println("You have BlackJack!");
                System.out.println("Congrats,you win double the money!!!");
                cash=cash+bet;
                Win();
            }
            else if(dealer.hasBlackJack())
            {
                System.out.println("Here is the dealer's hand:");
                dealer.showHand();
                Lose();
            }
            else
            {
                if(2*bet<cash)
                {
                    System.out.println("Would you like to double down?");
                    Scanner doubledown = new Scanner(System.in);
                    String doubled = doubledown.nextLine();
                    while(!isyesorno(doubled))
                    {
                        System.out.println("Please enter yes or no.");
                        doubled = doubledown.nextLine();
                    }
                    if(doubled.equals("yes"))
                    {
                        System.out.println("You have opted to double down!");
                        bet=2*bet;
                        System.out.println("Cash:"+(cash-bet));
                        System.out.println("Money on the table:"+bet);
                    }
                }
                System.out.println("Hit or stand?");
                Scanner hitorstand = new Scanner(System.in);
                String hitter = hitorstand.nextLine();
                while(!isHitorStand(hitter))
                {
                    System.out.println("Enter 'hit' or 'stand'.");
                    hitter = hitorstand.nextLine();
                }
                while(hitter.equals("hit"))
                {
                    Hit(deck, hand);
                    System.out.println("Your hand is now:");
                    System.out.println(hand);
                    handvalue = calcHandValue(hand);
                    if(checkBust(handvalue))
                    {
                        Lose();
                        break;
                    }
                    if(handvalue<=21 && hand.size()==5)
                    {
                        fivecardtrick();
                        break;
                    }
                    System.out.println("Would you like to hit or stand?");
                    hitter = hitorstand.nextLine();
                }
                if(hitter.equals("stand"))
                {
                    int dealerhand = dealer.takeTurn(deck);
                    System.out.println("");
                    System.out.println("Here is the dealer's hand:");
                    dealer.showHand();
                    if(dealerhand>21)
                    {
                        Win();
                    }
                    else
                    {
                        int you = 21-handvalue;
                        int deal = 21-dealerhand;
                        if(you==deal)
                        {
                            Push();
                        }
                        if(you<deal)
                        {
                            Win();
                        }
                        if(deal<you)
                        {
                            Lose();
                        }
                    }
                }
            }
            System.out.println("Would you like to play again?");
            Scanner yesorno = new Scanner(System.in);
            String answer = yesorno.nextLine();
            while(!isyesorno(answer))
            {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();
            }
            if(answer.equals("no"))
            {
                break;
            }
        }
        System.out.println("Your cash is: "+cash);
        if(cash==0)
        {
            System.out.println("You ran out of cash!");
        }
        else
        {
            System.out.println("Enjoy your winnings, "+name+"!");
        }
    }
    
    public static boolean hasBlackJack(int handValue)
    {
        if(handValue==21)
        {
            
            return true;
        }
        return false;
    }
    
    public static int calcHandValue(List<Card> hand)
    {
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        int handValuee=0;
     for (Card aHand1 : aHand) {
         handValuee += aHand1.getValue();
         if (aHand1.getValue() == 11) {
             AceCounter++;
         }
         while(AceCounter>0 && handValuee>21)
         {
             handValuee-=10;
             AceCounter--;
         }
     }
        return handValuee;
    }
   
    public static int Bet(int cash)
    {
        Scanner sc=new Scanner(System.in);
        int bet=sc.nextInt();
        while(bet>cash)
        {
            System.out.println("You cannot bet more cash than you have!");
            System.out.println("How much would you like to bet?");
            bet=sc.nextInt();
        }
        return bet;
    }
    
    public static void Win()
    {
        System.out.println("Congratulations, you win!");
        cash=cash+bet;
        System.out.println("Cash: "+cash);
    }
   
    public static void Lose()
    {
        System.out.println("Sorry, you lose!");
        cash=cash-bet;
        System.out.println("Cash: "+cash);
    }
   
    public static void Push()
    {
      
        System.out.println("You get your money back as it is a push.");
        System.out.println("Cash: "+cash);
    }
   
    public static void Hit(Game deck, List<Card> hand)
    {
        hand.add(deck.drawCard());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        handvalue = 0;
        for(int i=0; i<aHand.length; i++)
        {
            handvalue += aHand[i].getValue();
            if(aHand[i].getValue()==11)
            {
                AceCounter++;
            }
            while(AceCounter>0 && handvalue>21)
            {
                handvalue-=10;
                AceCounter--;
            }
        }
    }
  
    public static boolean isHitorStand(String hitter)
    {
        if(hitter.equals("hit") || hitter.equals("stand"))
        {
            return true;
        }
        return false;
    }
   
    public static boolean checkBust(int handvalue)
    {
        if(handvalue>21)
        {
            System.out.println("You have lost!");
            return true;
        }
        return false;
    }
    
    public static boolean isyesorno(String answer)
    {
        if(answer.equals("yes") || answer.equals("no"))
        {
            return true;
        }
        return false;
    }
    
    public static void fivecardtrick()
    {
        System.out.println("Yipieee,you achieved five tricks!!!!");
        Win();
    }
}
