package SourceFiles.Plants;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Grass extends Plant {
    public Grass(World world) {
        this.world = world;
        initiative = 0;
        power = 0;
        Random rand = new Random();
        do {
            X = rand.nextInt(world.GetWidth()) + 1;
            Y = rand.nextInt(world.GetHeight()) + 1;
        } while (world.GetElement(X, Y) != ' ');
        identity = 'G';
        name = "Grass";
        alive = true;
        generation = 1;
        color = new Color(0, 255, 0);
    }

    public Grass(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 0;
        power = 0;
        this.X = X;
        this.Y = Y;
        identity = 'G';
        name = "Grass";
        alive = true;
        this.generation = generation;
        color = new Color(0, 255, 0);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Grass(world, X, Y, generation + 1);
    }
}
