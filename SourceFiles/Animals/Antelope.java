package SourceFiles.Animals;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Antelope extends Animal {
    private boolean isRunning;

    public Antelope(World world) {
        this.world = world;
        initiative = 4;
        power = 4;
        Random random = new Random();
        int width = world.GetWidth();
        int height = world.GetHeight();
        do {
            int x = random.nextInt(width) + 1;
            int y = random.nextInt(height) + 1;
            X = x;
            Y = y;
        } while (this.world.GetElement(X, Y) != ' ');
        identity = 'A';
        name = "Antelope";
        generation = 1;
        isRunning = false;
        alive = true;
        color = new Color(100, 0, 0);
    }

    public Antelope(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 4;
        power = 4;
        this.X = X;
        this.Y = Y;
        identity = 'A';
        name = "Antelope";
        this.generation = generation;
        isRunning = false;
        alive = true;
        color = new Color(100, 0, 0);
    }

    @Override
    public void Action() {
        super.Action();
        Random rd = new Random();
        if (rd.nextInt(2) == 1) {
            super.Action();
        }
    }

    @Override
    public void Collision(Organism organism) {
        if (organism == null) return;
        if (isRunning) {
            if (organism.GetPower() > GetPower()) {
                if (world.GetType() == "Quad") {
                    for (int i = GetY() - 1; i <= GetY() + 1; i++) {
                        for (int j = GetX() - 1; j <= GetX() + 1; j++) {
                            if (world.GetElement(j, i) == ' ') {
                                SetX(j);
                                SetY(i);
                                isRunning = false;
                                String message = "Antelope run away from " + organism.GetName() + " to X = " + GetX() + ", Y = " + GetY();
                                world.AddMessage(message);
                                return;
                            }
                        }
                    }
                }
                else {
                    for (int i = 0; i < 6; i++) {
                        int x = GetX() + dx[i];
                        int y = GetY() + dy[i];
                        if (world.GetElement(x, y) == ' ') {
                            SetX(x);
                            SetY(y);
                            isRunning = false;
                            String message = "Antelope run away from " + organism.GetName() + " to X = " + GetX() + ", Y = " + GetY();
                            world.AddMessage(message);
                            return;
                        }
                    }
                }
            }
        }
        super.Collision(organism);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Antelope(world, X, Y, generation + 1);
    }

    public boolean RunAway(Organism organism) {
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            isRunning = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean GetIsRunning() {
        return isRunning;
    }

    public void SetIsRunning(boolean run) {
        this.isRunning = run;
    }

}
