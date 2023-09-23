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

        System.out.println("\nStack 1");
        System.out.println(suit.list.get(0).pop());
        System.out.println(suit.list.get(0).pop());
        System.out.println(suit.list.get(0).pop());

        System.out.println("Stack 2");
        System.out.println(suit.list.get(1).pop());
        System.out.println(suit.list.get(1).pop());
        System.out.println(suit.list.get(1).pop());
    }
    
}
