package SourceFiles.Plants;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Dandelion extends Plant {
    public Dandelion(World world) {
        this.world = world;
        initiative = 0;
        power = 0;
        Random random = new Random();
        do {
            this.X = random.nextInt(world.GetWidth()) + 1;
            this.Y = random.nextInt(world.GetHeight()) + 1;
        } while (world.GetElement(X, Y) != ' ');
        identity = 'D';
        name = "Dandelion";
        alive = true;
        generation = 1;
        color = new Color(150, 100, 100);
    }

    public Dandelion(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 0;
        power = 0;
        this.X = X;
        this.Y = Y;
        identity = 'D';
        name = "Dandelion";
        alive = true;
        this.generation = generation;
        color = new Color(150, 100, 100);
    }

    public void Action() {
        for (int trying = 0; trying < 3; trying++) {
            Random random = new Random();
            int isMoving = random.nextInt(2) + 1;
            if (isMoving == 2) {
                super.Action();
                break;
            }
        }
    }

    public Organism NewBorn(int X, int Y) {
        return new Dandelion(world, X, Y, generation + 1);
    }
}
