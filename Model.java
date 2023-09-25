import java.util.*;

public class Model{
    
    String[] _suits = new String[]{"H", "D", "C", "S"}; 

    public final int DRAW_COMMAND = 8;

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

    public Stack<String> stack_draw_A = new Stack<String>();
    public Stack<String> stack_draw_B = new Stack<String>();
    public Stack<String> stack_play_1 = new Stack<String>();
    public Stack<String> stack_play_2 = new Stack<String>();
    public Stack<String> stack_play_3 = new Stack<String>();
    public Stack<String> stack_play_4 = new Stack<String>();
    public Stack<String> stack_play_5 = new Stack<String>();
    public Stack<String> stack_play_6 = new Stack<String>();
    public Stack<String> stack_play_7 = new Stack<String>();
    public Stack<String> stack_draw = new Stack<String>();
    
    /*
     * Contains all the stacks
     */
    public ArrayList<Stack<String>> list = new ArrayList<Stack<String>>();


    private boolean draw_stack_ID = false;
    public String draw_card = "";
    private int temp_1 = 0, temp_2 = 0;

    
    public Stack<String> stack_view_play_1 = new Stack<String>();
    public Stack<String> stack_view_play_2 = new Stack<String>();
    public Stack<String> stack_view_play_3 = new Stack<String>();
    public Stack<String> stack_view_play_4 = new Stack<String>();
    public Stack<String> stack_view_play_5 = new Stack<String>();
    public Stack<String> stack_view_play_6 = new Stack<String>();
    public Stack<String> stack_view_play_7 = new Stack<String>();

    public ArrayList<Stack<String>> list_view = new ArrayList<Stack<String>>();
    /*
     * This array is for the transportantion of multiple cards from source arraystack to destination stack
     */
    private String[] transport_array = new String[100];
    private int transport_counter = 0;

    public void fill_suits()
    {
        String current_color = "";

        init_deck.add(Suit_dimond);
        init_deck.add(Suit_heart);
        init_deck.add(Suit_spades);
        init_deck.add(Suit_clubs);

        for(int j = 0; j < 4; j++)
        {
            if(j < 2)
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
                        init_deck.get(j).add(current_color + _suits[j] + "0A");
                    break;

                    case 11:
                        init_deck.get(j).add(current_color + _suits[j] + "0J");
                    break;

                    case 12:
                        init_deck.get(j).add(current_color + _suits[j] + "0Q");
                    break;
                    
                    case 13:
                        init_deck.get(j).add(current_color + _suits[j] + "0K");
                    break;

                    case 10:
                    init_deck.get(j).add(current_color + _suits[j] + "10");
                    break;

                    default:
                        init_deck.get(j).add(current_color + _suits[j] + "0" + Integer.toString(i));
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
            {
                stack_play_2.push(temp);
                stack_view_play_2.push("xxx");
            }
            else if(i < 6)
            {
                stack_play_3.push(temp);
                stack_view_play_3.push("xxx");
            }
            else if(i < 10)
            {
                stack_play_4.push(temp);
                stack_view_play_4.push("xxx");
            }
            else if(i < 15)
            {
                stack_play_5.push(temp);
                stack_view_play_5.push("xxx");
            }
            else if(i < 21)
            {
                stack_play_6.push(temp);
                stack_view_play_6.push("xxx");
            }
            else if(i < 28)
            {
                stack_play_7.push(temp);
                stack_view_play_7.push("xxx");
            }
            else if(i < 52)
                stack_draw_A.push(temp);
        }

        /*
         * Add the stack to the list
         */
        list.add(0, stack_draw_A);  //ID 0
        list.add(1, stack_draw_B);  //ID 1
        list.add(2, stack_play_1);
        list.add(3, stack_play_2);
        list.add(4, stack_play_3);
        list.add(5, stack_play_4);
        list.add(6, stack_play_5);
        list.add(7, stack_play_6);
        list.add(8, stack_play_7);
        list.add(9, stack_draw);

        stack_view_play_2.push("xxx");
        stack_view_play_3.push("xxx");
        stack_view_play_4.push("xxx");
        stack_view_play_5.push("xxx");
        stack_view_play_6.push("xxx");
        stack_view_play_7.push("xxx");



        list_view.add(0, stack_view_play_1);
        list_view.add(1, stack_view_play_1);
        list_view.add(2, stack_view_play_1);
        list_view.add(3, stack_view_play_2);
        list_view.add(4, stack_view_play_3);
        list_view.add(5, stack_view_play_4);
        list_view.add(6, stack_view_play_5);
        list_view.add(7, stack_view_play_6);
        list_view.add(8, stack_view_play_7);

        for(int i = 2;i < 9;i++)
        {
            updateViewList(i);
        }

    }

    /*
     * Function name    :- getCardColor
     * Type             :- public
     * Return type      :- char
     * Parameters       :- card (String)
     * Description      :-
     *                      This fucntion returns the color of the card given to it as an argument.
     *                      If the suffix is D or H then the color is Red it will return R,
     *                      and if the suffix is S or C then the color is Yellow it will return Y.
     */
    public static char getCardColor(String card)
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
     * Function name    :- checkCardHierarchy
     * Type             :- public static
     * Return type      :- boolean
     * Parameters       :- Pickup (String), Place (String)
     * Description      :-
     *                      This fucntion checks whether the picked card and the card on which its to be placed should be 
     *                      consicutive. If the cards are consecutive then it will return true else it will return false.
     */
    public static boolean checkCardHierarchy(String Pickup, String Place)
    {
        boolean status = false;
        
        /*
         * Convert the string cards into number for calculating the hierarchy
         */
        switch(Pickup)
        {
            case "0K":
                Pickup = "13";
            break;

            case "0Q":
                Pickup = "12";
            break;

            case "0J":
                Pickup = "11";
            break;

            case "0A":
                Pickup = "1";
            break;
        }


        switch(Place)
        {
            case "0K":
                Place = "13";
            break;

            case "0Q":
                Place = "12";
            break;

            case "0J":
                Place = "11";
            break;

            case "0A":
                Place = "1";
            break;
        }

        int _Pickup = Integer.parseInt(Pickup);
        int _Place = Integer.parseInt(Place);

        if(_Place - _Pickup == 1)
        {
            status = true;
        }
        return status;
    }

    /*
     * Function name    :- checkSwitch
     * Type             :- public
     * Return type      :- boolean
     * Parameters       :- pick_up_card (String), place_card (String)
     * Description      :-
     *                      This fucntion calls getCardColor() and checkCardHierarchy() if the colors of the cards 
     *                      are complimentary and they are consicutive it will return true else false.
     */
    public boolean checkSwitch(String pick_up_card, String place_card, boolean bypass)
    {
        if(bypass)
            return true;

        boolean color_status = false, hirarchy_status = false;
        char pick_up_color = 'Z';
        char place_color = 'Z';
        
        String _act_pick_up_card = pick_up_card.substring(6,8);
        String _act_place_card = place_card.substring(6,8);
        
        //If the colors are complimentry
        pick_up_color = getCardColor(pick_up_card);
        place_color = getCardColor(place_card);

        if(pick_up_color != place_color)
        {
            color_status = true;
            //then check for the hirarchy
            hirarchy_status = Model.checkCardHierarchy(_act_pick_up_card, _act_place_card);
        }
            //else throw error


        return (color_status & hirarchy_status);
    }
    /*
     * Function name    :- processCommand
     * Type             :- public
     * Return type      :- boolean
     * Parameters       :- command (String)
     * Description      :-
     *                      The function handles the command given by the user.
     *                      This fucntion handles the following:-
     *                      1. Rotation of the draw deck.
     *                      2. Single pick
     *                      3. Multiple pick
     *                      4. pick from draw deck
     */
    public boolean processCommand(String command)
    {
        int pick = 0, place = 0, no_of_picks = 0;
        int temp_cnt = 0;
        String c1 = "", c2 = "";
        boolean bypass = false;
        

        int intCommand = Integer.parseInt(command);

        if(intCommand == DRAW_COMMAND)//(command.length() < 2)
        {
            pick = intCommand;
            //Show the cards from the deck.
            temp_1 = (this.draw_stack_ID) ? 1 : 0;
            temp_2 = (!this.draw_stack_ID) ? 1 : 0;

            /*
             * Rotation of the draw deck.
             */
            if(!list.get(temp_1).isEmpty())
            {
                list.get(temp_2).push(list.get(temp_1).pop());
                draw_card = list.get(temp_2).peek();
                if(!list.get(9).isEmpty())
                    list.get(9).pop();
                list.get(9).push(draw_card);
            }else{
                //Change the ID of the draw pingpong logic
                this.draw_stack_ID = !this.draw_stack_ID;
            }

            return true;
            
        }
        else if(command.length() > 2)
        {
            pick =  (intCommand / 100) + 2 ;
            place = ((intCommand % 100) / 10) + 2;
            no_of_picks = (intCommand % 10);
        }
        else{
            pick =  (intCommand / 10) + 2;
            place = (intCommand % 10) + 2;
        }

        //Check for the empty stack
        if(list.get(pick).isEmpty())
            return false;
        else if(list.get(place).isEmpty())
            bypass = true;
        
        //Init the transport counter to zero for the new transaction
        transport_counter = 0;

        String pick_up_card = "";
        String place_card = "";

        //Check if the respective stacks are empty
        if(no_of_picks > 1)
        {

            //Get the cards in the transport array
            while(no_of_picks > 0)
            {
                transport_array[transport_counter++] = list.get(pick).pop();
                no_of_picks--;
            }
            
            if(!bypass)
            {
                temp_cnt = 0;//transport_counter;

                pick_up_card = transport_array[transport_counter - 1];
                place_card = list.get(place).peek();

                /*
                * perform check
                */
                while(transport_counter != (temp_cnt + 1))
                {
                    if(temp_cnt == 0)
                    {
                        c1 = transport_array[temp_cnt];
                        c2 = transport_array[++temp_cnt];
                    }else{
                        c1 = transport_array[temp_cnt];
                        c2 = transport_array[++temp_cnt];
                    }
                    if(!checkSwitch(c1, c2, bypass))
                    {
                        /*Abort transport */
                        System.out.println("Abort transport!!");
                        /*Put the picked data back to the source stack */
                        while(transport_counter > 0)
                        {
                            list.get(pick).push(transport_array[--transport_counter]);
                        }
                        return false;
                    }
                }
            }
            if(checkSwitch(pick_up_card, place_card, bypass))
            {
                System.out.println("Success!!");
                //Push the picked cards to the destination stack
                while(transport_counter > 0)
                {
                    list.get(place).push(transport_array[--transport_counter]);
                }
            }
            else
            {
                System.out.println("UnSuccess!!");

                /*Put the picked data back to the source stack */
                while(transport_counter > 0)
                {
                    list.get(pick).push(transport_array[--transport_counter]);
                }
            }
        }
        else
        {

            if(!bypass)
            {
                //Will only peek over here as if the command is inavlid then the stack should remain untouched.
                pick_up_card = list.get(pick).peek();
                place_card = list.get(place).peek();
            }

            if(pick == 9)
            {
                list.get(temp_2).pop();
            }
            if(checkSwitch(pick_up_card, place_card, bypass))
            {
                list.get(place).push(list.get(pick).pop());
                updateViewList(pick);
            }else{
                System.out.println("Play invalid!!!");
            }
        }
        return true;
    }

    public void updateViewList(int pickup)
    {

        if(pickup > 2 && pickup < 9)
        {
            list_view.get(pickup).pop();
            list_view.get(pickup).pop();
            list_view.get(pickup).push(list.get(pickup).peek());
        }

    }

}