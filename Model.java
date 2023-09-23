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

    /*
     * Colors for each suits
     */
    String RESET = "\u001B[0m";     /* Not Used */
    String RED = "\u001B[31m";      /* Used for Heart and Diamonds */
    String GREEN = "\u001B[32m";    /* Not Used */
    String YELLOW = "\u001B[33m";   /* Used for Spades and Clubs */

    /*
     * List for the cards
     */
    private ArrayList<String> Suit_heart = new ArrayList<>();
    private ArrayList<String> Suit_dimond = new ArrayList<>();
    private ArrayList<String> Suit_spades = new ArrayList<>();
    private ArrayList<String> Suit_clubs = new ArrayList<>();
    
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
    

    public ArrayList<Stack<String>> list = new ArrayList<Stack<String>>();

    

    public void fill_suits()
    {
        /*
         * Fill Hearts
         */
        for(int i = 1; i <= 13; i++)
        {
            switch(i)
            {
                case 1:
                    Suit_heart.add(this.RED + Suits.H + "A");
                break;

                case 11:
                    Suit_heart.add(this.RED + Suits.H + "J");
                break;

                case 12:
                    Suit_heart.add(this.RED + Suits.H + "Q");
                break;
                case 13:
                    Suit_heart.add(this.RED + Suits.H + "K");
                break;

                default:
                    Suit_heart.add(this.RED + Suits.H + Integer.toString(i));
                break;
            }
            
        }

        /*
         * Fill Diamond
         */
        for(int i = 1; i <= 13; i++)
        {
            switch(i)
            {
                case 1:
                    Suit_dimond.add(this.RED + Suits.D + "A");
                break;

                case 11:
                    Suit_dimond.add(this.RED + Suits.D + "J");
                break;

                case 12:
                    Suit_dimond.add(this.RED + Suits.D + "Q");
                break;
                case 13:
                    Suit_dimond.add(this.RED + Suits.D + "K");
                break;

                default:
                    Suit_dimond.add(this.RED + Suits.D + Integer.toString(i));
                break;
            }
            
        }

        /*
         * Fill Spades
         */
        for(int i = 1; i <= 13; i++)
        {
            switch(i)
            {
                case 1:
                    Suit_spades.add(this.YELLOW + Suits.S + "A");
                break;

                case 11:
                    Suit_spades.add(this.YELLOW + Suits.S + "J");
                break;

                case 12:
                    Suit_spades.add(this.YELLOW + Suits.S + "Q");
                break;
                case 13:
                    Suit_spades.add(this.YELLOW + Suits.S + "K");
                break;

                default:
                    Suit_spades.add(this.YELLOW + Suits.S + Integer.toString(i));
                break;
            }
        }

        /*
         * Fill Clubs
         */
        for(int i = 1; i <= 13; i++)
        {
            switch(i)
            {
                case 1:
                    Suit_clubs.add(this.YELLOW + Suits.C + "A");
                break;

                case 11:
                    Suit_clubs.add(this.YELLOW + Suits.C + "J");
                break;

                case 12:
                    Suit_clubs.add(this.YELLOW + Suits.C + "Q");
                break;
                case 13:
                    Suit_clubs.add(this.YELLOW + Suits.C + "K");
                break;

                default:
                    Suit_clubs.add(this.YELLOW + Suits.C + Integer.toString(i));
                break;
            }
        }
    }

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
        common_deck.addAll(0, Suit_clubs);
        common_deck.addAll(0, Suit_spades);
        common_deck.addAll(0, Suit_heart);
        common_deck.addAll(0, Suit_dimond);

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



}