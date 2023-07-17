package SourceFiles.Plants;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Guarana extends Plant {

    public Guarana(World world) {
        this.world = world;
        initiative = 0;
        power = 0;
        Random rand = new Random();
        do {
            this.X = rand.nextInt(world.GetWidth()) + 1;
            this.Y = rand.nextInt(world.GetHeight()) + 1;
        } while (world.GetElement(X, Y) != ' ');
        identity = 'U';
        name = "Guarana";
        alive = true;
        generation = 1;
        color = new Color(0, 150, 100);
    }

    public Guarana(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 0;
        power = 0;
        this.X = X;
        this.Y = Y;
        identity = 'U';
        name = "Guarana";
        alive = true;
        this.generation = generation;
        color = new Color(0, 150, 100);
    }

    @Override
    public void Collision(Organism organism) {
        if (organism == null) return;
        organism.SetPower(organism.GetPower() + 3);
        world.DeleteOrganism(GetMe());
        String message = organism.GetName() + " has eaten Guarana and got 3 more power at X = " + X + ",Y = " + Y;
        world.AddMessage(message);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Guarana(world, X, Y, generation + 1);
    }

    @Override
    public boolean IsEatenDebuff(Organism organism) {
        return true;
    }
}
