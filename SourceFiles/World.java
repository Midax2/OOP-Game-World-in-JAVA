package SourceFiles;
import java.util.Vector;
public abstract class World {
    protected int height;
    protected int width;
    protected int round;
    protected char[][] worldBoard;
    protected Vector<Organism> organisms;
    protected Vector<String> messages;
    protected String type;

    public void SetOrganismOnPoint(int X, int Y, char identity) {
        worldBoard[Y][X] = identity;
    }

    public void SortOrganisms() {
        organisms.sort((b, a) -> {
            if (a.GetInitiative() != b.GetInitiative()) {
                return Integer.compare(b.GetInitiative(), a.GetInitiative());
            } else {
                return Integer.compare(b.GetGeneration(), a.GetGeneration());
            }
        });
    }

    private void ClearBoard() {
        for (int i = 0; i < (height + 2); i++) {
            for (int j = 0; j < (width + 2); j++) {
                if (i == 0 || i == (height + 1)) continue;
                else {
                    if (j == 0 || j == (width + 1)) continue;
                    else worldBoard[i][j] = ' ';
                }
            }
        }
    }

    public void DoTurn() {
        for (int i = organisms.size() - 1; i >= 0; i--) {
            while (i >= organisms.size()) i--;
            Organism organism = organisms.get(i);
            organism.Action();
            organism.Collision(organism.GetWorld().GetOrganism(organism, organism.GetX(), organism.GetY()));
        }
        ClearBoard();
        for (Organism org : organisms) {
            org.Print();
        }
        round++;
        this.SortOrganisms();
    }

    public void DeleteOrganism(Organism something) {
        organisms.remove(something);
    }


    public void AddOrganism(Organism something) {
        something.Print();
        organisms.add(something);
    }

    public String GetType() {
        return type;
    }

    public char GetElement(int X, int Y) {
        return worldBoard[Y][X];
    }

    public Vector<Organism> GetOrganisms() {
        return organisms;
    }

    public void AddMessage(String message) {
        messages.add(message);
    }

    public String GetMessage(int index) {
        if (index >= messages.size()) {
            return "Nothing";
        }
        return messages.get(index);
    }

    public void ClearMessages() {
        messages.clear();
    }

    public Organism GetOrganism(Organism organismTest, int X, int Y) {
        for (Organism organism : organisms) {
            if (organism.GetX() == X && organism.GetY() == Y && organism != organismTest) {
                return organism;
            }
        }
        return null;
    }

    public int GetHeight() {
        return height;
    }

    public int GetWidth() {
        return width;
    }

    public int GetRound() {
        return round;
    }

    public void SetRound(int round) {
        this.round = round;
    }
}
