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


    
        String card = suit.list.get(0).peek();
        char color = suit.getCardColor(card);
        
        System.out.println(card + " color is: " + color);

        //To check the logic of the card hierarchy.
        System.out.println("Status is : " + suit.checkCardHierarchy("02", "01"));
        System.out.println("Status is : " + suit.checkCardHierarchy("02","03"));
    }
    
}
