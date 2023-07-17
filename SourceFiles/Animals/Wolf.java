package SourceFiles.Animals;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Wolf extends Animal {

    public Wolf(World world) {
        this.world = world;
        initiative = 5;
        power = 9;
        Random random = new Random();
        do {
            this.X = random.nextInt(world.GetWidth()) + 1;
            this.Y = random.nextInt(world.GetHeight()) + 1;
        } while (world.GetElement(GetX(), GetY()) != ' ');
        identity = 'W';
        name = "Wolf";
        alive = true;
        generation = 1;
        color = new Color(150, 150, 150);
    }

    public Wolf(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 5;
        power = 9;
        this.X = X;
        this.Y = Y;
        identity = 'W';
        name = "Wolf";
        alive = true;
        this.generation = generation;
        color = new Color(150, 150, 150);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Wolf(world, X, Y, generation + 1);
    }
}
