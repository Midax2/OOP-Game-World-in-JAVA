package SourceFiles.Animals;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Sheep extends Animal {
    public Sheep(World world) {
        this.world = world;
        initiative = 4;
        power = 4;
        Random random = new Random();
        do {
            X = random.nextInt(world.GetWidth()) + 1;
            Y = random.nextInt(world.GetHeight()) + 1;
        } while (this.world.GetElement(X, Y) != ' ');
        identity = 'S';
        name = "Sheep";
        alive = true;
        generation = 1;
        color = new Color(150, 200, 150);
    }

    public Sheep(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 4;
        power = 4;
        this.X = X;
        this.Y = Y;
        identity = 'S';
        name = "Sheep";
        alive = true;
        this.generation = generation;
        color = new Color(150, 200, 150);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Sheep(world, X, Y, generation + 1);
    }
}
