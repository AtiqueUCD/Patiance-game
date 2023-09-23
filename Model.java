import java.util.*;

public class Model{
    
    /*
     * Helper Enum for building the Suits; Only for initialization
     */
    enum Suits{
        H,
        S,
        C,
        D
    }

    String[] _suits = new String[]{"H", "S", "C", "D"}; 

    /*
     * Colors for each suits
     */
    String RESET = "\u001B[0m";     /* Not Used */
    String RED = "\u001B[31m";      /* Used for Heart and Diamonds */
    String GREEN = "\u001B[32m";    /* Not Used */
    String YELLOW = "\u001B[33m";   /* Used for Spades and Clubs */
    String[] colors = new String[]{RED, YELLOW};

    /*
     * List for the cards
     */
    private ArrayList<String> Suit_heart = new ArrayList<>();
    private ArrayList<String> Suit_dimond = new ArrayList<>();
    private ArrayList<String> Suit_spades = new ArrayList<>();
    private ArrayList<String> Suit_clubs = new ArrayList<>();

    public ArrayList<ArrayList<String>> init_deck = new ArrayList<ArrayList<String>>();
    
    /*
     * List for shuffing all the cards
     */
    public ArrayList<String> common_deck = new ArrayList<>();

    public Stack<String> stack_draw = new Stack<String>();
    public Stack<String> stack_play_1 = new Stack<String>();
    public Stack<String> stack_play_2 = new Stack<String>();
    public Stack<String> stack_play_3 = new Stack<String>();
    public Stack<String> stack_play_4 = new Stack<String>();
    public Stack<String> stack_play_5 = new Stack<String>();
    public Stack<String> stack_play_6 = new Stack<String>();
    public Stack<String> stack_play_7 = new Stack<String>();
    

    /*
     * Contains all the stacks
     */
    public ArrayList<Stack<String>> list = new ArrayList<Stack<String>>();

    

    public void fill_suits()
    {
        String current_color = "";

        init_deck.add(Suit_dimond);
        init_deck.add(Suit_heart);
        init_deck.add(Suit_spades);
        init_deck.add(Suit_clubs);

        for(int j = 0; j < 4; j++)
        {
            if(j < 3)
            {
                current_color = colors[0];
            }else{
                current_color = colors[1];
            }

            for(int i = 1; i <= 13; i++)
            {
                switch(i)
                {
                    case 1:
                        init_deck.get(j).add(current_color + _suits[j] + "A");
                    break;

                    case 11:
                        init_deck.get(j).add(current_color + _suits[j] + "J");
                    break;

                    case 12:
                        init_deck.get(j).add(current_color + _suits[j] + "Q");
                    break;
                    
                    case 13:
                        init_deck.get(j).add(current_color + _suits[j] + "K");
                    break;

                    default:
                        init_deck.get(j).add(current_color + _suits[j] + Integer.toString(i));
                    break;
                }
            }
            
        }
    }

    /*
     * Only for testing
     */
    public String getCards(int index, String suit)
    {
        String temp = "";
        switch(suit)
        {
            case "H":
                temp = Suit_heart.get(index);
            break;

            case "D":
                temp = Suit_dimond.get(index);
            break;

            case "S":
                temp = Suit_spades.get(index);
            break;

            case "C":
                temp = Suit_clubs.get(index);
            break;
        } 

        return temp;
    }

    public void fill_and_shuffle_deck()
    {
        /*
         * Combined all the decks in to a single common deck
         */
        common_deck.addAll(0, init_deck.get(0));
        common_deck.addAll(0, init_deck.get(1));
        common_deck.addAll(0, init_deck.get(2));
        common_deck.addAll(0, init_deck.get(3));

        /*
         * Shufffle the deck
         */
        Collections.shuffle(common_deck);

        /*
         * Added cards to each individual stack
         */
        String temp = "";
        System.out.println("Size of common deck = " + common_deck.size());
        for(int i = 0; i < common_deck.size(); i++)
        {
            temp = common_deck.get(i);

            if(i == 0)
                stack_play_1.push(temp);
            else if(i < 3)
                stack_play_2.push(temp);
            else if(i < 6)
                stack_play_3.push(temp);
            else if(i < 10)
                stack_play_4.push(temp);
            else if(i < 15)
                stack_play_5.push(temp);
            else if(i < 21)
                stack_play_6.push(temp);
            else if(i < 28)
                stack_play_7.push(temp);
            else if(i < 52)
                stack_draw.push(temp);
        }

        /*
         * Add the stack to the list
         */
        list.add(0, stack_play_1);
        list.add(1, stack_play_2);
        list.add(2, stack_play_3);
        list.add(3, stack_play_4);
        list.add(4, stack_play_5);
        list.add(5, stack_play_6);
        list.add(6, stack_play_7);
        list.add(7, stack_draw);
    }

    /*
     * Note : to check the color of any card.
     */
    public char getCardColor(String card)
    {
        char color = 'Z';//Initialize to a random color.
        switch(card.charAt(5))  //The index is 5 because the string also contains colors, so we need to by pass the color and get the actual string
        {
            /*
             * For Diamond and Heart the color will be RED
             */
            case 'D':
            case 'H':
                color = 'R';
            break;

            /*
             * For Spades and Clubs the color will be yellow.
             */
            case 'S':
            case 'C':
                color = 'Y';
            break;
        }

        return color;
    }

    /*
     * Note : pair = pick-up card + place card.
     *        place card > pick-up card = true else false.
     * 
     */
    public boolean checkCardHierarchy(String Pickup, String Place)
    {
        boolean status = false;
        
        int pick_up = Integer.parseInt(Pickup);
        int place = Integer.parseInt(Place);

        
        if((place - pick_up) == 1)//Will only work for nos.
        {
            status = true;
        }

        return status;
    }

}