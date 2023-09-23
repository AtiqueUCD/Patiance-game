import java.util.ArrayList;
import java.util.Collections;
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


    public void fill_suits()
    {
        /*
         * Fill Hearts
         */
        for(int i = 0; i < 13; i++)
        {
            switch(i)
            {
                case 0:
                    Suit_heart.add(this.RED + Suits.H + "A");
                break;

                case 10:
                    Suit_heart.add(this.RED + Suits.H + "J");
                break;

                case 11:
                    Suit_heart.add(this.RED + Suits.H + "Q");
                break;
                case 12:
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
        for(int i = 0; i < 13; i++)
        {
            switch(i)
            {
                case 0:
                    Suit_dimond.add(this.RED + Suits.D + "A");
                break;

                case 10:
                    Suit_dimond.add(this.RED + Suits.D + "J");
                break;

                case 11:
                    Suit_dimond.add(this.RED + Suits.D + "Q");
                break;
                case 12:
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
        for(int i = 0; i < 13; i++)
        {
            switch(i)
            {
                case 0:
                    Suit_spades.add(this.YELLOW + Suits.S + "A");
                break;

                case 10:
                    Suit_spades.add(this.YELLOW + Suits.S + "J");
                break;

                case 11:
                    Suit_spades.add(this.YELLOW + Suits.S + "Q");
                break;
                case 12:
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
        for(int i = 0; i < 13; i++)
        {
            switch(i)
            {
                case 0:
                    Suit_clubs.add(this.YELLOW + Suits.C + "A");
                break;

                case 10:
                    Suit_clubs.add(this.YELLOW + Suits.C + "J");
                break;

                case 11:
                    Suit_clubs.add(this.YELLOW + Suits.C + "Q");
                break;
                case 12:
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
        common_deck.addAll(0, Suit_clubs);
        common_deck.addAll(0, Suit_spades);
        common_deck.addAll(0, Suit_heart);
        common_deck.addAll(0, Suit_dimond);
    }

}