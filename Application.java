public class Application {
    public static void main(String[] args)
    {
        Model player_1 = new Model();
        player_1.fill_suits();
        player_1.fill_and_shuffle_deck();
        Presenter.display_suit(player_1);
    }
}
