package SourceFiles.Plants;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Belladonna extends Plant {
    public Belladonna(World world) {
        this.world = world;
        initiative = 0;
        power = 99;
        Random random = new Random();
        do {
            this.X = random.nextInt(world.GetWidth()) + 1;
            this.Y = random.nextInt(world.GetHeight()) + 1;
        } while (world.GetElement(X, Y) != ' ');
        identity = 'B';
        name = "Belladonna";
        generation = 1;
        alive = true;
        color = new Color(20, 100, 100);
    }

    public Belladonna(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 0;
        power = 99;
        this.X = X;
        this.Y = Y;
        identity = 'B';
        name = "Belladonna";
        alive = true;
        this.generation = generation;
        color = new Color(20, 100, 100);
    }

    @Override
    public void Collision(Organism organism) {
        if (organism == null) {
            return;
        }
        organism.SetAlive(false);
        this.SetAlive(false);
        world.DeleteOrganism(GetMe());
        world.DeleteOrganism(organism);
        String message = organism.GetName() + " dead after eating Belladonna at X = " + X + "Y = " + Y;
        world.AddMessage(message);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Belladonna(world, X, Y, generation + 1);
    }

    @Override
    public boolean IsEatenDebuff(Organism organism) {
        return true;
    }
}
