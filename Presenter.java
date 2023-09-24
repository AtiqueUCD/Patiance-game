import java.util.*;

public class Presenter {

    /*
     * Function for debugging.
     * Displays all the suits.
     */
    public static void display_suit(Model suit)
    {
        for(int i = 0; i < 13; i++)
            System.out.print(suit.getCards(i, "H") + " ");

            System.out.print("\n");

            for(int i = 0; i < 13; i++)
                System.out.print(suit.getCards(i, "D") + " ");

            System.out.print("\n");

            for(int i = 0; i < 13; i++)
                System.out.print(suit.getCards(i, "S") + " ");
            System.out.print("\n");

            for(int i = 0; i < 13; i++)
                System.out.print(suit.getCards(i, "C") + " ");

            System.out.print("\n");

        /*
        * Display the common deck
         */    

        for(String i : suit.common_deck)
        {
            System.out.print(i + " ");
        }

        System.out.println("");

        for(int i = 0; i < 8; i++)
            System.out.println(suit.list.get(i));


    /* 
        String card = suit.list.get(0).peek();
        char color = suit.getCardColor(card);
        
        System.out.println(card + " color is: " + color);

        //To check the logic of the card hierarchy.
        System.out.println("Status is : " + suit.checkCardHierarchy("02", "01"));
        System.out.println("Status is : " + suit.checkCardHierarchy("02","03"));
        System.out.println("Status is : " + suit.checkCardHierarchy("Q","K"));
        System.out.println("Status is : " + suit.checkCardHierarchy("J","K"));
    */ 

    /*
            Presenter.clearScreen();
            boolean card_switch = false;
            System.out.println("Picked card: " + suit.list.get(0).peek());
            System.out.println("Resting card : " + suit.list.get(1).peek());
            card_switch = suit.checkSwitch(suit.list.get(0).peek(), suit.list.get(1).peek());
            System.out.println("Card swicth status : " + card_switch);
            */
            String command = "";
            clearScreen();
            displayPlayGround(suit);
            Scanner in = new Scanner(System.in);
            while(command != "99")
            {
                System.out.print("Your command: ");
                command = in.nextLine();
                if(command == "99")
                    break;
                suit.processCommand(command);
                System.out.println("");
                displayPlayGround(suit);
            }
                
        
    }

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    public static void displayPlayGround(Model suit)
    {
        for(int i = 0; i < 7; i++)
            System.out.println(Integer.toString(i) + "->" + suit.list.get(i));
    }
}
