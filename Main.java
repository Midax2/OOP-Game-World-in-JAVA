import SourceFiles.*;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.AddOrganismsToWorld();
        game.Control();
    }
}